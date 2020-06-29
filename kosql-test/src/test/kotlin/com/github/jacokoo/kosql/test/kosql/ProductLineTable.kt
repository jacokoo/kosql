package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.ByteArrayNullType
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.StringNullType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column5
import com.github.jacokoo.kosql.test.entity.ProductLine


open class ProductLineBase(): Entity<Int> {
    var id: Int = 0
    var line: String = ""
    var text: String = ""
    var html: String = ""
    var image: ByteArray = ByteArray(0)

    constructor(other: ProductLineBase): this() {
        this.id = other.id
        this.line = other.line
        this.text = other.text
        this.html = other.html
        this.image = other.image
    }

    override fun get(name: String): Any? = when(name) {
        PRODUCT_LINE.ID.name -> this.id
        PRODUCT_LINE.LINE.name -> this.line
        PRODUCT_LINE.TEXT.name -> this.text
        PRODUCT_LINE.HTML.name -> this.html
        PRODUCT_LINE.IMAGE.name -> this.image
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            PRODUCT_LINE.ID.name -> this.id = value as Int
            PRODUCT_LINE.LINE.name -> this.line = value as String
            PRODUCT_LINE.TEXT.name -> this.text = value as String
            PRODUCT_LINE.HTML.name -> this.html = value as String
            PRODUCT_LINE.IMAGE.name -> this.image = value as ByteArray
        }
    }

    override fun toString(): String = buildString {
        append("ProductLineBase (")
        append("id = $id, line = $line, text = $text, html = $html, image = $image")
        append(")")
    }

}


open class ProductLineTable protected constructor(alias: String = ""): Table<Int, ProductLine>("f_product_line", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0, autoIncrement = true)
    val LINE = createColumn("f_line", StringType(), false, "")
    val TEXT = createColumn("f_text", StringNullType(), true, "")
    val HTML = createColumn("f_html", StringNullType(), true, "")
    val IMAGE = createColumn("f_image", ByteArrayNullType(), true, ByteArray(0))

    override fun AS(alias: String) = ProductLineTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column5(ID, LINE, TEXT, HTML, IMAGE)
}

object PRODUCT_LINE: ProductLineTable()
