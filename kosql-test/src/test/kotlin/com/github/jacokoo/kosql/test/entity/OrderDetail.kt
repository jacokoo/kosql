package com.github.jacokoo.kosql.test.entity

import com.github.jacokoo.kosql.test.kosql.OrderDetailBase

class OrderDetail: OrderDetailBase {

    constructor(): super()
    constructor(other: OrderDetail): super(other)

    fun copy(block: (OrderDetail) -> Unit): OrderDetail = OrderDetail(this).also(block)

}
