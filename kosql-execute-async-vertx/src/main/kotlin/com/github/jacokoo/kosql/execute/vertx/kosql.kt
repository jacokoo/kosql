package com.github.jacokoo.kosql.execute.vertx

import com.github.jacokoo.kosql.compose.Compose
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.result.Mapper
import com.github.jacokoo.kosql.compose.statement.*
import com.github.jacokoo.kosql.execute.async.Dao
import io.vertx.kotlin.coroutines.await
import io.vertx.sqlclient.SqlConnection
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

// caution: hooks should not throw any exception, otherwise it will confuse the tx caller
abstract class TxHook {
    open suspend fun onSucceeded() {}
    open suspend fun onFailed(e: Throwable) {}
    open suspend fun onCompleted() {}
}

open class InnerKoSQL internal constructor(
    internal val kf: KoSQL,
    internal val conn: SqlConnection
): Compose(), Dao {

    override suspend fun <K, T : Table<K, Entity<K>>> execute(update: UpdateStatement<K, T>): Int
        = kf.client.execute(conn, update)

    override suspend fun execute(delete: DeleteStatement): Int
        = kf.client.execute(conn, delete)

    override suspend fun <T> execute(insert: InsertStatement<T>): T
        = kf.client.execute(conn, insert)

    override suspend fun <T> execute(insert: BatchInsertStatement<T>): List<T>
        = kf.client.execute(conn, insert)

    override suspend fun <T, R : ColumnList> execute(select: SelectStatement<R>, mapper: Mapper<T>): List<T>
        = kf.client.execute(conn, select, mapper)

}

private val txLogger = LoggerFactory.getLogger(InnerTxKoSQL::class.java)

class InnerTxKoSQL internal constructor(
    kf: KoSQL, conn: SqlConnection
): InnerKoSQL(kf, conn) {

    internal constructor(inner: InnerKoSQL): this(inner.kf, inner.conn)

    private var started: Boolean = false
    private val hooks = mutableListOf<TxHook>()
    private var hooksLocked = false

    suspend fun <T> tx(fn: suspend InnerTxKoSQL.() -> T): T {
        if (started) {
            return fn()
        }

        return try {
            doTx(fn).apply {
                invokeHooks { it.onSucceeded() }
            }
        } catch (e: Throwable) {
            invokeHooks { it.onFailed(e) }
            throw e
        } finally {
            invokeHooks { it.onCompleted() }
        }
    }

    private suspend fun <T> doTx(fn: suspend InnerTxKoSQL.() -> T): T {
        val tran = conn.begin().await()
        started = true
        return try {
            fn().apply { tran.commit().await() }
        } catch (e: Exception) {
            tran.rollback()
            throw e
        } finally {
            lockHook()
            started = false
        }
    }

    fun addHook(hook: TxHook) {
        if (hooksLocked) throw RuntimeException("Can not add hook when tx is completed")
        hooks.add(hook)
    }

    private fun lockHook() {
        hooksLocked = true
        hooks.reverse()
    }

    private inline fun invokeHooks(fn: (TxHook) -> Unit) {
        try {
            hooks.forEach { fn(it) }
        } catch (e: Throwable) {
            txLogger.error("Exception occurred while invoke hooks, which is not expected, will drop it", e)
        }
    }

}

abstract class KoSQL(
    internal val client: KoSQLClient,
) {
    suspend fun <T> tx(fn: suspend InnerTxKoSQL.() -> T): T = withInner(true) { (it as InnerTxKoSQL).tx(fn) }

    suspend fun <T> run(fn: suspend InnerKoSQL.() -> T): T = withInner { it.fn() }

    private suspend inline fun <T> withInner(withTx: Boolean = false, crossinline fn: suspend (InnerKoSQL) -> T): T {
        val el = coroutineContext[InnerElement.KEY]
        if (el != null) {
            if (withTx && el.inner !is InnerTxKoSQL) {
                val it = InnerTxKoSQL(el.inner)
                return withContext(InnerElement(it)) { fn(it) }
            }
            return fn(el.inner)
        }

        val conn = client.openConnection().await()
        val inner = if (withTx) InnerTxKoSQL(this, conn) else InnerKoSQL(this, conn)
        try {
            return withContext(InnerElement(inner)) { fn(inner) }
        } finally {
            conn.close().await()
        }
    }

    internal class InnerElement(val inner: InnerKoSQL): CoroutineContext.Element {
        companion object {
            internal val KEY = object: CoroutineContext.Key<InnerElement> {}
        }
        override val key: CoroutineContext.Key<*> = KEY
    }

    protected val InnerKoSQL.connection get() = conn
}
