package com.github.jacokoo.kosql.compose.statements

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.SQLBuilderContext
import com.github.jacokoo.kosql.compose.SQLPart

interface Expression<T>: SQLPart {
    fun getParams(): List<Any?> = emptyList()
    companion object {
        val TRUE = object: Expression<Any> {
            override fun toSQL(ctx: SQLBuilderContext): String = "1 = 1"
        }
    }
}

data class SingleColumnExpression<T> (private val op: String, private val column: Column<T>): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String = "${column.toSQL(ctx)} $op"
}

data class ColumnToColumnExpression<T> (
    val op: String,
    val left: Column<T>,
    val right: Column<T>
): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String = "${left.toSQL(ctx)} $op ${right.toSQL(ctx)}"
}

data class ColumnToValueExpression<T> (
    val op: String,
    val left: Column<T>,
    val right: T
): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext) = "${left.toSQL(ctx)} $op ?"
    override fun getParams(): List<Any?> = listOf(right)
}

data class ColumnToExpressionExpression<T> (
    val op: String,
    val left: Column<T>,
    val right: Expression<T>
): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String = "${left.toSQL(ctx)} $op ${right.toSQL(ctx)}"
    override fun getParams(): List<Any?> = right.getParams()
}

data class BetweenExpression<T> (
    val left: Column<T>,
    val small: T,
    val big: T
): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String = "BETWEEN ? AND ?"
    override fun getParams(): List<Any?> = listOf(small, big)
}

data class MultipleValueExpression<T> (
    val op: String,
    val left: Column<T>,
    val values: List<T>
): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String = "${left.toSQL(ctx)} $op ${values.map { "?" }.joinToString(prefix = "(", postfix = ")")}"
    override fun getParams(): List<Any?> = values
}

fun <T> Expression<T>?.params() = this?.getParams() ?: emptyList()
