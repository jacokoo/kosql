package com.github.jacokoo.kosql.example.entity

import com.github.jacokoo.kosql.example.kosql.AbcBase

class Abc: AbcBase {

    constructor(): super()
    constructor(other: Abc): super(other)

    fun copy(block: (Abc) -> Unit): Abc = Abc(this).also(block)

}
