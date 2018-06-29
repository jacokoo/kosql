package com.github.jacokoo.kosql.test.entity

import com.github.jacokoo.kosql.test.kosql.OrderItemBase

class OrderItem: OrderItemBase {

    constructor(): super()
    constructor(other: OrderItem): super(other)

    fun copy(block: (OrderItem) -> Unit): OrderItem = OrderItem(this).also(block)

}
