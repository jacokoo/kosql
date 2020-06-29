package com.github.jacokoo.kosql.test.entity

import com.github.jacokoo.kosql.test.kosql.OfficeBase

class Office: OfficeBase {

    constructor(): super()
    constructor(other: Office): super(other)

    fun copy(block: (Office) -> Unit): Office = Office(this).also(block)

}
