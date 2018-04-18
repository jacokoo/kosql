package com.github.jacokoo.ksql

import java.math.BigDecimal

interface DataType<out T: Any> {
    val nullValue: T
    val needQuote: Boolean
    fun fromDb(o: Any?): T
    fun toDb(t: Any?): Any = t!!
}

class IntType: DataType<Int> {
    override val nullValue: Int = 0
    override val needQuote: Boolean = false
    override fun fromDb(o: Any?): Int = (o ?: 0) as Int
}

class LongType: DataType<Long> {
    override val nullValue: Long = 0L
    override val needQuote: Boolean = false
    override fun fromDb(o: Any?): Long = (o ?: 0) as Long
}

class FloatType: DataType<Float> {
    override val nullValue: Float = 0.0f
    override val needQuote: Boolean = false
    override fun fromDb(o: Any?): Float = (o ?: 0) as Float
}

class DoubleType: DataType<Double> {
    override val nullValue: Double = 0.0
    override val needQuote: Boolean = false
    override fun fromDb(o: Any?): Double = (o ?: 0) as Double
}

class DecimalType: DataType<BigDecimal> {
    override val nullValue: BigDecimal = BigDecimal.ZERO
    override val needQuote: Boolean = false
    override fun fromDb(o: Any?): BigDecimal {
        if (o == null) return BigDecimal.ZERO
        return when (o) {
            is BigDecimal -> o
            else -> BigDecimal.ZERO
        }
    }
}

class StringType: DataType<String> {
    override val nullValue: String = ""
    override val needQuote: Boolean = true
    override fun fromDb(o: Any?): String = (o ?: "") as String
}