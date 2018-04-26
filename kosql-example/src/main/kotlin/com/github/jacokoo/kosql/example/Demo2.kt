package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.KoSQL
import com.github.jacokoo.kosql.example.kosql.entity.Order
import com.github.jacokoo.kosql.example.kosql.table.ORDER
import javax.annotation.PostConstruct

class Demo2(private val ko: KoSQL) {

    @PostConstruct fun demo() {
        ko.run {
            val a = ORDER.AS("a")
            val sql = SELECT(a()) {
                FROM(a) WHERE (a.TOTAL_AMOUNT GT 1000.toBigDecimal())
            }

            val count = sql.toCount().fetch()
            val list = sql.fetch(Order::class)

            println(list)
            println(count)
        }
    }
}