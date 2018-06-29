package com.github.jacokoo.kosql.test.entity

import com.github.jacokoo.kosql.test.kosql.SupportTypeBase

class SupportType: SupportTypeBase {

    constructor(): super()
    constructor(other: SupportType): super(other)

    fun copy(block: (SupportType) -> Unit): SupportType = SupportType(this).also(block)

}
