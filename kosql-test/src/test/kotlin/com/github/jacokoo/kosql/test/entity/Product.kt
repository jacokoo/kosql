package com.github.jacokoo.kosql.test.entity

import com.github.jacokoo.kosql.test.kosql.ProductBase

class Product: ProductBase {

    constructor(): super()
    constructor(other: Product): super(other)

    fun copy(block: (Product) -> Unit): Product = Product(this).also(block)

}
