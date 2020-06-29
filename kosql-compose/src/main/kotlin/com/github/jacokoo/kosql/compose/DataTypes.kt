package com.github.jacokoo.kosql.compose

import java.math.BigDecimal
import java.math.BigInteger
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

abstract class NullableType<out T>(private val inner: DataType<T>): DataType<T> {
    override val nullValue: T = inner.nullValue

    override fun toDb(t: Any?): Any? = when {
        t == null || isNullValue(t) -> null
        else -> t
    }

    override fun fromDb(o: Any?): T = o?.let { inner.fromDb(it) } ?: nullValue

    open fun isNullValue(t: Any?): Boolean = t == nullValue
}

class IntType: DataType<Int> {
    override val nullValue: Int = 0
    override fun fromDb(o: Any?): Int = o?.let { when (it) {
        is Long -> it.toInt()  // auto-increment key returned from db is Long
        is ByteArray -> it.fold(0) {acc, i -> (acc shl 8) or (i.toInt() and 0xff)}
        else -> o as Int
    } } ?: nullValue
}
class IntNullType: NullableType<Int>(IntType())

class LongType: DataType<Long> {
    override val nullValue: Long = 0L
    override fun fromDb(o: Any?): Long = o?.let { when (it) {
        is ByteArray -> it.fold(0L) {acc, i -> (acc shl 8) or (i.toLong() and 0xff)}
        is BigInteger -> it.toLong()
        else -> o as Long
    } } ?: nullValue
}
class LongNullType: NullableType<Long>(LongType())

class FloatType: DataType<Float> {
    override val nullValue: Float = 0.0f
    override fun fromDb(o: Any?): Float = (o ?: 0) as Float
}
class FloatNullType: NullableType<Float>(FloatType())

class DoubleType: DataType<Double> {
    override val nullValue: Double = 0.0
    override fun fromDb(o: Any?): Double = (o ?: 0) as Double
}
class DoubleNullType: NullableType<Double>(DoubleType())

class DecimalType: DataType<BigDecimal> {
    override val nullValue: BigDecimal = BigDecimal.ZERO
    override fun fromDb(o: Any?): BigDecimal {
        if (o == null) return BigDecimal.ZERO
        return when (o) {
            is BigDecimal -> o
            is Int -> o.toBigDecimal()
            is Long -> o.toBigDecimal()
            is Double -> o.toBigDecimal()
            is Float -> o.toBigDecimal()
            is Number -> BigDecimal(o.toString())
            else -> BigDecimal.ZERO
        }
    }
}
class DecimalNullType: NullableType<BigDecimal>(DecimalType())

class StringType: DataType<String> {
    override val nullValue: String = ""
    override fun fromDb(o: Any?): String = (o ?: "") as String
}
class StringNullType: NullableType<String>(StringType())

class DateType: DataType<LocalDate> {
    override val nullValue = LocalDate.of(1970, 1, 1)
    override fun fromDb(o: Any?) = o?.let { when (it) {
        is Date -> it.toLocalDate()
        is Timestamp -> it.toLocalDateTime().toLocalDate()
        else -> nullValue
    }} ?: nullValue
    override fun toDb(t: Any?): Any? = t?.let { it.toString() }
}
class DateNullType: NullableType<LocalDate>(DateType())

class DateTimeType: DataType<LocalDateTime> {
    override val nullValue = LocalDateTime.of(1970, 1, 1, 0, 0, 0)
    override fun fromDb(o: Any?) = o?.let { (it as Timestamp).toLocalDateTime() } ?: nullValue
    override fun toDb(t: Any?): Any? = t?.let { it.toString() }
}
class DateTimeNullType: NullableType<LocalDateTime>(DateTimeType())

class DateTimeLongType: DataType<LocalDateTime> {
    override val nullValue = LocalDateTime.of(1970, 1, 1, 0, 0, 0)
    override fun fromDb(o: Any?) = o?.let {
        Instant.ofEpochMilli(it as Long).atZone(ZoneId.systemDefault()).toLocalDateTime()
    } ?: nullValue
    override fun toDb(t: Any?) = ((t?.let { it as LocalDateTime }) ?: nullValue)
        .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}
class DateTimeLongNullType: NullableType<LocalDateTime>(DateTimeLongType())

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
class BooleanNullType: NullableType<Boolean>(BooleanType())

class ByteArrayType: DataType<ByteArray> {
    override val nullValue: ByteArray = ByteArray(0)
    override fun fromDb(o: Any?): ByteArray = o?.let { when (it) {
        is Blob -> it.getBytes(1, it.length().toInt())
        else -> it as ByteArray
    } } ?: nullValue
}
class ByteArrayNullType: NullableType<ByteArray>(ByteArrayType()) {
    override fun isNullValue(t: Any?): Boolean = t?.let {
        if (it is ByteArray && it.size == 0) true
        else false
    } ?: false
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
