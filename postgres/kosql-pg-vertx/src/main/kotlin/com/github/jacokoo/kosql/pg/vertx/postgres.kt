package com.github.jacokoo.kosql.pg.vertx

import com.github.jacokoo.kosql.build.pg.PostgresBuilder
import com.github.jacokoo.kosql.build.pg.PostgresContext
import com.github.jacokoo.kosql.compose.InnerTable
import com.github.jacokoo.kosql.execute.vertx.KoSQL
import io.vertx.core.Future
import io.vertx.pgclient.PgPool
import io.vertx.sqlclient.Row
import io.vertx.sqlclient.RowSet
import io.vertx.sqlclient.SqlClient
import io.vertx.sqlclient.SqlConnection

class PostgresKoSQL(client: PgPool): KoSQL(client, PostgresBuilder(), { PostgresContext() }) {
    override fun getGeneratedKey(row: RowSet<Row>, table: InnerTable<*, *>): Any = table.primaryKey().let { key ->
        key.type.fromDb(row.first().getValue(key.name))!!
    }

    override fun openConnection(client: SqlClient): Future<SqlConnection> =
        (client as PgPool).connection
}
