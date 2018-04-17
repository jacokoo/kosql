package com.github.jacokoo.ksql

import com.github.jacokoo.ksql.statements.SQLBuilderContext

open class Function<T: Any>(private val fn: String, val column: Column<T>): Column<T> by column{
    override fun sqlName(ctx: SQLBuilderContext): String = "$fn(${column.toSQL(ctx)})"
}

class Sum<T: Number>(col: Column<T>): Function<T>("SUM", col)
class Avg<T: Number>(col: Column<T>): Function<T>("AVG", col)
class Min<T: Number>(col: Column<T>): Function<T>("MIN", col)
class Max<T: Number>(col: Column<T>): Function<T>("MAX", col)
class Distinct<T: Any>(col: Column<T>): Function<T>("", col) {
    override fun sqlName(ctx: SQLBuilderContext): String = "DISTINCT ${column.toSQL(ctx)}"
}

class Count<T: Any> (override val alias: String = ""): Column<Int> {
    override val aliasRequired: Boolean = false
    override val name: String = "*"
    override val table: Table = Table("nothing")
    override val type: DataType<Int> = IntType()
    private lateinit var column: Column<T>

    constructor(column: Column<T>, alias: String = ""): this(alias) {
        this.column = column
    }

    override infix fun AS(alias: String): Count<T> = if (this::column.isInitialized) Count(column, alias) else Count(alias)

    override fun sqlName(ctx: SQLBuilderContext): String =
        if (!this::column.isInitialized) "COUNT(*)" else "COUNT(${column.toSQL(ctx)})"

}