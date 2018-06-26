package com.github.jacokoo.kosql.example.entity

import com.github.jacokoo.kosql.example.kosql.CustomerBase

class Customer: CustomerBase {

    constructor(): super()
    constructor(other: Customer): super(other)

    fun copy(block: (Customer) -> Unit): Customer = Customer(this).also(block)

}
