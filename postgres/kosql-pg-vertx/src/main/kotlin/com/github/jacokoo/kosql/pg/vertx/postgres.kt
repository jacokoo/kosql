package com.github.jacokoo.kosql.pg.vertx

import com.github.jacokoo.kosql.build.pg.PostgresBuilder
import com.github.jacokoo.kosql.build.pg.PostgresContext
import com.github.jacokoo.kosql.compose.InnerTable
import com.github.jacokoo.kosql.execute.vertx.AbstractKoSQLClient
import com.github.jacokoo.kosql.execute.vertx.KoSQL
import io.vertx.core.Future
import io.vertx.pgclient.PgPool
import io.vertx.sqlclient.Row
import io.vertx.sqlclient.RowSet
import io.vertx.sqlclient.SqlClient
import io.vertx.sqlclient.SqlConnection

class KoSQLPgClient(private val pool: PgPool): AbstractKoSQLClient(
    PostgresBuilder(), { PostgresContext() }
) {
    override fun openConnection(): Future<SqlConnection> = pool.connection
    override fun getGeneratedKey(row: RowSet<Row>, table: InnerTable<*, *>): Any = table.primaryKey().let { key ->
        key.type.fromDb(row.first().getValue(key.name))!!
    }
}

class PostgresKoSQL(client: KoSQLPgClient): KoSQL(client)
