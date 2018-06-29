package com.github.jacokoo.kosql.test.entity

import com.github.jacokoo.kosql.test.kosql.CustomerBase

class Customer: CustomerBase {

    constructor(): super()
    constructor(other: Customer): super(other)

    fun copy(block: (Customer) -> Unit): Customer = Customer(this).also(block)

}
