package com.github.jacokoo.kosql

import com.github.jacokoo.kosql.statements.SQLBuilderContext

interface Expression<T>: SQLPart

object TRUE: Expression<Any> {
    override fun toSQL(ctx: SQLBuilderContext): String = "1 = 1"
}

data class ComposeExpression<T> (
        private val op: String,
        private val left: Expression<T>,
        private val right: Expression<*>,
        private val quote: Boolean
): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String = when (quote) {
        true -> "(${left.toSQL(ctx)}) $op (${right.toSQL(ctx)})"
        else -> "${left.toSQL(ctx)} $op ${right.toSQL(ctx)}"
    }
}

data class SingleColumnExpression<T> (private val op: String, private val column: Column<T>): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String = "${column.toSQL(ctx)} $op"
}

data class ColumnToColumnExpression<T> (
        private val op: String,
        private val left: Column<T>,
        private val right: Column<T>
): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String = "${left.toSQL(ctx)} $op ${right.toSQL(ctx)}"
}

data class ColumnToValueExpression<T> (
        private val op: String,
        private val left: Column<T>,
        private val right: T
): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String {
        ctx.argument(left.type.toDb(right))
        return "${left.toSQL(ctx)} $op ?"
    }
}

data class ColumnToExpressionExpression<T> (
        private val op: String,
        private val left: Column<T>,
        private val right: Expression<T>
): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String = "${left.toSQL(ctx)} $op ${right.toSQL(ctx)}"
}

data class BetweenExpression<T> (
        private val left: Column<T>,
        private val small: T,
        private val big: T
): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String = "BETWEEN ? AND ?"
}

data class MultipleValueExpression<T> (
        private val op: String,
        private val left: Column<T>,
        private val values: List<T>
): Expression<T> {
    override fun toSQL(ctx: SQLBuilderContext): String = "${left.toSQL(ctx)} $op ${values.map { "?" }.joinToString(prefix = "(", postfix = ")")}"
}
