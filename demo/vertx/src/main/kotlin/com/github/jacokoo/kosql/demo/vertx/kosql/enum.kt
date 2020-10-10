package com.github.jacokoo.kosql.demo.vertx.kosql

import com.github.jacokoo.kosql.compose.type.DataType

import com.github.jacokoo.kosql.demo.vertx.entity.DemoType

abstract class IntEnumType<T: Enum<*>>: DataType<T> {
    abstract val clazz: Class<T>
    override fun fromDb(o: Any?): T = o?.let { clazz.enumConstants[when(it) {
        is Byte -> it.toInt()
        is Short -> it.toInt()
        else -> it as Int
    }] } ?: nullValue
    override fun toDb(t: Any?): Any? = t?.let { clazz.enumConstants.indexOf(it) }
}

abstract class StringEnumType<T: Enum<*>>: DataType<T> {
    abstract val clazz: Class<T>
    override fun fromDb(o: Any?): T = o?.let { oo -> clazz.enumConstants.find { it.name == oo } } ?: nullValue
    override fun toDb(t: Any?): Any? = t?.let { it.toString() }
}

class DemoTinyEnumType: IntEnumType<DemoType>() {
    override val clazz: Class<DemoType> = DemoType::class.java
    override val nullValue: DemoType = DemoType.TYPE1
}
