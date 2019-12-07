package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.DecimalType
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column5
import com.github.jacokoo.kosql.test.entity.OrderItem
import java.math.BigDecimal


open class OrderItemBase(): Entity<Int> {
    var id: Int = 0
    var orderId: Int = 0
    var productId: Int = 0
    var unitPrice: BigDecimal = BigDecimal("0.00")
    var quantity: Int = 1

    constructor(other: OrderItemBase): this() {
        this.id = other.id
        this.orderId = other.orderId
        this.productId = other.productId
        this.unitPrice = other.unitPrice
        this.quantity = other.quantity
    }

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

    override fun toString(): String = buildString {
        append("OrderItemBase (")
        append("id = $id, orderId = $orderId, productId = $productId, unitPrice = $unitPrice, quantity = $quantity")
        append(")")
    }

}


open class OrderItemTable protected constructor(alias: String = ""): Table<Int, OrderItem>("t_order_item", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0, autoIncrement = true)
    val ORDER_ID = createColumn("f_order_id", IntType(), false, 0)
    val PRODUCT_ID = createColumn("f_product_id", IntType(), false, 0)
    val UNIT_PRICE = createColumn("f_unit_price", DecimalType(), false, BigDecimal("0.00"))
    val QUANTITY = createColumn("f_quantity", IntType(), false, 1)

    override fun AS(alias: String) = OrderItemTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column5(ID, ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
}

object ORDER_ITEM: OrderItemTable()
