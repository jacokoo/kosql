package com.github.jacokoo.kosql.execute.vertx

import com.github.jacokoo.kosql.build.*
import com.github.jacokoo.kosql.compose.Compose
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.execute.async.Use
import com.github.jacokoo.kosql.compose.result.Mapper
import com.github.jacokoo.kosql.compose.statement.*
import com.github.jacokoo.kosql.execute.async.Dao
import com.github.jacokoo.kosql.compose.result.Row as Row2
import io.vertx.kotlin.coroutines.awaitResult
import io.vertx.sqlclient.SqlClient
import io.vertx.sqlclient.*
import org.slf4j.LoggerFactory
import kotlin.coroutines.suspendCoroutine

class KoSQL<B: Builder> internal constructor(
    private val kf: KoSQLFactory<B>,
    private val conn: SqlConnection
): Compose(), Use, Dao {
    private var started: Boolean = false

    companion object {
        private val LOG = LoggerFactory.getLogger(KoSQL::class.java.name.substringBefore("\$Companion"))
    }

    suspend fun <T> tx(fn: suspend KoSQL<B>.() -> T): T {
        if (started) {
            return fn()
        }

        val tran = conn.begin()
        started = true
        try {
            val re = fn()
            tran.commit()
            started = false
            return re
        } catch (e: Exception) {
            tran.rollback()
            throw e
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
            key = pk.type.fromDb(kf.getGeneratedKey(rs))
        }
        key to rs.rowCount()
    }

    override suspend fun <T> execute(insert: BatchInsertStatement<T>): Int
            = kf.builder.build(insert, context()).let { result ->
        val st = prepare(result)
        val rs = awaitResult<RowSet<Row>> { st.query().executeBatch(result.params.map {p ->
            Tuple.tuple(p as List<*>)
        }, it)}
        rs.rowCount()
    }

    override suspend fun <T, R : ColumnList> execute(select: SelectStatement<R>, mapper: Mapper<T>): List<T> =
        kf.builder.build(select, context()).let { result ->
            val stream = prepare(result).createStream(20, result.tuple())
            suspendCoroutine { cont ->
                val list = mutableListOf<T>()
                stream.handler {
                    list.add(mapper.map(Row2({ i -> it.getValue(i) }, select.data.columns)))
                }.endHandler {
                    cont.resumeWith(Result.success(list))
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
        return awaitResult { conn.prepare(result.sql, it) }
    }
    private suspend fun execute(result: BuildResult): RowSet<Row> {
        val st = prepare(result)
        return awaitResult { st.query().execute(result.tuple(), it) }
    }

}

abstract class KoSQLFactory<B: Builder>(
    private val client: SqlClient,
    internal val builder: B,
    internal val contextFactory: (B) -> Context = { DefaultContext(it) }
) {

    suspend fun <T> tx(fn: suspend KoSQL<B>.() -> T): T {
        val conn = openConnection(client)
        try {
            return KoSQL(this, conn).tx { fn() }
        } finally {
            conn.close()
        }
    }

    suspend fun <T> run(fn: suspend KoSQL<B>.() -> T): T {
        val conn = openConnection(client)
        try {
            return KoSQL(this, conn).fn()
        } finally {
            conn.close()
        }
    }

    abstract suspend fun openConnection(client: SqlClient): SqlConnection
    abstract fun getGeneratedKey(row: RowSet<Row>): Any
}