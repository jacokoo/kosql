package com.github.jacokoo.ksql

import com.github.jacokoo.ksql.statements.QueryData
import com.github.jacokoo.ksql.statements.SQLBuilderContext

data class DefaultColumn<T: Any>(
        override val table: Table,
        override val name: String,
        override val type: DataType<T>,
        override val alias: String = "",
        override val aliasRequired: Boolean = false,
        override val allowNull: Boolean = false,
        override val defaultValue: T = type.nullValue
): Column<T> {
    override fun AS(alias: String): Column<T> = this.copy(alias = alias)
    override fun sqlName(ctx: SQLBuilderContext): String = "${ctx.alias(table)}.$name"

    fun nullable(): DefaultColumn<T> = this.copy(allowNull = true)
    fun default(t: T): DefaultColumn<T> = this.copy(defaultValue = t)
}

open class Table(override val name: String, override val alias: String = ""): Nameable<Table> {
    override val aliasRequired = true
    var columns: List<Column<*>> = listOf()

    fun int(name: String): DefaultColumn<Int> = DefaultColumn(this, name, IntType()).also { columns += it }
    fun string(name: String): DefaultColumn<String> = DefaultColumn(this, name, StringType()).also { columns += it }

    operator fun invoke() = columns.toTypedArray()
    override fun AS(alias: String): Table = Table(name, alias)
}

class TableLike(private val data: QueryData, alias: String, private val original: List<Column<*>>): Table("", alias) {
    private val map = original.associate { it to DefaultColumn(this, if (it.alias == "") it.name else it.alias, it.type) }
    init {
        this.columns = map.values.toList()
    }

    override fun AS(alias: String): Table = TableLike(data, alias, original)

    override fun sqlName(ctx: SQLBuilderContext): String = "(${ctx.builder.build(data, ctx).sql})"

    operator fun <T: Any> get(col: Column<T>): Column<T> {
        val c = original.find { it.table == col.table && it.name == col.name }
                ?: throw RuntimeException("Can not find column $col.name in table-like $alias")
        return map[c] as Column<T>
    }

    inline operator fun <reified T: Any> get(name: String): Column<T> {
        return columns.find { it.name == name }!! as Column<T>
    }
}