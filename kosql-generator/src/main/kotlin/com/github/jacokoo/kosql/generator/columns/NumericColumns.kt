package com.github.jacokoo.kosql.generator.columns

import com.github.jacokoo.kosql.*
import com.github.jacokoo.kosql.generator.AbstractColumnGenerator
import com.github.jacokoo.kosql.generator.ColumnDefinition
import java.math.BigDecimal
import java.sql.Types

class IntColumnGenerator: AbstractColumnGenerator<Int>() {
    override val type: DataType<Int> = IntType()
    private val supported = listOf(Types.INTEGER, Types.SMALLINT, Types.TINYINT, Types.BIT)

    override fun support(tableName: String, def: ColumnDefinition): Boolean {
        return supported.contains(def.dataType)
    }
}

class LongColumnGenerator: AbstractColumnGenerator<Long>() {
    override val type: DataType<Long> = LongType()
    override fun support(tableName: String, def: ColumnDefinition) = def.dataType == Types.BIGINT
}

class FloatColumnGenerator: AbstractColumnGenerator<Float>() {
    override val type: DataType<Float> = FloatType()
    override fun support(tableName: String, def: ColumnDefinition) = def.dataType == Types.FLOAT
}

class DoubleColumnGenerator: AbstractColumnGenerator<Double>() {
    override val type: DataType<Double> = DoubleType()
    override fun support(tableName: String, def: ColumnDefinition) = def.dataType == Types.DOUBLE
}

class DecimalColumnGenerator: AbstractColumnGenerator<BigDecimal>() {
    override val type: DataType<BigDecimal> = DecimalType()
    override fun support(tableName: String, def: ColumnDefinition) =
            def.dataType == Types.DECIMAL || def.dataType == Types.NUMERIC
}