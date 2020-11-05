package com.github.jacokoo.kosql.mysql.vertx

import com.github.jacokoo.kosql.build.mysql.MySQLBuilder
import com.github.jacokoo.kosql.build.mysql.MySQLContext
import com.github.jacokoo.kosql.execute.vertx.KoSQL
import io.vertx.kotlin.coroutines.awaitResult
import io.vertx.mysqlclient.MySQLClient
import io.vertx.mysqlclient.MySQLPool
import io.vertx.sqlclient.Row
import io.vertx.sqlclient.RowSet
import io.vertx.sqlclient.SqlClient
import io.vertx.sqlclient.SqlConnection

class MySQLKoSQL(client: MySQLPool): KoSQL(client, MySQLBuilder(), { MySQLContext(it as MySQLBuilder) }) {
    override fun getGeneratedKey(row: RowSet<Row>): Any = row.property(MySQLClient.LAST_INSERTED_ID)

    override suspend fun openConnection(client: SqlClient): SqlConnection =
        awaitResult { (client as MySQLPool).getConnection(it) }
}
