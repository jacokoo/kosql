package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.KoSQL
import com.github.jacokoo.kosql.example.kosql.entity.Order
import com.github.jacokoo.kosql.example.kosql.table.ORDER
import javax.annotation.PostConstruct


class Demo(private val ko: KoSQL) {

    @PostConstruct
    fun demo() = ko.run {
        val sql = SELECT(ORDER.ORDER_NUMBER, ORDER.ID) {
            FROM(ORDER) WHERE (ORDER.ID EQ 1)
        }

        SELECT (ORDER() + ORDER()) {
            FROM(ORDER)
        }

        val orders: List<Order> = sql.fetch(Order::class)
        val strs: List<String> = sql.fetch().map { (v: String, i: Int) -> v }
        val strs2: List<String> = sql.fetch({ it[ORDER.ORDER_NUMBER] })

        println(orders)
        println(strs)
        println(strs2)

        val s = SELECT(ORDER.ID, ORDER.ORDER_NUMBER, ORDER.TOTAL_AMOUNT) {
            FROM(ORDER)
        }

        val c = UPDATE(ORDER) SET {
            it[ORDER.ORDER_NUMBER] = "abc"
        } WHERE (ORDER.ID EQ 1)
        c.execute()

        ORDER.run { this(ID, CUSTOMER_ID, ORDER_NUMBER) }
    }
}
