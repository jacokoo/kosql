package com.github.jacokoo.kosql.compose.type.generate

import com.github.jacokoo.kosql.compose.type.*
import io.vertx.core.buffer.Buffer
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import kotlin.reflect.KClass

data class ColumnDefinition(
    val name: String,
    val dataType: Int,
    val typeName: String,
    val columnSize: Int,
    val decimalDigits: Int,
    val numPrecRadix: Int,
    val nullable: Boolean,
    val defaultValue: String?,
    val remark: String,
    val ordinalPosition: Int,
    val isAutoIncrement: Boolean,
    val isGeneratedColumn: Boolean
)

typealias TypeClass = KClass<out DataType<*>>

open class ColumnType(val type: TypeClass, val dataType: KClass<*>, private val nullValue: String) {
    open fun parseDefaultValue(v: String?): String = v?.let { doParse(it) } ?: nullValue
    open fun doParse(it: String): String = it
    open fun extraImports(): Array<String> = arrayOf()
}

class BooleanColumnType(type: TypeClass): ColumnType(type, Boolean::class, "false")

class ShortColumnType(type: TypeClass, val isAutoIncrement: Boolean): ColumnType(type, Short::class, "0") {
    override fun doParse(it: String): String = if (isAutoIncrement) "0" else it
}

class IntColumnType(type: TypeClass, val isAutoIncrement: Boolean): ColumnType(type, Int::class, "0") {
    override fun doParse(it: String): String = if (isAutoIncrement) "0" else it
}

class LongColumnType(type: TypeClass, val isAutoIncrement: Boolean): ColumnType(type, Long::class, "0L") {
    override fun doParse(it: String): String = if (isAutoIncrement) "0" else it
}

class FloatColumnType(type: TypeClass): ColumnType(type, Float::class, "0.0f")
class DoubleColumnType(type: TypeClass): ColumnType(type, Double::class, "0.0")

class DecimalColumnType(type: TypeClass): ColumnType(type, BigDecimal::class, "BigDecimal.ZERO") {
    override fun doParse(it: String): String  = "BigDecimal(\"$it\")"
}

class StringColumnType(type: TypeClass): ColumnType(type, String::class, "\"\"") {
    override fun doParse(it: String): String  = "\"$it\""
}

class BufferColumnType(type: TypeClass): ColumnType(type, Buffer::class, "Buffer.buffer()") {
    override fun doParse(it: String): String = "Buffer.buffer()" // can not have default value
}

class DateColumnType(type: TypeClass): ColumnType(type, LocalDate::class, "EPOCH_DATE") {
    override fun doParse(it: String): String = when(it) {
        "CURRENT_TIMESTAMP", "now()" -> "LocalDate.now()"
        else -> "LocalDate.parse(\"${it}\")"
    }
    override fun extraImports(): Array<String> = arrayOf("com.github.jacokoo.kosql.compose.type.EPOCH_DATE")
}

class DateTimeColumnType(type: TypeClass): ColumnType(type, LocalDateTime::class, "EPOCH_TIME") {
    override fun doParse(it: String): String = when(it) {
        "CURRENT_TIMESTAMP", "now()" -> "LocalDateTime.now()"
        else -> "LocalDateTime.parse(\"${it}\")"
    }

    override fun extraImports(): Array<String> = arrayOf("com.github.jacokoo.kosql.compose.type.EPOCH_TIME")
}

class DateTimeLongColumnType(type: TypeClass): ColumnType(type, LocalDateTime::class, "EPOCH_TIME") {
    override fun doParse(it: String): String =
        "Instant.ofEpochMilli($it).atZone(ZoneId.systemDefault()).toLocalDateTime()"

    override fun extraImports(): Array<String> = arrayOf(
        "com.github.jacokoo.kosql.compose.type.EPOCH_TIME",
        "java.time.Instant",
        "java.time.ZoneId"
    )
}

class UUIDColumeType(type: TypeClass): ColumnType(type, UUID::class, "ZERO_UUID") {
    override fun doParse(it: String): String = when {
        it.startsWith("uuid_generate") -> "UUID.randomUUID()"
        else -> "ZERO_UUID"
    }
    override fun extraImports(): Array<String> = arrayOf("com.github.jacokoo.kosql.compose.type.ZERO_UUID")
}

class ColumnFactory {
    fun generate(table: String, def: ColumnDefinition): ColumnType = when (def.typeName) {
        "bool" -> BooleanColumnType(def.or(BooleanType::class, BooleanNullType::class))
        "smallserial" -> ShortColumnType(def.or(ShortType::class, ShortNullType::class), true)
        "serial" -> IntColumnType(def.or(IntType::class, IntNullType::class), true)
        "bigserial" -> LongColumnType(def.or(LongType::class, LongNullType::class), true)
        "int2" -> ShortColumnType(def.or(ShortType::class, ShortNullType::class), false)
        "int4" -> IntColumnType(def.or(IntType::class, IntNullType::class), false)
        "int8" -> when {
            def.name.endsWith("time") -> DateTimeLongColumnType(def.or(DateTimeLongType::class, DateTimeLongNullType::class))
            else -> LongColumnType(def.or(LongType::class, LongNullType::class), false)
        }
        "float4" -> FloatColumnType(def.or(FloatType::class, FloatNullType::class))
        "float8" -> DoubleColumnType(def.or(DoubleType::class, DoubleNullType::class))
        "numeric" -> DecimalColumnType(def.or(DecimalType::class, DecimalNullType::class))
        "bytea" -> BufferColumnType(def.or(BufferType::class, BufferNullType::class))
        "uuid" -> UUIDColumeType(def.or(UUIDType::class, UUIDNullType::class))
        "bpchar", "varchar", "text" -> StringColumnType(def.or(StringType::class, StringNullType::class))
        "date" -> DateColumnType(def.or(DateType::class, DateNullType::class))
        "timestamp" -> DateTimeColumnType(def.or(DateTimeType::class, DateTimeNullType::class))
        else -> throw RuntimeException("column is not supported: $def")
    }

    private fun ColumnDefinition.or(t: TypeClass, t2: TypeClass): TypeClass = if (nullable) t2 else t
}
