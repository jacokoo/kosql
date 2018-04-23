package com.github.jacokoo.kosql.example.entity

import com.github.jacokoo.kosql.example.table.ORDER
import com.github.jacokoo.kosql.example.table.OrderTable
import com.github.jacokoo.kosql.mapping.Entity
import java.math.BigDecimal

open class Order: Entity<Int, OrderTable> {

    var id = 0
    var orderNumber = ""
    var totalAmount = BigDecimal.ZERO
    var coustomerId = 0

    override fun get(name: String): Any? = when(name) {
        ORDER.ID.name -> this.id
        ORDER.ORDER_NUMBER.name -> this.orderNumber
        ORDER.TOTAL_AMOUNT.name -> this.totalAmount
        ORDER.CUSTOMER_ID.name -> this.coustomerId
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            ORDER.ID.name -> this.id = value as Int
            ORDER.ORDER_NUMBER.name -> this.orderNumber = value as String
            ORDER.TOTAL_AMOUNT.name -> this.totalAmount = value as BigDecimal
            ORDER.CUSTOMER_ID.name -> this.coustomerId = value as Int
        }
    }
}
