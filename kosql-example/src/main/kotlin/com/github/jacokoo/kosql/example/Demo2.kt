package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.KoSQL
import com.github.jacokoo.kosql.example.kosql.table.ORDER
import javax.annotation.PostConstruct

class Demo2(private val ko: KoSQL) {

    @PostConstruct fun demo() {
        ko.run {
            val a = ORDER.AS("a")
            //       INT   String          LocalDateTime
            SELECT(a.ID, a.ORDER_NUMBER, a.ORDER_DATE) {
                FROM(ORDER)
            }.fetchOne()?.let { (id, number, date) ->
                println(id.inc()) // id is Int
                println(number.trim()) // number is String
                println(date.minusHours(10)) // date is LocalDateTime
            }

            println()
        }
    }
}