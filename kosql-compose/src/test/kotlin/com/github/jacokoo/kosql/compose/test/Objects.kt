package com.github.jacokoo.kosql.compose.test

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.typesafe.Column5
import java.math.BigDecimal
import java.time.LocalDateTime

open class OrderBase(): Entity<Int> {
    var id: Int = 0
    var orderDate: LocalDateTime = LocalDateTime.MIN
    var orderNumber: String? = null
    var customerId: Int = 0
    var totalAmount: BigDecimal? = BigDecimal("0.00")

    constructor(other: OrderBase): this() {
        this.id = other.id
        this.orderDate = other.orderDate
        this.orderNumber = other.orderNumber
        this.customerId = other.customerId
        this.totalAmount = other.totalAmount
    }

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

    override fun toString(): String = buildString {
        append("OrderBase (")
        append("id = $id, orderDate = $orderDate, orderNumber = $orderNumber, customerId = $customerId, totalAmount = $totalAmount")
        append(")")
    }
}


class Order: OrderBase {
    constructor(): super()
    constructor(other: Order): super(other)

    fun copy(block: (Order) -> Unit) = Order(this).also(block)
}

open class OrderTable protected constructor(alias: String = ""): Table<Int, Order>("t_order", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0).autoIncrement()
    val ORDER_DATE = createColumn("f_order_date", DateTimeType(), false, LocalDateTime.MIN)
    val ORDER_NUMBER = createColumn("f_order_number", StringType(), true, null)
    val CUSTOMER_ID = createColumn("f_customer_id", IntType(), false, 0)
    val TOTAL_AMOUNT = createColumn("f_total_amount", DecimalType(), true, BigDecimal("0.00"))

    override fun AS(alias: String) = OrderTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column5(ID, ORDER_DATE, ORDER_NUMBER, CUSTOMER_ID, TOTAL_AMOUNT)
}

object ORDER: OrderTable()
