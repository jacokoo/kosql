package com.github.jacokoo.kosql.compose.type

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
    fun convert(o: Any): T

    fun toDb(t: Any?): Any? = t
    fun fromDb(o: Any?): T = o?.let { convert(it) } ?: nullValue
}

abstract class NullableType<out T>(private val inner: DataType<T>): DataType<T> {
    override val nullValue: T = inner.nullValue

    override fun toDb(t: Any?): Any? = when {
        t == null || isNullValue(t) -> null
        else -> t
    }

    override fun convert(o: Any): T = inner.convert(o)
    open fun isNullValue(t: Any?): Boolean = t == nullValue
}

class IntType: DataType<Int> {
    override val nullValue: Int = 0
    override fun convert(o: Any): Int = when(o) {
        is Long -> o.toInt()  // auto-increment key returned from db is Long
        is ByteArray -> o.fold(0) {acc, i -> (acc shl 8) or (i.toInt() and 0xff)}
        else -> o as Int
    }
}
class IntNullType: NullableType<Int>(IntType())

class LongType: DataType<Long> {
    override val nullValue: Long = 0L
    override fun convert(o: Any): Long = when (o) {
        is ByteArray -> o.fold(0L) {acc, i -> (acc shl 8) or (i.toLong() and 0xff)}
        is BigInteger -> o.toLong()
        else -> o as Long
    }
}
class LongNullType: NullableType<Long>(LongType())

class FloatType: DataType<Float> {
    override val nullValue: Float = 0.0f
    override fun convert(o: Any): Float = o as Float
}
class FloatNullType: NullableType<Float>(FloatType())

class DoubleType: DataType<Double> {
    override val nullValue: Double = 0.0
    override fun convert(o: Any): Double = o as Double
}
class DoubleNullType: NullableType<Double>(DoubleType())

class DecimalType: DataType<BigDecimal> {
    override val nullValue: BigDecimal = BigDecimal.ZERO
    override fun convert(o: Any): BigDecimal = when (o) {
        is BigDecimal -> o
        is Int -> o.toBigDecimal()
        is Long -> o.toBigDecimal()
        is Double -> o.toBigDecimal()
        is Float -> o.toBigDecimal()
        is Number -> BigDecimal(o.toString())
        else -> BigDecimal.ZERO
    }
}
class DecimalNullType: NullableType<BigDecimal>(DecimalType())

class StringType: DataType<String> {
    override val nullValue: String = ""
    override fun convert(o: Any): String = o as String
}
class StringNullType: NullableType<String>(StringType())

val EPOCH_DATE = LocalDate.of(1970, 1, 1)
val EPOCH_TIME = LocalDateTime.of(1970, 1, 1, 0, 0, 0)

class DateType: DataType<LocalDate> {
    override val nullValue: LocalDate = EPOCH_DATE
    override fun convert(o: Any): LocalDate = when (o) {
        is Date -> o.toLocalDate()
        is Timestamp -> o.toLocalDateTime().toLocalDate()
        else -> nullValue
    }
    override fun toDb(t: Any?): Any? = t?.toString()
}
class DateNullType: NullableType<LocalDate>(DateType())

class DateTimeType: DataType<LocalDateTime> {
    override val nullValue: LocalDateTime = EPOCH_TIME
    override fun convert(o: Any): LocalDateTime = (o as Timestamp).toLocalDateTime()
    override fun toDb(t: Any?): Any? = t?.toString()
}
class DateTimeNullType: NullableType<LocalDateTime>(DateTimeType())

class DateTimeLongType: DataType<LocalDateTime> {
    override val nullValue: LocalDateTime = EPOCH_TIME
    override fun convert(o: Any): LocalDateTime =
        Instant.ofEpochMilli(o as Long).atZone(ZoneId.systemDefault()).toLocalDateTime()

    override fun toDb(t: Any?) = ((t?.let { it as LocalDateTime }) ?: nullValue)
        .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}
class DateTimeLongNullType: NullableType<LocalDateTime>(DateTimeLongType())

class BooleanType: DataType<Boolean> {
    override val nullValue: Boolean = false
    override fun convert(o: Any): Boolean = when (o) {
        is Boolean -> o
        is Int -> o == 1
        else -> nullValue
    }

    override fun toDb(t: Any?): Any? = t?.let { if (it as Boolean) 1 else 0 }
}
class BooleanNullType: NullableType<Boolean>(BooleanType())

class ByteArrayType: DataType<ByteArray> {
    override val nullValue: ByteArray = ByteArray(0)
    override fun convert(o: Any): ByteArray = when (o) {
        is Blob -> o.getBytes(1, o.length().toInt())
        else -> o as ByteArray
    }
}

class ByteArrayNullType: NullableType<ByteArray>(ByteArrayType()) {
    override fun isNullValue(t: Any?): Boolean = t?.let {
        it is ByteArray && it.size == 0
    } ?: false
}
