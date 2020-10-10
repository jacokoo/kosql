package com.github.jacokoo.kosql.demo.vertx

import com.github.jacokoo.kosql.demo.vertx.entity.Demo
import com.github.jacokoo.kosql.demo.vertx.entity.DemoType
import com.github.jacokoo.kosql.demo.vertx.kosql.DEMO
import com.github.jacokoo.kosql.mysql.vertx.MySQLKoSQL
import io.vertx.core.buffer.Buffer
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.mysqlclient.MySQLConnectOptions
import io.vertx.mysqlclient.MySQLPool
import io.vertx.sqlclient.*

suspend fun <T, U> use(t: T, fn: suspend (T) -> U): U = fn(t)

class DemoVerticle: CoroutineVerticle() {
    lateinit var ko: MySQLKoSQL

    override suspend fun start() {
        val pool = MySQLPool.pool(vertx, MySQLConnectOptions().apply {
            host = "127.0.0.1"
            port = 13306
            database = "demo"
            user = "root"
            password = "root"
        }, PoolOptions().apply {
            maxSize = 5
        })
        ko = MySQLKoSQL(pool)

        demo4()
    }

    suspend fun demo() = ko.run {
        use(DEMO) { d ->
            val list = (SELECT(d) FROM d).fetch(d)
            println(list)
        }
    }

    suspend fun demo2() = ko.tx {
        use(DEMO) { d ->
            Demo().also {
                it.bin = Buffer.buffer("a")
                it.bit1 = true
                it.bit16 = 16
                it.bit32 = 32
                it.bit64 = 64
                it.bit8 = 8

                println("save return: ${it.save()}")
            }.also {
                println("after save: ${it.id}")
            }
        }
    }

    suspend fun demo3() = ko.tx {
        use(DEMO) { d ->
            execute(DELETE FROM d WHERE d.ID GT 10)
        }
    }

    suspend fun demo4() = ko.tx {
        execute(UPDATE(DEMO) SET {
            it[TINY] = DemoType.TYPE2
        } WHERE DEMO.ID GT 5)
    }
}
