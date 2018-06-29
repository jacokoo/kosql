package com.github.jacokoo.kosql.test.entity

import com.github.jacokoo.kosql.test.kosql.SupplierBase

class Supplier: SupplierBase {

    constructor(): super()
    constructor(other: Supplier): super(other)

    fun copy(block: (Supplier) -> Unit): Supplier = Supplier(this).also(block)

}
