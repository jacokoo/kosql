package com.github.jacokoo.kosql.example.kosql.table

import com.github.jacokoo.kosql.DateTimeType
import com.github.jacokoo.kosql.DecimalType
import com.github.jacokoo.kosql.IntType
import com.github.jacokoo.kosql.StringType
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.typesafe.Column5
import java.math.BigDecimal
import java.time.LocalDateTime

open class OrderTable protected constructor(alias: String = ""): Table<Int>("t_order", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0).autoIncrement()
    val ORDER_DATE = createColumn("f_order_date", DateTimeType(), false, LocalDateTime.MIN)
    val ORDER_NUMBER = createColumn("f_order_number", StringType(), true, null)
    val CUSTOMER_ID = createColumn("f_customer_id", IntType(), false, 0)
    val TOTAL_AMOUNT = createColumn("f_total_amount", DecimalType(), true, BigDecimal("0.00"))

    override fun AS(alias: String) = OrderTable(alias)
    override fun primaryKey() = ID
    operator fun invoke() = Column5(ID, ORDER_DATE, ORDER_NUMBER, CUSTOMER_ID, TOTAL_AMOUNT)
}

object ORDER: OrderTable()
