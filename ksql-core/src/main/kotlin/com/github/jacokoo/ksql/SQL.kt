package com.github.jacokoo.ksql

import com.github.jacokoo.ksql.statements.SQLBuilderContext

enum class Order { ASC, DESC }

enum class JoinType {
    INNER, LEFT, RIGHT, FULL
}

interface DataType<out T: Any> {
    val nullValue: T
    val needQuote: Boolean
    fun fromDb(o: Any?): T
    fun toDb(t: Any?): Any = t!!
}

interface SQLPart {
    fun toSQL(ctx: SQLBuilderContext): String
}

interface Nameable<out T>: SQLPart {
    val name: String
    val alias: String
    val aliasRequired: Boolean
    fun AS(alias: String): T

    fun sqlName(ctx: SQLBuilderContext): String = name
    override fun toSQL(ctx: SQLBuilderContext): String =
        ctx.alias(this)?.let { "${sqlName(ctx) } AS $it" } ?: sqlName(ctx)

}

interface Column<T: Any>: Nameable<Column<T>> {
    val table: Table
    val type: DataType<T>
    val allowNull: Boolean
    val defaultValue: T

    fun ASC(): Pair<Column<T>, Order> = this to Order.ASC
    fun DESC(): Pair<Column<T>, Order> = this to Order.DESC
}

interface Statement

interface Entity<out T: Table> {
    val TABLE: T
    operator fun set(name: String, value: Any)
    operator fun get(name: String): Any?
}