package com.github.jacokoo.kosql.execute.vertx

import com.github.jacokoo.kosql.compose.Compose
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.result.Mapper
import com.github.jacokoo.kosql.compose.statement.*
import com.github.jacokoo.kosql.execute.async.Dao
import io.vertx.kotlin.coroutines.await
import io.vertx.sqlclient.SqlConnection

class InnerKoSQL internal constructor(
    private val kf: KoSQL,
    private val conn: SqlConnection
): Compose(), Dao {
    private var started: Boolean = false

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
        = kf.client.execute(conn, update)

    override suspend fun execute(delete: DeleteStatement): Int
        = kf.client.execute(conn, delete)

    override suspend fun <T> execute(insert: InsertStatement<T>): Pair<T, Int>
        = kf.client.execute(conn, insert)

    override suspend fun <T> execute(insert: BatchInsertStatement<T>): Int
        = kf.client.execute(conn, insert)

    override suspend fun <T, R : ColumnList> execute(select: SelectStatement<R>, mapper: Mapper<T>): List<T>
        = kf.client.execute(conn, select, mapper)

}

abstract class KoSQL(
    internal val client: KoSQLClient,
) {
    suspend fun <T> tx(fn: suspend InnerKoSQL.() -> T): T = withConnection { conn ->
        InnerKoSQL(this, conn).tx { fn() }
    }

    suspend fun <T> run(fn: suspend InnerKoSQL.() -> T): T = withConnection { conn ->
        InnerKoSQL(this, conn).fn()
    }

    private suspend inline fun <T> withConnection(fn: (SqlConnection) -> T): T =
        client.openConnection().await().let { conn ->
            try {
                fn(conn)
            } finally {
                conn.close().await()
            }
        }
}
