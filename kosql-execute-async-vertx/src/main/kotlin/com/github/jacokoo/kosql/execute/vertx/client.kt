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
import com.github.jacokoo.kosql.compose.result.Row as Row2

interface KoSQLClient {
    val builder: Builder
    val contextFactory: (Builder) -> Context

    fun openConnection(): Future<SqlConnection>
    fun getGeneratedKey(row: RowSet<Row>, table: InnerTable<*, *>): Any

    suspend fun <K, T: Table<K, Entity<K>>> execute(conn: SqlConnection, update: UpdateStatement<K, T>): Int
    suspend fun execute(conn: SqlConnection, delete: DeleteStatement): Int
    suspend fun <T> execute(conn: SqlConnection, insert: InsertStatement<T>): T
    suspend fun <T> execute(conn: SqlConnection, insert: BatchInsertStatement<T>): List<T>
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

    override suspend fun <T> execute(conn: SqlConnection, insert: InsertStatement<T>): T
        = builder.build(insert, contextFactory(builder)).let { result ->
        val rs = execute(conn, result)

        val pk = insert.data.table.primaryKey()
        if (pk.autoIncrement) {
            pk.type.fromDb(getGeneratedKey(rs, insert.data.table))
        } else {
            pk.type.nullValue
        }
    }

    override suspend fun <T> execute(conn: SqlConnection, insert: BatchInsertStatement<T>): List<T>
        = builder.build(insert, contextFactory(builder)).let { result ->
        val st = prepare(conn, result)
        try {
            val rs = st.query().executeBatch(result.params.map { p ->
                Tuple.tuple(p as List<*>)
            }).await()

            val pk = insert.data.table.primaryKey()
            if (!pk.autoIncrement) {
                List(result.params.size) { pk.type.nullValue }
            } else {
                val re = mutableListOf<T>()
                var trs = rs
                while (trs != null) {
                    re.add(pk.type.fromDb(getGeneratedKey(trs, insert.data.table)))
                    trs = trs.next()
                }
                re
            }
        } finally {
            st.close()
        }
    }

    override suspend fun <T, R : ColumnList> execute(conn: SqlConnection, select: SelectStatement<R>, mapper: Mapper<T>): List<T> =
        builder.build(select, contextFactory(builder)).let { result ->
            prepare(conn, result).query().execute(result.tuple()).await().let { rs ->
                rs.map { mapper.map(Row2({i -> it.getValue(i) }, select.data.columns)) }
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
