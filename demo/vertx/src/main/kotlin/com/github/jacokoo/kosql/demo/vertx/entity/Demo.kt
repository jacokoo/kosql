package com.github.jacokoo.kosql.demo.vertx.entity

import com.github.jacokoo.kosql.compose.Item
import com.github.jacokoo.kosql.compose.UseEnum
import com.github.jacokoo.kosql.demo.vertx.kosql.DemoBase

enum class DemoType { TYPE1, TYPE2 }

@UseEnum([Item("f_tiny", DemoType::class)])
class Demo: DemoBase {

    constructor(): super()
    constructor(other: Demo): super(other)

    fun copy(block: (Demo) -> Unit): Demo = Demo(this).also(block)

}
