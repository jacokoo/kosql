package com.github.jacokoo.kosql.example.entity

import com.github.jacokoo.kosql.example.kosql.entity.OrderBase

class Order: OrderBase {

    constructor(): super()
    constructor(other: Order): super(other)

    fun cp(block: (Order) -> Unit) = Order(this).also(block)
}
