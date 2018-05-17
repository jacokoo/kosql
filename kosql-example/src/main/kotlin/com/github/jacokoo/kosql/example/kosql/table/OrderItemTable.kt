package com.github.jacokoo.kosql.example.kosql.table

import com.github.jacokoo.kosql.compose.DecimalType
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column5
import com.github.jacokoo.kosql.example.entity.OrderItem
import java.math.BigDecimal

open class OrderItemTable protected constructor(alias: String = ""): Table<Int, OrderItem>("t_order_item", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0).autoIncrement()
    val ORDER_ID = createColumn("f_order_id", IntType(), false, 0)
    val PRODUCT_ID = createColumn("f_product_id", IntType(), false, 0)
    val UNIT_PRICE = createColumn("f_unit_price", DecimalType(), false, BigDecimal("0.00"))
    val QUANTITY = createColumn("f_quantity", IntType(), false, 1)

    override fun AS(alias: String) = OrderItemTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column5(ID, ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
}

object ORDER_ITEM: OrderItemTable()
