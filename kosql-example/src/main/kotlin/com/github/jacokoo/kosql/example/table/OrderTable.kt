package com.github.jacokoo.kosql.example.table

import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.example.entity.Order
import com.github.jacokoo.kosql.mapping.Database
import com.github.jacokoo.kosql.statements.Column4

open class OrderTable protected constructor(alias: String = ""): Table<Int>("t_order", alias, "comment") {
    val ID = int("f_id")
    val ORDER_NUMBER = string("f_order_number")
    val CUSTOMER_ID = int("f_customer_id")
    val TOTAL_AMOUNT = decimal("f_total_amount")

    override fun AS(alias: String) = OrderTable(alias)
    override fun create() = Order()
    override fun primaryKey() = ID
    operator fun invoke() = Column4(ID, ORDER_NUMBER, CUSTOMER_ID, TOTAL_AMOUNT)
}

object ORDER: OrderTable() {
    init {
        Database.register(ORDER, Order::class)
    }
}