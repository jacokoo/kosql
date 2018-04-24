package com.github.jacokoo.kosql.example.kosql.entity

import com.github.jacokoo.kosql.example.kosql.table.ORDER
import com.github.jacokoo.kosql.example.kosql.table.OrderTable
import com.github.jacokoo.kosql.mapping.Entity
import java.math.BigDecimal
import java.time.LocalDateTime

open class Order: Entity<Int, OrderTable> {
    var id: Int = 0
    var orderDate: LocalDateTime = LocalDateTime.MIN
    var orderNumber: String? = null
    var customerId: Int = 0
    var totalAmount: BigDecimal? = BigDecimal("0.00")

    override fun get(name: String): Any? = when(name) {
        ORDER.ID.name -> this.id
        ORDER.ORDER_DATE.name -> this.orderDate
        ORDER.ORDER_NUMBER.name -> this.orderNumber
        ORDER.CUSTOMER_ID.name -> this.customerId
        ORDER.TOTAL_AMOUNT.name -> this.totalAmount
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            ORDER.ID.name -> this.id = value as Int
            ORDER.ORDER_DATE.name -> this.orderDate = value as LocalDateTime
            ORDER.ORDER_NUMBER.name -> this.orderNumber = value as String
            ORDER.CUSTOMER_ID.name -> this.customerId = value as Int
            ORDER.TOTAL_AMOUNT.name -> this.totalAmount = value as BigDecimal
        }
    }

}

