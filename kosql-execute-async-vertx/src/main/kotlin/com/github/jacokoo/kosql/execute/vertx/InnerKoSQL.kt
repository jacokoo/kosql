package com.github.jacokoo.kosql.execute.vertx

import com.github.jacokoo.kosql.build.*
import com.github.jacokoo.kosql.compose.Compose
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.InnerTable
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.result.Mapper
import com.github.jacokoo.kosql.compose.statement.*
import com.github.jacokoo.kosql.execute.async.Dao
import io.vertx.core.Future
import io.vertx.kotlin.coroutines.await
import com.github.jacokoo.kosql.compose.result.Row as Row2
import io.vertx.sqlclient.SqlClient
import io.vertx.sqlclient.*
import org.slf4j.LoggerFactory
import kotlin.coroutines.*

class InnerKoSQL internal constructor(
    private val kf: KoSQL,
    private val conn: SqlConnection
): Compose(), Dao {
    private var started: Boolean = false

    companion object {
        private val LOG = LoggerFactory.getLogger(InnerKoSQL::class.java.name.substringBefore("\$Companion"))
    }

    suspend fun <T> tx(fn: suspend InnerKoSQL.() -> T): T {
        if (started) {
            return fn()
        }

        val tran = conn.begin().await()
        started = true
        try {
            val re = fn()
            tran.commit()
            return re
        } catch (e: Exception) {
            tran.rollback()
            throw e
        } finally {
            started = false
        }
    }

    override suspend fun <K, T : Table<K, Entity<K>>> execute(update: UpdateStatement<K, T>): Int
            = kf.builder.build(update, context()).let { execute(it).rowCount() }

    override suspend fun execute(delete: DeleteStatement): Int
            = kf.builder.build(delete, context()).let { execute(it).rowCount() }

    override suspend fun <T> execute(insert: InsertStatement<T>): Pair<T, Int>
            = kf.builder.build(insert, context()).let { result ->
        val rs = execute(result)

        val pk = insert.data.table.primaryKey()
        var key = pk.type.nullValue
        if (pk.autoIncrement) {
            key = pk.type.fromDb(kf.getGeneratedKey(rs, insert.data.table))
        }
        key to rs.rowCount()
    }

    override suspend fun <T> execute(insert: BatchInsertStatement<T>): Int
            = kf.builder.build(insert, context()).let { result ->
        val st = prepare(result)
        try {
            val rs = st.query().executeBatch(result.params.map { p ->
                Tuple.tuple(p as List<*>)
            }).await()
            rs.rowCount()
        } finally {
            st.close()
        }
    }

    override suspend fun <T, R : ColumnList> execute(select: SelectStatement<R>, mapper: Mapper<T>): List<T> =
        kf.builder.build(select, context()).let { result ->
            val st = prepare(result)
            val stream = st.createStream(20, result.tuple())
            suspendCoroutine { cont ->
                val list = mutableListOf<T>()
                stream.handler {
                    list.add(mapper.map(Row2({ i -> it.getValue(i) }, select.data.columns)))
                }.endHandler {
                    st.close()
                    cont.resumeWith(Result.success(list))
                }.exceptionHandler {
                    st.close()
                    cont.resumeWith(Result.failure(it))
                }
            }
        }

    private fun context(): Context = kf.contextFactory(kf.builder)
    private fun BuildResult.tuple(): Tuple = Tuple.tuple(params)
    private suspend fun prepare(result: BuildResult): PreparedStatement {
        if (LOG.isDebugEnabled) {
            LOG.debug("execute: {}", result.sql)
            LOG.debug("execute with params: {}", result.params.joinToString(prefix = "(", postfix = ")"))
        }
        return conn.prepare(result.sql).await()
    }
    private suspend fun execute(result: BuildResult): RowSet<Row> {
        val st = prepare(result)
        try {
            return st.query().execute(result.tuple()).await()
        } finally {
            st.close()
        }
    }

}

abstract class KoSQL(
    private val client: SqlClient,
    internal val builder: Builder,
    internal val contextFactory: (Builder) -> Context = { DefaultContext(it) }
) {

    suspend fun <T> tx(fn: suspend InnerKoSQL.() -> T): T = withConnection { conn ->
        InnerKoSQL(this, conn).tx { fn() }
    }

    suspend fun <T> run(fn: suspend InnerKoSQL.() -> T): T = withConnection { conn ->
        InnerKoSQL(this, conn).fn()
    }

    private suspend inline fun <T> withConnection(fn: (SqlConnection) -> T): T =
        openConnection(client).await().let { conn ->
            try {
                fn(conn)
            } finally {
                conn.close().await()
            }
        }

    abstract fun openConnection(client: SqlClient): Future<SqlConnection>
    abstract fun getGeneratedKey(row: RowSet<Row>, table: InnerTable<*, *>): Any
}
