package com.github.jacokoo.kosql.execute.vertx

import com.github.jacokoo.kosql.build.BuildResult
import com.github.jacokoo.kosql.build.Builder
import com.github.jacokoo.kosql.build.Context
import com.github.jacokoo.kosql.build.DefaultContext
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.InnerTable
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.result.Mapper
import com.github.jacokoo.kosql.compose.statement.*
import io.vertx.core.Future
import io.vertx.kotlin.coroutines.await
import io.vertx.sqlclient.*
import org.slf4j.LoggerFactory
import kotlin.coroutines.suspendCoroutine
import com.github.jacokoo.kosql.compose.result.Row as Row2

interface KoSQLClient {
    val builder: Builder
    val contextFactory: (Builder) -> Context

    fun openConnection(): Future<SqlConnection>
    fun getGeneratedKey(row: RowSet<Row>, table: InnerTable<*, *>): Any

    suspend fun <K, T: Table<K, Entity<K>>>execute(conn: SqlConnection, update: UpdateStatement<K, T>): Int
    suspend fun execute(conn: SqlConnection, delete: DeleteStatement): Int
    suspend fun <T> execute(conn: SqlConnection, insert: InsertStatement<T>): Pair<T, Int>
    suspend fun <T> execute(conn: SqlConnection, insert: BatchInsertStatement<T>): Int
    suspend fun <T, R: ColumnList> execute(conn: SqlConnection, select: SelectStatement<R>, mapper: Mapper<T>): List<T>
}

private val LOG = LoggerFactory.getLogger(KoSQLClient::class.java.name)

abstract class AbstractKoSQLClient(
    override val builder: Builder,
    override val contextFactory: (Builder) -> Context = { DefaultContext(it) }
): KoSQLClient {
    override suspend fun <K, T : Table<K, Entity<K>>> execute(conn: SqlConnection, update: UpdateStatement<K, T>): Int
        = builder.build(update, contextFactory(builder)).let { execute(conn, it).rowCount() }

    override suspend fun execute(conn: SqlConnection, delete: DeleteStatement): Int
        = builder.build(delete, contextFactory(builder)).let { execute(conn, it).rowCount() }

    override suspend fun <T> execute(conn: SqlConnection, insert: InsertStatement<T>): Pair<T, Int>
        = builder.build(insert, contextFactory(builder)).let { result ->
        val rs = execute(conn, result)

        val pk = insert.data.table.primaryKey()
        var key = pk.type.nullValue
        if (pk.autoIncrement) {
            key = pk.type.fromDb(getGeneratedKey(rs, insert.data.table))
        }
        key to rs.rowCount()
    }

    override suspend fun <T> execute(conn: SqlConnection, insert: BatchInsertStatement<T>): Int
        = builder.build(insert, contextFactory(builder)).let { result ->
        val st = prepare(conn, result)
        try {
            val rs = st.query().executeBatch(result.params.map { p ->
                Tuple.tuple(p as List<*>)
            }).await()
            rs.rowCount()
        } finally {
            st.close()
        }
    }

    override suspend fun <T, R : ColumnList> execute(conn: SqlConnection, select: SelectStatement<R>, mapper: Mapper<T>): List<T> =
        builder.build(select, contextFactory(builder)).let { result ->
            val st = prepare(conn, result)
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

    private fun BuildResult.tuple(): Tuple = Tuple.tuple(params)
    private suspend fun prepare(conn: SqlConnection, result: BuildResult): PreparedStatement {
        if (LOG.isDebugEnabled) {
            LOG.debug("execute: {}", result.sql)
            LOG.debug("execute with params: {}", result.params.joinToString(prefix = "(", postfix = ")"))
        }
        return conn.prepare(result.sql).await()
    }
    private suspend fun execute(conn: SqlConnection, result: BuildResult): RowSet<Row> {
        val st = prepare(conn, result)
        try {
            return st.query().execute(result.tuple()).await()
        } finally {
            st.close()
        }
    }
}
