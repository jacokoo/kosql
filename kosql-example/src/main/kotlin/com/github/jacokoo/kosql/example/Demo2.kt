package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.compose.SQLBuilder
import com.github.jacokoo.kosql.example.kosql.table.ORDER
import com.github.jacokoo.kosql.example.kosql.table.ORDER_ITEM
import com.github.jacokoo.kosql.spring.jdbc.KoSQL
import javax.annotation.PostConstruct

class Demo2(private val ko: KoSQL) {

    @PostConstruct fun demo() {
        ko.run {
            val b = ORDER_ITEM.AS("b")
            val a = ORDER.AS("a")
            //       INT   String          LocalDateTime
            SELECT(a.ID, a.ORDER_NUMBER, a.ORDER_DATE) {
                FROM(a)
            }.fetch().firstOrNull()?.let {(id, number, date) ->
                println(id.inc()) // id is Int
                println(number.trim()) // number is String
                println(date.minusHours(10)) // date is LocalDateTime
            }

            val sql = SELECT (a.ID) {
                FROM(a) LEFT_JOIN
                        b ON b.ORDER_ID EQ a.ID AND b.PRODUCT_ID EQ 10 GROUP_BY
                        a.ID HAVING
                        count(a.ID) EQ 1 AND (a.ORDER_NUMBER LIKE  "ab") AND a.ID EQ 1
            }

            println(SQLBuilder().build(sql).sql)

            val o = ORDER.byId(1);
            var o2 = ORDER.fetch(ORDER.ID EQ 2);
            val o3 = ORDER.fetch(ORDER.CUSTOMER_ID NE 79 AND (ORDER.TOTAL_AMOUNT GT 1000.toBigDecimal()))

            println(o)
            println(o2)
            println(o3)
            println(ORDER.count())
        }
    }
}

