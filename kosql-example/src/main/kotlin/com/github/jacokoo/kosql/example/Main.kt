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
        val a = ko.query {
            SELECT(ORDER.ORDER_NUMBER) {
                FROM(ORDER)
            }
        }

        val b: List<Order> = a.into(Order::class)
        println(b)

        val c: Int = ko.update {
            UPDATE(ORDER) SET {
                it[ORDER.ORDER_NUMBER] = "abc"
                it[ORDER.CUSTOMER_ID] = 886888
            } WHERE (ORDER.ID EQ 1)
        }
        println(c)
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