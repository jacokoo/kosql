package com.github.jacokoo.kosql.compose.type.generate

import com.github.jacokoo.kosql.compose.type.*
import io.vertx.core.buffer.Buffer
import java.math.BigDecimal
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
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

class IntColumnType(type: TypeClass): ColumnType(type, Int::class, "0")
class FloatColumnType(type: TypeClass): ColumnType(type, Float::class, "0.0f")
class DoubleColumnType(type: TypeClass): ColumnType(type, Double::class, "0.0")

class LongColumnType(type: TypeClass): ColumnType(type, Long::class, "0L") {
    override fun doParse(it: String): String = when {
        it.startsWith("b'") -> it.slice(2..(it.length - 2)).toLong(2).toString()
        else -> it
    } + "L"
}

class DecimalColumnType(type: TypeClass): ColumnType(type, BigDecimal::class, "BigDecimal.ZERO") {
    override fun doParse(it: String): String  = "BigDecimal(\"$it\")"
}

class StringColumnType(type: TypeClass): ColumnType(type, String::class, "\"\"") {
    override fun doParse(it: String): String  = "\"$it\""
}

class BooleanColumnType(type: TypeClass): ColumnType(type, Boolean::class, "false") {
    override fun doParse(it: String): String = if (it == "b'1'") "true" else "false"
}

class BufferColumnType(type: TypeClass): ColumnType(type, Buffer::class, "Buffer.buffer()") {
    override fun doParse(it: String): String = "Buffer.buffer()" // can not have default value
}

class DateColumnType(type: TypeClass): ColumnType(type, LocalDate::class, "EPOCH_DATE") {
    override fun doParse(it: String): String = "LocalDate.parse(\"${it}\")"
    override fun extraImports(): Array<String> = arrayOf("com.github.jacokoo.kosql.compose.type.EPOCH_DATE")
}

class DateTimeColumnType(type: TypeClass): ColumnType(type, LocalDateTime::class, "EPOCH_TIME") {
    override fun doParse(it: String): String = when(it) {
        "CURRENT_TIMESTAMP" -> "LocalDateTime.now()"
        else -> "LocalDateTime.parse(\"${it}\")"
    }

    override fun extraImports(): Array<String> = arrayOf("com.github.jacokoo.kosql.compose.type.EPOCH_TIME")
}

class DateTimeLongColumnType(type: TypeClass): ColumnType(type, LocalDateTime::class, "EPOCH_TIME") {
    override fun doParse(it: String): String = when(it) {
        "CURRENT_TIMESTAMP" -> "LocalDateTime.now()"
        else -> "LocalDateTime.parse(\"${it}\")"
    }

    override fun extraImports(): Array<String> = arrayOf("com.github.jacokoo.kosql.compose.type.EPOCH_TIME")
}

private val BITS = listOf("LONGBLOB", "MEDIUMBLOB", "BLOB", "TINYBLOB", "VARBINARY", "BINARY", "BIT")
private val STRS = listOf("CHAR", "VARCHAR", "TINYTEXT", "TEXT", "LONGTEXT")
private val INTS = listOf("SMALLINT", "SMALLINT UNSIGNED", "MEDIUMINT", "MEDIUMINT UNSIGNED", "INTEGER", "YEAR", "INT")

class ColumnFactory {
    fun generate(table: String, def: ColumnDefinition): ColumnType = when(def.typeName) {
        "BIT" -> when {
            def.columnSize < 2 -> BooleanColumnType(def.or(BooleanType::class, BooleanNullType::class))
            else -> LongColumnType(def.or(LongType::class, LongNullType::class))
        }
        "TINYINT", "TINYINT UNSIGNED" -> when {
            def.columnSize < 2 -> BooleanColumnType(def.or(BooleanType::class, BooleanNullType::class))
            else -> IntColumnType(def.or(IntType::class, IntNullType::class))
        }
        in INTS -> IntColumnType(def.or(IntType::class, IntNullType::class))
        in BITS -> BufferColumnType(def.or(BufferType::class, BufferNullType::class))
        in STRS -> StringColumnType(def.or(StringType::class, StringNullType::class))
        "DATE" -> DateColumnType(def.or(DateType::class, DateNullType::class))
        "DATETIME", "TIMESTAMP" -> DateTimeColumnType(def.or(DateTimeType::class, DateTimeNullType::class))
        "TIME" -> ColumnType(def.or(DurationType::class, DurationNullType::class), Duration::class, "Duration.ofSeconds(0)")
        "FLOAT", "FLOAT UNSIGNED" -> FloatColumnType(def.or(FloatType::class, FloatNullType::class))
        "DOUBLE", "DOUBLE UNSIGNED" -> DoubleColumnType(def.or(DoubleType::class, DoubleNullType::class))
        "DECIMAL", "DECIMAL UNSIGNED", "BIGINT UNSIGNED" -> DecimalColumnType(def.or(DecimalType::class, DecimalNullType::class))
        "BIGINT", "INTEGER UNSIGNED", "INT UNSIGNED" -> LongColumnType(def.or(LongType::class, LongNullType::class))
        else -> throw RuntimeException("column is not supported: $def")
    }

    private fun ColumnDefinition.or(t: TypeClass, t2: TypeClass): TypeClass =
        if (nullable) t2 else t
}