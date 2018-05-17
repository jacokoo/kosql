package com.github.jacokoo.kosql.example.kosql.entity

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.example.kosql.table.ORDER_ITEM
import java.math.BigDecimal

open class OrderItemBase: Entity<Int> {
    var id: Int = 0
    var orderId: Int = 0
    var productId: Int = 0
    var unitPrice: BigDecimal = BigDecimal("0.00")
    var quantity: Int = 1

    override fun get(name: String): Any? = when(name) {
        ORDER_ITEM.ID.name -> this.id
        ORDER_ITEM.ORDER_ID.name -> this.orderId
        ORDER_ITEM.PRODUCT_ID.name -> this.productId
        ORDER_ITEM.UNIT_PRICE.name -> this.unitPrice
        ORDER_ITEM.QUANTITY.name -> this.quantity
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            ORDER_ITEM.ID.name -> this.id = value as Int
            ORDER_ITEM.ORDER_ID.name -> this.orderId = value as Int
            ORDER_ITEM.PRODUCT_ID.name -> this.productId = value as Int
            ORDER_ITEM.UNIT_PRICE.name -> this.unitPrice = value as BigDecimal
            ORDER_ITEM.QUANTITY.name -> this.quantity = value as Int
        }
    }

    fun copy(block: (OrderItemBase) -> Unit): OrderItemBase = OrderItemBase().also {
        it.id = id
        it.orderId = orderId
        it.productId = productId
        it.unitPrice = unitPrice
        it.quantity = quantity
        block(it)
    }

    override fun toString(): String = buildString {
        append("OrderItemBase (")
        append("id = $id, orderId = $orderId, productId = $productId, unitPrice = $unitPrice, quantity = $quantity")
        append(")")
    }
}
