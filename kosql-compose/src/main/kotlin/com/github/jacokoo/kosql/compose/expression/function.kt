package com.github.jacokoo.kosql.compose.expression
import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.type.DataType
import com.github.jacokoo.kosql.compose.type.DecimalType
import com.github.jacokoo.kosql.compose.type.IntType
import java.math.BigDecimal

open class DecimalFunction<T>(val fn: String, val column: Column<T>): Column<BigDecimal> {
    private var innerAlias = ""
    private val dataType = DecimalType()

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

    override val table: InnerTable<*, Entity<*>>
        get() = column.table

    override val type: DataType<BigDecimal>
        get() = dataType

    override fun AS(alias: String): Column<BigDecimal> {
        this.innerAlias = alias
        return this
    }
}

open class Function<T>(val fn: String, val column: Column<T>): Column<T> by column

class Sum<T: Number>(col: Column<T>): DecimalFunction<T>("SUM", col)
class Avg<T: Number>(col: Column<T>): DecimalFunction<T>("AVG", col)
class Min<T: Number>(col: Column<T>): Function<T>("MIN", col)
class Max<T: Number>(col: Column<T>): Function<T>("MAX", col)
class Distinct<T>(col: Column<T>): Function<T>("DISTINCT", col)

class Count<T> (override val alias: String = ""): Column<Int> {
    override val aliasRequired: Boolean = false
    override val name: String = "*"
    override val table: InnerTable<Any, Entity<Any>> = EmptyInnerTable()
    override val type: DataType<Int> = IntType()
    override val allowNull: Boolean = false
    override val defaultValue: Int = 0
    override val autoIncrement: Boolean = false
    lateinit var column: Column<T>

    constructor(column: Column<T>, alias: String = ""): this(alias) {
        this.column = column
    }

    override infix fun AS(alias: String): Count<T> = if (this::column.isInitialized) Count(column, alias) else Count(alias)

    fun hasColumn(): Boolean = this::column.isInitialized
}
