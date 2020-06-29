package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.DecimalType
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column6
import com.github.jacokoo.kosql.test.entity.OrderDetail
import java.math.BigDecimal


open class OrderDetailBase(): Entity<Int> {
    var id: Int = 0
    var orderId: Int = 0
    var productCode: String = ""
    var quantity: Int = 0
    var priceEach: BigDecimal = BigDecimal("0")
    var seqence: Int = 0

    constructor(other: OrderDetailBase): this() {
        this.id = other.id
        this.orderId = other.orderId
        this.productCode = other.productCode
        this.quantity = other.quantity
        this.priceEach = other.priceEach
        this.seqence = other.seqence
    }

    override fun get(name: String): Any? = when(name) {
        ORDER_DETAIL.ID.name -> this.id
        ORDER_DETAIL.ORDER_ID.name -> this.orderId
        ORDER_DETAIL.PRODUCT_CODE.name -> this.productCode
        ORDER_DETAIL.QUANTITY.name -> this.quantity
        ORDER_DETAIL.PRICE_EACH.name -> this.priceEach
        ORDER_DETAIL.SEQENCE.name -> this.seqence
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            ORDER_DETAIL.ID.name -> this.id = value as Int
            ORDER_DETAIL.ORDER_ID.name -> this.orderId = value as Int
            ORDER_DETAIL.PRODUCT_CODE.name -> this.productCode = value as String
            ORDER_DETAIL.QUANTITY.name -> this.quantity = value as Int
            ORDER_DETAIL.PRICE_EACH.name -> this.priceEach = value as BigDecimal
            ORDER_DETAIL.SEQENCE.name -> this.seqence = value as Int
        }
    }

    override fun toString(): String = buildString {
        append("OrderDetailBase (")
        append("id = $id, orderId = $orderId, productCode = $productCode, quantity = $quantity, priceEach = $priceEach, seqence = $seqence")
        append(")")
    }

}


open class OrderDetailTable protected constructor(alias: String = ""): Table<Int, OrderDetail>("t_order_detail", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0, autoIncrement = true)
    val ORDER_ID = createColumn("f_order_id", IntType(), false, 0)
    val PRODUCT_CODE = createColumn("f_product_code", StringType(), false, "")
    val QUANTITY = createColumn("f_quantity", IntType(), false, 0)
    val PRICE_EACH = createColumn("f_price_each", DecimalType(), false, BigDecimal("0"))
    val SEQENCE = createColumn("f_seqence", IntType(), false, 0)

    override fun AS(alias: String) = OrderDetailTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column6(ID, ORDER_ID, PRODUCT_CODE, QUANTITY, PRICE_EACH, SEQENCE)
}

object ORDER_DETAIL: OrderDetailTable()
