package com.github.jacokoo.kosql.compose.type.generate

import com.github.jacokoo.kosql.compose.type.*
import java.math.BigDecimal
import java.sql.Types
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

class IntColumnType(type: TypeClass): ColumnType(type, Int::class, "0") {
    override fun doParse(it: String): String = when {
        it.startsWith("b'") -> it.slice(2..(it.length - 2)).toInt(2).toString()
        else -> it
    }
}

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

class ByteArrayColumnType(type: TypeClass): ColumnType(type, ByteArray::class, "ByteArray(0)") {
    override fun doParse(it: String): String = "ByteArray(0)" // can not have default value
}

class DateColumnType(type: TypeClass): ColumnType(type, LocalDate::class, "EPOCH_DATE") {
    override fun doParse(it: String): String = "LocalDate.parse(\"${it}\")"
    override fun extraImports(): Array<String> = arrayOf("getEPOCH_DATE")
}

class DateTimeColumnType(type: TypeClass): ColumnType(type, LocalDateTime::class, "EPOCH_TIME") {
    override fun doParse(it: String): String = when(it) {
        "CURRENT_TIMESTAMP" -> "LocalDateTime.now()"
        else -> "LocalDateTime.parse(\"${it}\")"
    }
    override fun extraImports(): Array<String> = arrayOf("getEPOCH_TIME")
}

class DateTimeLongColumnType(type: TypeClass): ColumnType(type, LocalDateTime::class, "EPOCH_TIME") {
    override fun doParse(it: String): String = when(it) {
        "CURRENT_TIMESTAMP" -> "LocalDateTime.now()"
        else -> "LocalDateTime.parse(\"${it}\")"
    }
    override fun extraImports(): Array<String> = arrayOf("getEPOCH_TIME")
}

private val INTS = listOf(Types.INTEGER, Types.SMALLINT, Types.TINYINT)
private val BITS = listOf(Types.BIT, Types.BINARY, Types.VARBINARY, Types.LONGVARBINARY)
private val STRS = listOf(
    Types.CLOB, Types.CHAR, Types.VARCHAR, Types.LONGVARCHAR,
    Types.LONGNVARCHAR, Types.NCHAR, Types.NVARCHAR
)
//
//private val BITS = listOf("LONGBLOB", "MEDIUMBLOB", "BLOB", "TINYBLOB", "VARBINARY", "BINARY", "BIT")
//private val STRS = listOf("CHAR", "VARCHAR")
//private val INTS = listOf("SMALLINT", "SMALLINT UNSIGNED", "MEDIUMINT", "MEDIUMINT UNSIGNED", "INTEGER")

class ColumnFactory {
    fun generate(table: String, def: ColumnDefinition): ColumnType = when {
//        in BITS -> when {
//            def.columnSize < 2 -> BooleanColumnType(def.or(BooleanType::class, BooleanNullType::class))
//            def.columnSize < 32 -> IntColumnType(def.or(IntType::class, IntNullType::class))
//            def.columnSize < 64 -> LongColumnType(def.or(LongType::class, LongNullType::class))
//            else -> ByteArrayColumnType(def.or(ByteArrayType::class, ByteArrayNullType::class))
//        }
//
//        "TINYINT", "TINYINT UNSIGNED" -> when {
//            def.columnSize < 2 -> BooleanColumnType(def.or(BooleanType::class, BooleanNullType::class))
//            else -> IntColumnType(def.or(IntType::class, IntNullType::class))
//        }
//        in INTS -> IntColumnType(def.or(IntType::class, IntNullType::class))
//
//        "INTEGER UNSIGNED" -> LongColumnType(def.or(LongType::class, LongNullType::class))
//        "BIGINT", "BIGINT UNSIGNED" -> when {
//            def.name.endsWith("time") -> DateTimeLongColumnType(def.or(DateTimeLongType::class, DateTimeNullType::class))
//            else -> LongColumnType(def.or(LongType::class, LongNullType::class))
//        }
//        "FLOAT" -> ColumnType(def.or(FloatType::class, FloatNullType::class))
//        "DOUBLE" -> ColumnType(def.or(DoubleType::class, DoubleNullType::class))
//        "DECIMAL" -> DecimalColumnType(def.or(DecimalType::class, DecimalNullType::class))
//
//        in STRS -> StringColumnType(def.or(StringType::class, StringNullType::class))
//
//        "DATE" -> DateColumnType(def.or(DateType::class, DateNullType::class))
//        "DATETIME", "TIMESTAMP" -> DateTimeColumnType(def.or(DateTimeType::class, DateTimeNullType::class))
//          "TIME" ->


        INTS.contains(def.dataType) || (BITS.contains(def.dataType) && def.columnSize < 32) ->
            IntColumnType(def.or(IntType::class, IntNullType::class))

        Types.BIGINT == def.dataType && def.name.endsWith("time") ->
            DateTimeLongColumnType(def.or(DateTimeLongType::class, DateTimeNullType::class))

        Types.BIGINT == def.dataType || (BITS.contains(def.dataType) && (def.columnSize in (32 until 64))) ->
            LongColumnType(def.or(LongType::class, LongNullType::class))

        def.dataType == Types.FLOAT || def.dataType == Types.REAL ->
            ColumnType(def.or(FloatType::class, FloatNullType::class), Float::class, "0.0f")

        def.dataType == Types.DOUBLE ->
            ColumnType(def.or(DoubleType::class, DoubleNullType::class), Double::class, "0.0")

        def.dataType == Types.DECIMAL || def.dataType == Types.NUMERIC ->
            DecimalColumnType(def.or(DecimalType::class, DecimalNullType::class))

        Types.BOOLEAN == def.dataType ||
            (Types.BIT == def.dataType && def.columnSize < 2) ||  // mysql tinyint(1) got BIT(null) here
            (Types.TINYINT == def.dataType && def.columnSize == 1) ->
            BooleanColumnType(def.or(BooleanType::class, BooleanNullType::class))

        (BITS.contains(def.dataType) && def.columnSize >= 64) || Types.BLOB == def.dataType ->
            ByteArrayColumnType(def.or(ByteArrayType::class, ByteArrayNullType::class))

        STRS.contains(def.dataType) ->
            StringColumnType(def.or(StringType::class, StringNullType::class))

        Types.DATE == def.dataType ->
            DateColumnType(def.or(DateType::class, DateNullType::class))

        Types.TIMESTAMP == def.dataType ->
            DateTimeColumnType(def.or(DateTimeType::class, DateTimeNullType::class))

        else -> throw RuntimeException("column is not supported: $def")
    }

    private fun ColumnDefinition.or(t: TypeClass, t2: TypeClass): TypeClass =
        if (nullable) t2 else t
}
