package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.compose.SQLBuilder
import com.github.jacokoo.kosql.example.entity.Order
import com.github.jacokoo.kosql.example.kosql.table.ORDER
import com.github.jacokoo.kosql.example.kosql.table.ORDER_ITEM
import com.github.jacokoo.kosql.spring.jdbc.KoSQL
import java.math.BigDecimal
import javax.annotation.PostConstruct

class Demo2(private val ko: KoSQL) {
    val template = ko.template {
        SELECT(ORDER.ID, ORDER.ORDER_NUMBER, ORDER.ORDER_DATE) FROM ORDER WHERE ORDER.ID EQ 1
    }

    @PostConstruct fun demo() {
        ko.run {
            template.fetch().map { it ->
                println(it)
            }

            template.fetch(0 to 2).map { it ->
                println(it)
            }

            // insert into t_order(f_customer_id, f_order_number) values(?, ?)
            val (id, rows) = execute( // returns generated id and rows effected
                INSERT INTO ORDER(ORDER.CUSTOMER_ID, ORDER.ORDER_NUMBER) VALUES V(100, "order_number")
            )

            // update t_order set f_customer_id = ?, f_order_number = ? where f_id = ?
            val rows1 = execute(UPDATE(ORDER) SET { // returns rows effected
                it[ORDER.CUSTOMER_ID] = 100
                it[ORDER.ORDER_NUMBER] = "abc"
            } WHERE ORDER.ID EQ 1)

            // delete from t_order where f_id = ?
            val rows2 = execute(DELETE FROM ORDER WHERE ORDER.ID EQ 1) // returns rows effected

            // select * from t_order where f_id = ?
            val list: List<Order> = (
                SELECT (ORDER) FROM ORDER WHERE ORDER.ID EQ 1
                ).fetch(Order::class)

            val optionalId: Int? = 100
            val optionalAmount: BigDecimal? = null
            // select f_id, f_total_amount from t_order where f_id = 100
            // ORDER.TOTAL_AMOUNT GT optionalAmount is ignored because optionalAmount is null
            (SELECT (ORDER.ID, ORDER.TOTAL_AMOUNT) FROM ORDER
                LEFT_JOIN ORDER_ITEM ON ORDER_ITEM.ORDER_ID EQ ORDER.ID
                WHERE ORDER.ID EQ optionalId AND ORDER.TOTAL_AMOUNT GT optionalAmount
            ).fetch().forEach { (id: Int, amount: BigDecimal) ->
                println(id.inc())
                println(amount.divide(10.toBigDecimal()))
            }

            val b = ORDER_ITEM.AS("b")
            val a = ORDER.AS("a")
            //       INT   String          LocalDateTime

            (SELECT(a.ID, a.ORDER_NUMBER, a.TOTAL_AMOUNT) FROM a).fetch()

            (SELECT(a.ID, a.ORDER_NUMBER, a.ORDER_DATE) FROM(a)).fetch().firstOrNull()?.let {(id, number, date) ->
                println(id.inc()) // id is Int
                println(number.trim()) // number is String
                println(date.minusHours(10)) // date is LocalDateTime
            }

            val sql = (SELECT (a.ID) FROM a
                LEFT_JOIN b ON b.ORDER_ID EQ a.ID AND b.PRODUCT_ID EQ 10
                WHERE a.ID EQ 1
                GROUP_BY a.ID HAVING count(a.ID) EQ 1 AND a.ORDER_NUMBER LIKE "%a" AND a.ID EQ 1
                )

            println(SQLBuilder().build(sql).sql)

            val o: Order = ORDER.byId(1)!!;
            var o2: List<Order> = ORDER.fetch(ORDER.ID EQ 2);
            val o3 = ORDER.fetch(ORDER.CUSTOMER_ID NE 79 AND (ORDER.TOTAL_AMOUNT GT 1000.toBigDecimal()))

            println(o)
            println(o2)
            println(o3)
            println(ORDER.count())
        }
    }
}
