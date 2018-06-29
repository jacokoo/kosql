package com.github.jacokoo.kosql.test.entity

import com.github.jacokoo.kosql.test.kosql.OrderBase

class Order: OrderBase {

    constructor(): super()
    constructor(other: Order): super(other)

    fun copy(block: (Order) -> Unit): Order = Order(this).also(block)

}
