package com.github.jacokoo.kosql.example.entity

import com.github.jacokoo.kosql.example.kosql.SupplierBase

class Supplier: SupplierBase {

    constructor(): super()
    constructor(other: Supplier): super(other)

    fun copy(block: (Supplier) -> Unit): Supplier = Supplier(this).also(block)

}
