package com.github.jacokoo.kosql.compose.type

import java.math.BigDecimal

interface DataType<out T> {
    val nullValue: T
    fun convert(o: Any): T

    fun toDb(t: Any?): Any? = t
    fun fromDb(o: Any?): T = o?.let { convert(it) } ?: nullValue
}

class IntType: DataType<Int> {
    override val nullValue: Int = 0
    override fun convert(o: Any): Int = o as Int
}

class DecimalType: DataType<BigDecimal> {
    override val nullValue: BigDecimal = BigDecimal.ZERO
    override fun convert(o: Any): BigDecimal = o as BigDecimal
}
