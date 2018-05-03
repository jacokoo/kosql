package com.github.jacokoo.kosql.example.kosql.table

import com.github.jacokoo.kosql.BooleanType
import com.github.jacokoo.kosql.DecimalType
import com.github.jacokoo.kosql.IntType
import com.github.jacokoo.kosql.StringType
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.typesafe.Column6
import java.math.BigDecimal

open class ProductTable protected constructor(alias: String = ""): Table<Int>("t_product", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0).autoIncrement()
    val PRODUCT_NAME = createColumn("f_product_name", StringType(), false, "")
    val SUPPLIER_ID = createColumn("f_supplier_id", IntType(), false, 0)
    val UNIT_PRICE = createColumn("f_unit_price", DecimalType(), true, BigDecimal("0.00"))
    val PACKAGE1 = createColumn("f_package1", StringType(), true, null)
    val IS_DISCONTINUED = createColumn("f_is_discontinued", BooleanType(), false, false)

    override fun AS(alias: String) = ProductTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column6(ID, PRODUCT_NAME, SUPPLIER_ID, UNIT_PRICE, PACKAGE1, IS_DISCONTINUED)
}

object PRODUCT: ProductTable()
