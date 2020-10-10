package com.github.jacokoo.kosql.mysql.vertx

import com.github.jacokoo.kosql.build.mysql.MySQLBuilder
import com.github.jacokoo.kosql.build.mysql.MySQLContext
import com.github.jacokoo.kosql.execute.vertx.KoSQLFactory
import io.vertx.kotlin.coroutines.awaitResult
import io.vertx.mysqlclient.MySQLClient
import io.vertx.mysqlclient.MySQLPool
import io.vertx.sqlclient.Row
import io.vertx.sqlclient.RowSet
import io.vertx.sqlclient.SqlClient
import io.vertx.sqlclient.SqlConnection

class MySQLKoSQL(client: MySQLPool): KoSQLFactory<MySQLBuilder>(client, MySQLBuilder(), { MySQLContext(it) }) {
    override fun getGeneratedKey(row: RowSet<Row>): Any = row.property(MySQLClient.LAST_INSERTED_ID)

    override suspend fun openConnection(client: SqlClient): SqlConnection =
        awaitResult { (client as MySQLPool).getConnection(it) }
}