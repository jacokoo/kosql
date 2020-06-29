package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.DecimalType
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column10
import com.github.jacokoo.kosql.test.entity.Product
import java.math.BigDecimal


open class ProductBase(): Entity<Int> {
    var id: Int = 0
    var code: String = ""
    var name: String = ""
    var line: String = ""
    var scale: String = ""
    var vendor: String = ""
    var description: String = ""
    var stock: Int = 0
    var price: BigDecimal = BigDecimal("0")
    var msrp: BigDecimal = BigDecimal("0")

    constructor(other: ProductBase): this() {
        this.id = other.id
        this.code = other.code
        this.name = other.name
        this.line = other.line
        this.scale = other.scale
        this.vendor = other.vendor
        this.description = other.description
        this.stock = other.stock
        this.price = other.price
        this.msrp = other.msrp
    }

    override fun get(name: String): Any? = when(name) {
        PRODUCT.ID.name -> this.id
        PRODUCT.CODE.name -> this.code
        PRODUCT.NAME.name -> this.name
        PRODUCT.LINE.name -> this.line
        PRODUCT.SCALE.name -> this.scale
        PRODUCT.VENDOR.name -> this.vendor
        PRODUCT.DESCRIPTION.name -> this.description
        PRODUCT.STOCK.name -> this.stock
        PRODUCT.PRICE.name -> this.price
        PRODUCT.MSRP.name -> this.msrp
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            PRODUCT.ID.name -> this.id = value as Int
            PRODUCT.CODE.name -> this.code = value as String
            PRODUCT.NAME.name -> this.name = value as String
            PRODUCT.LINE.name -> this.line = value as String
            PRODUCT.SCALE.name -> this.scale = value as String
            PRODUCT.VENDOR.name -> this.vendor = value as String
            PRODUCT.DESCRIPTION.name -> this.description = value as String
            PRODUCT.STOCK.name -> this.stock = value as Int
            PRODUCT.PRICE.name -> this.price = value as BigDecimal
            PRODUCT.MSRP.name -> this.msrp = value as BigDecimal
        }
    }

    override fun toString(): String = buildString {
        append("ProductBase (")
        append("id = $id, code = $code, name = $name, line = $line, scale = $scale, vendor = $vendor, description = $description, stock = $stock, price = $price, msrp = $msrp")
        append(")")
    }

}


open class ProductTable protected constructor(alias: String = ""): Table<Int, Product>("f_product", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0, autoIncrement = true)
    val CODE = createColumn("f_code", StringType(), false, "")
    val NAME = createColumn("f_name", StringType(), false, "")
    val LINE = createColumn("f_line", StringType(), false, "")
    val SCALE = createColumn("f_scale", StringType(), false, "")
    val VENDOR = createColumn("f_vendor", StringType(), false, "")
    val DESCRIPTION = createColumn("f_description", StringType(), false, "")
    val STOCK = createColumn("f_stock", IntType(), false, 0)
    val PRICE = createColumn("f_price", DecimalType(), false, BigDecimal("0"))
    val MSRP = createColumn("f_msrp", DecimalType(), false, BigDecimal("0"))

    override fun AS(alias: String) = ProductTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column10(ID, CODE, NAME, LINE, SCALE, VENDOR, DESCRIPTION, STOCK, PRICE, MSRP)
}

object PRODUCT: ProductTable()
