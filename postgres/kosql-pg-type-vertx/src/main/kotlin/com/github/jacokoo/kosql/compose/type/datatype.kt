package com.github.jacokoo.kosql.compose.type

import io.vertx.core.buffer.Buffer
import io.vertx.sqlclient.data.Numeric
import java.math.BigDecimal
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

interface DataType<out T> {
    val nullValue: T

    @Suppress("unchecked_cast")
    fun convert(o: Any): T = o as T

    fun toDb(t: Any?): Any? = t
    fun fromDb(o: Any?): T = o?.let { convert(it) } ?: nullValue
}

abstract class NullableType<out T>(private val inner: DataType<T>): DataType<T> {
    override val nullValue: T = inner.nullValue

    override fun toDb(t: Any?): Any? = when {
        t == null || isNullValue(t) -> null
        else -> inner.toDb(t)
    }

    override fun convert(o: Any): T = inner.convert(o)
    open fun isNullValue(t: Any?): Boolean = t == nullValue
}

class BooleanType(override val nullValue: Boolean = false): DataType<Boolean>
class BooleanNullType: NullableType<Boolean>(BooleanType())

class ShortType(override val nullValue: Short = 0): DataType<Short>
class ShortNullType: NullableType<Short>(ShortType())

class IntType(override val nullValue: Int = 0): DataType<Int> {
    override fun convert(o: Any): Int = when {
        // count() return Long, convert it to int
        o is Long -> o.toInt()
        else -> o as Int
    }
}
class IntNullType: NullableType<Int>(IntType())

class LongType(override val nullValue: Long = 0L): DataType<Long>
class LongNullType: NullableType<Long>(LongType())

class FloatType(override val nullValue: Float = 0.0f): DataType<Float>
class FloatNullType: NullableType<Float>(FloatType())

class DoubleType(override val nullValue: Double = 0.0): DataType<Double>
class DoubleNullType: NullableType<Double>(DoubleType())

class StringType(override val nullValue: String = ""): DataType<String>
class StringNullType: NullableType<String>(StringType())

class DecimalType: DataType<BigDecimal> {
    override val nullValue: BigDecimal = BigDecimal.ZERO
    override fun convert(o: Any): BigDecimal = when (o) {
        is Numeric -> o.bigDecimalValue()
        else -> BigDecimal.ZERO
    }
}
class DecimalNullType: NullableType<BigDecimal>(DecimalType())

@JvmField
val ZERO_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000")

class UUIDType(override val nullValue: UUID = ZERO_UUID): DataType<UUID>
class UUIDNullType: NullableType<UUID>(UUIDType())

@JvmField
val EPOCH_DATE = LocalDate.of(1970, 1, 1)

@JvmField
val EPOCH_TIME = LocalDateTime.of(1970, 1, 1, 0, 0, 0)

class DateType(override val nullValue: LocalDate = EPOCH_DATE): DataType<LocalDate>
class DateNullType: NullableType<LocalDate>(DateType())

class DateTimeType(override val nullValue: LocalDateTime = EPOCH_TIME): DataType<LocalDateTime>
class DateTimeNullType: NullableType<LocalDateTime>(DateTimeType())

class DateTimeLongType: DataType<LocalDateTime> {
    override val nullValue: LocalDateTime = EPOCH_TIME
    override fun convert(o: Any): LocalDateTime =
        Instant.ofEpochMilli(o as Long).atZone(ZoneId.systemDefault()).toLocalDateTime()

    override fun toDb(t: Any?) = (t?.let { it as LocalDateTime } ?: nullValue)
        .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}
class DateTimeLongNullType: NullableType<LocalDateTime>(DateTimeLongType())

class BufferType(override val nullValue: Buffer = Buffer.buffer()): DataType<Buffer>
class BufferNullType: NullableType<Buffer>(BufferType()) {
    override fun isNullValue(t: Any?): Boolean = t?.let { convert(t).length() == 0 } ?: true
}
