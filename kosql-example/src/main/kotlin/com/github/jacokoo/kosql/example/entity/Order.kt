package com.github.jacokoo.kosql.example.entity

import com.github.jacokoo.kosql.example.kosql.OrderBase

class Order: OrderBase {

    constructor(): super()
    constructor(other: Order): super(other)

    fun copy(block: (Order) -> Unit): Order = Order(this).also(block)

}
