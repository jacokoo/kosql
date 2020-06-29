package com.github.jacokoo.kosql.test.entity

import com.github.jacokoo.kosql.test.kosql.ProductLineBase

class ProductLine: ProductLineBase {

    constructor(): super()
    constructor(other: ProductLine): super(other)

    fun copy(block: (ProductLine) -> Unit): ProductLine = ProductLine(this).also(block)

}
