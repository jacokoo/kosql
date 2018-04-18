package com.github.jacokoo.ksql.example.table

import com.github.jacokoo.ksql.Column
import com.github.jacokoo.ksql.Table
import com.github.jacokoo.ksql.example.entity.Order

open class OrderTable protected constructor(alias: String = ""): Table<Int>("t_order", alias) {
    val ID = int("f_id")
    val ORDER_NUMBER = string("f_order_number")
    val CUSTOMER_ID = int("f_customer_id")
    val TOTAL_AMOUNT = decimal("f_total_amount")

    override fun AS(alias: String): OrderTable = OrderTable(alias)
    override fun create(): Order = Order()
    override fun primaryKey(): Column<Int> = ID
}

object ORDER: OrderTable()