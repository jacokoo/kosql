package com.github.jacokoo.kosql.compose

import java.math.BigDecimal
import java.sql.Blob
import java.sql.Date
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

interface DataType<out T> {
    val nullValue: T
    fun fromDb(o: Any?): T
    fun toDb(t: Any?): Any? = t
}

class IntType: DataType<Int> {
    override val nullValue: Int = 0
    override fun fromDb(o: Any?): Int = o?.let { when (it) {
        is Long -> it.toInt()  // auto-increment key returned from db is Long
        is ByteArray -> it.fold(0) {acc, i -> (acc shl 8) or (i.toInt() and 0xff)}
        else -> o as Int
    } } ?: 0
}

class LongType: DataType<Long> {
    override val nullValue: Long = 0L
    override fun fromDb(o: Any?): Long = o?.let { when (it) {
        is ByteArray -> it.fold(0L) {acc, i -> (acc shl 8) or (i.toLong() and 0xff)}
        else -> o as Long
    } } ?: 0L
}

class FloatType: DataType<Float> {
    override val nullValue: Float = 0.0f
    override fun fromDb(o: Any?): Float = (o ?: 0) as Float
}

class DoubleType: DataType<Double> {
    override val nullValue: Double = 0.0
    override fun fromDb(o: Any?): Double = (o ?: 0) as Double
}

class DecimalType: DataType<BigDecimal> {
    override val nullValue: BigDecimal = BigDecimal.ZERO
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
    override fun fromDb(o: Any?): String = (o ?: "") as String
}

class DateType: DataType<LocalDate> {
    override val nullValue = LocalDate.MIN
    override fun fromDb(o: Any?) = o?.let { when (it) {
        is Date -> it.toLocalDate()
        is Timestamp -> it.toLocalDateTime().toLocalDate()
        else -> nullValue
    }} ?: nullValue
    override fun toDb(t: Any?): Any? = t?.let { Timestamp.valueOf((it as LocalDate).atStartOfDay()) }
}

class DateTimeType: DataType<LocalDateTime> {
    override val nullValue = LocalDateTime.MIN
    override fun fromDb(o: Any?) = o?.let { (it as Timestamp).toLocalDateTime() } ?: nullValue
    override fun toDb(t: Any?): Any? = t?.let { Timestamp.valueOf(it as LocalDateTime) }
}

class DateTimeLongType: DataType<LocalDateTime> {
    override val nullValue = LocalDateTime.MIN
    override fun fromDb(o: Any?) = o?.let {
        Instant.ofEpochMilli(it as Long).atZone(ZoneId.systemDefault()).toLocalDateTime()
    } ?: nullValue
    override fun toDb(t: Any?) = ((t?.let { it as LocalDateTime }) ?: nullValue)
        .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}

class BooleanType: DataType<Boolean> {
    override val nullValue: Boolean = false
    override fun fromDb(o: Any?): Boolean = o?.let {
        when (o) {
            is Boolean -> o
            is Int -> o == 1
            else -> nullValue
        }
    } ?: nullValue

    override fun toDb(t: Any?): Any? = t?.let { if (it as Boolean) 1 else 0 }
}

class ByteArrayType: DataType<ByteArray> {
    override val nullValue: ByteArray = ByteArray(0)
    override fun fromDb(o: Any?): ByteArray = o?.let { when (it) {
        is Blob -> it.getBytes(1, it.length().toInt())
        else -> it as ByteArray
    } } ?: nullValue
}

abstract class IntEnumType<T: Enum<*>>: DataType<T> {
    abstract val clazz: Class<T>
    override fun fromDb(o: Any?): T = o?.let { clazz.enumConstants[it as Int] } ?: nullValue
    override fun toDb(t: Any?): Any? = t?.let { clazz.enumConstants.indexOf(it) }
}

abstract class StringEnumType<T: Enum<*>>: DataType<T> {
    abstract val clazz: Class<T>
    override fun fromDb(o: Any?): T = o?.let { oo -> clazz.enumConstants.find { it.name == oo } } ?: nullValue
    override fun toDb(t: Any?): Any? = t?.let { it.toString() }
}