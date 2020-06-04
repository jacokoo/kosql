package com.github.jacokoo.kosql.compose.statements

import com.github.jacokoo.kosql.compose.*
import java.math.BigDecimal

open class Function<T>(private val fn: String, val column: Column<T>): Column<T> {
    private var innerAlias = ""
    override fun sqlName(ctx: SQLBuilderContext): String = "$fn(${column.toSQL(ctx)})"
    override val alias: String
        get() = if (innerAlias.isBlank()) column.alias else innerAlias

    override val aliasRequired: Boolean
        get() = column.aliasRequired

    override val allowNull: Boolean
        get() = column.allowNull

    override val autoIncrement: Boolean
        get() = column.autoIncrement

    override val defaultValue: T
        get() = column.defaultValue

    override val name: String
        get() = column.name

    override val table: Table<*, Entity<*>>
        get() = column.table

    override val type: DataType<T>
        get() = column.type

    override fun AS(alias: String): Column<T> {
        this.innerAlias = alias
        return this
    }
}

open class DecimalFunction<T>(private val fn: String, val column: Column<T>): Column<BigDecimal> {
    private var innerAlias = ""
    private val dataType = DecimalType()

    override fun sqlName(ctx: SQLBuilderContext): String = "$fn(${column.toSQL(ctx)})"

    override val alias: String
        get() = if (innerAlias.isBlank()) column.alias else innerAlias

    override val aliasRequired: Boolean
        get() = column.aliasRequired

    override val allowNull: Boolean
        get() = column.allowNull

    override val autoIncrement: Boolean
        get() = column.autoIncrement

    override val defaultValue: BigDecimal
        get() = dataType.nullValue

    override val name: String
        get() = column.name

    override val table: Table<*, Entity<*>>
        get() = column.table

    override val type: DataType<BigDecimal>
        get() = dataType

    override fun AS(alias: String): Column<BigDecimal> {
        this.innerAlias = alias
        return this
    }
}

class Sum<T: Number>(col: Column<T>): DecimalFunction<T>("SUM", col)
class Avg<T: Number>(col: Column<T>): DecimalFunction<T>("AVG", col)
class Min<T: Number>(col: Column<T>): Function<T>("MIN", col)
class Max<T: Number>(col: Column<T>): Function<T>("MAX", col)
class Distinct<T>(col: Column<T>): Function<T>("", col) {
    override fun sqlName(ctx: SQLBuilderContext): String = "DISTINCT ${column.toSQL(ctx)}"
}

class Count<T> (override val alias: String = ""): Column<Int> {
    override val aliasRequired: Boolean = false
    override val name: String = "*"
    override val table: Table<Any, Entity<Any>> = EmptyTable()
    override val type: DataType<Int> = IntType()
    override val allowNull: Boolean = false
    override val defaultValue: Int = 0
    override val autoIncrement: Boolean = false
    private lateinit var column: Column<T>

    constructor(column: Column<T>, alias: String = ""): this(alias) {
        this.column = column
    }

    override infix fun AS(alias: String): Count<T> = if (this::column.isInitialized) Count(column, alias) else Count(alias)

    override fun sqlName(ctx: SQLBuilderContext): String =
        if (!this::column.isInitialized) "COUNT(*)" else "COUNT(${column.toSQL(ctx)})"

}
