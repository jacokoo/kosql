package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.KoSQL
import com.github.jacokoo.kosql.example.entity.Order
import com.github.jacokoo.kosql.example.table.ORDER
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.beans
import javax.annotation.PostConstruct

@SpringBootApplication
@Configuration
open class Main

class Demo(private val ko: KoSQL) {

    @PostConstruct
    fun demo() {
        ko.run {
            val sql = SELECT(ORDER.ORDER_NUMBER, ORDER.ID) {
                FROM(ORDER) WHERE (ORDER.ID EQ (ORDER.ID + ORDER.CUSTOMER_ID))
            }

            val orders: List<Order> = sql.fetch(Order::class)
            val strs: List<String> = sql.fetch().map { (v: String, i: Int) -> v }
            val strs2: List<String> = sql.fetch({ it[ORDER.ORDER_NUMBER] })

            val s = SELECT(ORDER.ID, ORDER.ORDER_NUMBER, ORDER.TOTAL_AMOUNT) {
                FROM(ORDER)
            }

            val c = UPDATE(ORDER) SET {
                it[ORDER.ORDER_NUMBER] = "aaa"
            } WHERE (ORDER.ID EQ 1)
            c.execute()

            val a = ORDER.run { this(ID, CUSTOMER_ID, ORDER_NUMBER) }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Main>(*args) {
        addInitializers(beans {
            bean<KoSQL>()
            bean<Demo>()
        })
    }
}