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
            val a = SELECT(ORDER.ORDER_NUMBER) {
                FROM(ORDER) WHERE (ORDER.ID EQ 1)
            }.fetch()

            a.forEach { (order: String) -> println(order) }

            val b: List<Order> = a.into(Order::class)
            println(b)

            val c = UPDATE(ORDER) SET {
                it[ORDER.ORDER_NUMBER] = "aaa"
            } WHERE (ORDER.ID EQ 1)
            c.execute()
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