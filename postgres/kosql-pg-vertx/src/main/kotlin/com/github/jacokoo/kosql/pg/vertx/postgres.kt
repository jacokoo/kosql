package com.github.jacokoo.kosql.pg.vertx

import com.github.jacokoo.kosql.build.pg.PostgresBuilder
import com.github.jacokoo.kosql.build.pg.PostgresContext
import com.github.jacokoo.kosql.compose.InnerTable
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.execute.vertx.AbstractKoSQLClient
import com.github.jacokoo.kosql.execute.vertx.KoSQL
import io.vertx.core.Future
import io.vertx.kotlin.coroutines.await
import io.vertx.pgclient.PgPool
import io.vertx.sqlclient.Row
import io.vertx.sqlclient.RowSet
import io.vertx.sqlclient.SqlClient
import io.vertx.sqlclient.SqlConnection
import org.slf4j.LoggerFactory

class KoSQLPgClient(private val pool: PgPool): AbstractKoSQLClient(
    PostgresBuilder(), { PostgresContext() }
) {
    override fun openConnection(): Future<SqlConnection> = pool.connection
    override fun getGeneratedKey(row: RowSet<Row>, table: InnerTable<*, *>): Any = table.primaryKey().let { key ->
        key.type.fromDb(row.first().getValue(key.name))!!
    }
}

private val logger = LoggerFactory.getLogger(PostgresKoSQL::class.java)

class PostgresKoSQL(client: KoSQLPgClient): KoSQL(client) {
    // when manually insert value to auto increment column, the sequence will run out of sync,
    // and it will cause a duplicated key exception
    // call this method to make the sequence sync again
    suspend fun syncAutoIncrementKey(table: Table<*, *>): Unit = tx {
        val tb = table.inner.name
        val co = table.primaryKey().name
        val sql = "select setval('${tb}_${co}_seq', coalesce(max(${co}), 1)) from $tb"
        logger.debug("execute: {}", sql)

        val st = connection.prepare(sql).await()
        try {
            st.query().execute().await()
        } finally {
            st.close()
        }

        Unit
    }
}
