package com.github.jacokoo.kosql.example.kosql.table

import com.github.jacokoo.kosql.DecimalType
import com.github.jacokoo.kosql.IntType
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.statements.Column5
import java.math.BigDecimal

open class OrderItemTable protected constructor(alias: String = ""): Table<Int>("t_order_item", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0)
    val ORDER_ID = createColumn("f_order_id", IntType(), false, 0)
    val PRODUCT_ID = createColumn("f_product_id", IntType(), false, 0)
    val UNIT_PRICE = createColumn("f_unit_price", DecimalType(), false, BigDecimal("0.00"))
    val QUANTITY = createColumn("f_quantity", IntType(), false, 1)

    override fun AS(alias: String) = OrderItemTable(alias)
    override fun primaryKey() = ID
    operator fun invoke() = Column5(ID, ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
}

object ORDER_ITEM: OrderItemTable()
