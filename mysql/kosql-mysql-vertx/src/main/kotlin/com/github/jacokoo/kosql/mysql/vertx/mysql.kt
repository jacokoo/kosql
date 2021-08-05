package com.github.jacokoo.kosql.mysql.vertx

import com.github.jacokoo.kosql.build.mysql.MySQLBuilder
import com.github.jacokoo.kosql.build.mysql.MySQLContext
import com.github.jacokoo.kosql.compose.InnerTable
import com.github.jacokoo.kosql.execute.vertx.AbstractKoSQLClient
import com.github.jacokoo.kosql.execute.vertx.KoSQL
import io.vertx.core.Future
import io.vertx.mysqlclient.MySQLClient
import io.vertx.mysqlclient.MySQLPool
import io.vertx.sqlclient.Row
import io.vertx.sqlclient.RowSet
import io.vertx.sqlclient.SqlClient
import io.vertx.sqlclient.SqlConnection

class MySQLKoSQLClient(private val pool: MySQLPool): AbstractKoSQLClient(MySQLBuilder(), { MySQLContext() }) {
    override fun openConnection(): Future<SqlConnection> = pool.connection
    override fun getGeneratedKey(row: RowSet<Row>, table: InnerTable<*, *>): Any = row.property(MySQLClient.LAST_INSERTED_ID)
}

class MySQLKoSQL(client: MySQLKoSQLClient): KoSQL(client)
