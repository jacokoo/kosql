package com.github.jacokoo.kosql.test.entity

import com.github.jacokoo.kosql.test.kosql.PaymentBase

class Payment: PaymentBase {

    constructor(): super()
    constructor(other: Payment): super(other)

    fun copy(block: (Payment) -> Unit): Payment = Payment(this).also(block)

}
