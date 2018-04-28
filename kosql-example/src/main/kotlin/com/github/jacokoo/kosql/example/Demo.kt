package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.KoSQL
import com.github.jacokoo.kosql.example.kosql.entity.Order
import com.github.jacokoo.kosql.example.kosql.table.ORDER
import com.github.jacokoo.kosql.example.kosql.table.ORDER_ITEM
import java.time.LocalDateTime
import javax.annotation.PostConstruct


class Demo(private val ko: KoSQL) {

    @PostConstruct
    fun demo() = ko.run {
        SELECT(ORDER.ORDER_NUMBER, ORDER.ID) {
            FROM(ORDER) WHERE ORDER.ID EQ 1
        }

        SELECT(ORDER.ID) {
            FROM(ORDER) JOIN ORDER_ITEM ON ORDER.ID EQ ORDER_ITEM.ORDER_ID WHERE ORDER.ID EQ 1
        }.fetch(Order::class).forEach { println(it.id) }

        UPDATE(ORDER) SET {
            it[ORDER.ID] = 1
            it[ORDER.ORDER_DATE] = LocalDateTime.now()
        } WHERE ORDER.ID EQ 1

        UPDATE(ORDER) LEFT_JOIN ORDER_ITEM ON ORDER.ID EQ ORDER_ITEM.ORDER_ID SET {
            it[ORDER.ORDER_NUMBER] = "abcdef"
        }

        DELETE FROM ORDER WHERE ORDER.ID EQ 1

        println()
    }
}
