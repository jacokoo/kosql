package com.github.jacokoo.kosql.compose

import com.github.jacokoo.kosql.compose.type.DataType

enum class Order { ASC, DESC }

interface Column<T>: Named<Column<T>> {
    val table: InnerTable<*, Entity<*>>
    val type: DataType<T>
    val allowNull: Boolean
    val defaultValue: T
    val autoIncrement: Boolean

    fun ASC(): Pair<Column<T>, Order> = this to Order.ASC
    fun DESC(): Pair<Column<T>, Order> = this to Order.DESC
}

data class DefaultColumn<T>(
    override val table: InnerTable<*, Entity<*>>,
    override val name: String,
    override val type: DataType<T>,
    override val alias: String = "",
    override val allowNull: Boolean = false,
    override val defaultValue: T = type.nullValue,
    override val autoIncrement: Boolean = false,
    override val aliasRequired: Boolean = false
): Column<T> {
    override fun AS(alias: String): Column<T> = copy(alias = alias)
    fun nullable(): Column<T> = copy(allowNull = true)
    fun default(v: T) = copy(defaultValue = v)
}