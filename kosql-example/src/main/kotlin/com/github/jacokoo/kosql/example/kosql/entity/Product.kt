package com.github.jacokoo.kosql.example.kosql.entity

import com.github.jacokoo.kosql.example.kosql.table.PRODUCT
import com.github.jacokoo.kosql.example.kosql.table.ProductTable
import com.github.jacokoo.kosql.mapping.Entity
import java.math.BigDecimal

open class Product: Entity<Int, ProductTable> {
    var id: Int = 0
    var productName: String = ""
    var supplierId: Int = 0
    var unitPrice: BigDecimal? = BigDecimal("0.00")
    var package1: String? = null
    var isDiscontinued: Boolean = false

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

}

