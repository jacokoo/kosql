package com.github.jacokoo.kosql.generator.columns

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.generator.AbstractColumnGenerator
import com.github.jacokoo.kosql.generator.ColumnDefinition
import com.github.jacokoo.kosql.generator.ColumnGenerator
import java.math.BigDecimal
import java.sql.Types

class IntColumnGenerator: AbstractColumnGenerator<Int>() {
    override val type: DataType<Int> = IntType()
    override fun kotlinType(): Class<*> = Int::class.java

    override fun support(tableName: String, def: ColumnDefinition): Boolean =
        ColumnGenerator.ints.contains(def.dataType) ||
                (ColumnGenerator.bits.contains(def.dataType) && def.columnSize < 32)

    override fun parseDefaultValue(v: Any?): String = v?.let { when(it) {
        is String -> if (it.startsWith("b'")) it.slice(2..(it.length - 2)).toInt(2).toString() else it
        else -> it.toString()
    } } ?: "null"
}

class LongColumnGenerator: AbstractColumnGenerator<Long>() {
    override val type: DataType<Long> = LongType()
    override fun kotlinType(): Class<*> = Long::class.java
    override fun support(tableName: String, def: ColumnDefinition) =
        def.dataType == Types.BIGINT ||
                (ColumnGenerator.bits.contains(def.dataType) && (def.columnSize in (32 until 64)))

    override fun parseDefaultValue(v: Any?): String = v?.let { when(it) {
        is String -> if (it.startsWith("b'")) it.slice(2..(it.length - 2)).toLong(2).toString() else it
        else -> it.toString()
    } + "L" } ?: "null"
}

class FloatColumnGenerator: AbstractColumnGenerator<Float>() {
    override val type: DataType<Float> = FloatType()
    override fun kotlinType(): Class<*> = Float::class.java
    override fun support(tableName: String, def: ColumnDefinition) = def.dataType == Types.FLOAT
}

class DoubleColumnGenerator: AbstractColumnGenerator<Double>() {
    override val type: DataType<Double> = DoubleType()
    override fun kotlinType(): Class<*> = Double::class.java
    override fun support(tableName: String, def: ColumnDefinition) = def.dataType == Types.DOUBLE
}

class DecimalColumnGenerator: AbstractColumnGenerator<BigDecimal>() {
    override val type: DataType<BigDecimal> = DecimalType()
    override fun kotlinType(): Class<*> = BigDecimal::class.java
    override fun parseDefaultValue(v: Any?) = v?.let { "BigDecimal(\"$it\")" } ?: "null"
    override fun support(tableName: String, def: ColumnDefinition) =
            def.dataType == Types.DECIMAL || def.dataType == Types.NUMERIC
}
