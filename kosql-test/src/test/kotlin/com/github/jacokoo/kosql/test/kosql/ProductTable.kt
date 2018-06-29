package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.BooleanType
import com.github.jacokoo.kosql.compose.DecimalType
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column6
import com.github.jacokoo.kosql.test.entity.Product
import java.math.BigDecimal


open class ProductBase(): Entity<Int> {
    var id: Int = 0
    var productName: String = ""
    var supplierId: Int = 0
    var unitPrice: BigDecimal? = BigDecimal("0.00")
    var package1: String? = null
    var isDiscontinued: Boolean = false

    constructor(other: ProductBase): this() {
        this.id = other.id
        this.productName = other.productName
        this.supplierId = other.supplierId
        this.unitPrice = other.unitPrice
        this.package1 = other.package1
        this.isDiscontinued = other.isDiscontinued
    }

    override fun get(name: String): Any? = when(name) {
        PRODUCT.ID.name -> this.id
        PRODUCT.PRODUCT_NAME.name -> this.productName
        PRODUCT.SUPPLIER_ID.name -> this.supplierId
        PRODUCT.UNIT_PRICE.name -> this.unitPrice
        PRODUCT.PACKAGE1.name -> this.package1
        PRODUCT.IS_DISCONTINUED.name -> this.isDiscontinued
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            PRODUCT.ID.name -> this.id = value as Int
            PRODUCT.PRODUCT_NAME.name -> this.productName = value as String
            PRODUCT.SUPPLIER_ID.name -> this.supplierId = value as Int
            PRODUCT.UNIT_PRICE.name -> this.unitPrice = value as BigDecimal
            PRODUCT.PACKAGE1.name -> this.package1 = value as String
            PRODUCT.IS_DISCONTINUED.name -> this.isDiscontinued = value as Boolean
        }
    }

    override fun toString(): String = buildString {
        append("ProductBase (")
        append("id = $id, productName = $productName, supplierId = $supplierId, unitPrice = $unitPrice, package1 = $package1, isDiscontinued = $isDiscontinued")
        append(")")
    }

}


open class ProductTable protected constructor(alias: String = ""): Table<Int, Product>("t_product", alias, "") {
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
