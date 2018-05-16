package com.github.jacokoo.kosql.compose.statements

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.SQLBuilderContext

interface ExpressionContainer<T> {
    fun set(exp: Expression<*>, isAnd: Boolean = true): T

    fun <T> Expression<T>.and(right: Expression<*>) = LogicPartial(this, right, true)
    fun <T> Expression<T>.or(right: Expression<*>) = LogicPartial(this, right, true)
}

abstract class AbstractExpressionContainer<R: ExpressionContainer<R>>: ExpressionContainer<R> {
    abstract fun refer(): R

    infix fun <T> AND(column: Column<T>) = PartialExpression(refer(), column)
    infix fun <T> AND(e: Expression<T>) = set(e)
    infix fun <T> OR(e: Expression<T>) = set(e, false)
}

data class PartialExpression<L: ExpressionContainer<L>, T>(val left: L, val right: Column<T>): CompareOperators {
    infix fun EQ(v: Column<T>): L = left.set(right.EQ(v))
    infix fun EQ(v: T): L = left.set(right.EQ(v))
    infix fun EQ(v: Expression<T>): L = left.set(right.EQ(v))

    infix fun GT(v: Column<T>): L = left.set(right.GT(v))
    infix fun GT(v: T): L = left.set(right.GT(v))
    infix fun GT(v: Expression<T>): L = left.set(right.GT(v))

    infix fun LT(v: Column<T>): L = left.set(right.LT(v))
    infix fun LT(v: T): L = left.set(right.LT(v))
    infix fun LT(v: Expression<T>): L = left.set(right.LT(v))

    infix fun GTE(v: Column<T>): L = left.set(right.GTE(v))
    infix fun GTE(v: T): L = left.set(right.GTE(v))
    infix fun GTE(v: Expression<T>): L = left.set(right.GTE(v))

    infix fun LTE(v: Column<T>): L = left.set(right.GTE(v))
    infix fun LTE(v: T): L = left.set(right.GTE(v))
    infix fun LTE(v: Expression<T>): L = left.set(right.GTE(v))

    infix fun NE(v: Column<T>): L = left.set(right.GTE(v))
    infix fun NE(v: T): L = left.set(right.GTE(v))
    infix fun NE(v: Expression<T>): L = left.set(right.GTE(v))

    fun BETWEEN(small: T, big: T) = left.set(right.BETWEEN(small, big))
    fun IN(vararg values: T) = left.set(right.IN(*values))
    fun NOT_IN(vararg values: T) = left.set(right.NOT_IN(*values))
    fun IS_NULL() = left.set(right.IS_NULL())
    fun IS_NOT_NULL() = left.set(right.IS_NOT_NULL())
}

data class LogicPartial<T>(val left: Expression<T>, val right: Expression<*>? = null, val isAnd: Boolean = true): AbstractExpressionContainer<LogicPartial<T>>(), Expression<T> {
    override fun set(exp: Expression<*>, isAnd: Boolean) = LogicPartial(left, exp, isAnd)
    override fun toSQL(ctx: SQLBuilderContext) = right?.let {
        if (isAnd) "${left.toSQL(ctx)} AND ${right.toSQL(ctx)}"
        else "(${left.toSQL(ctx)}) OR (${right.toSQL(ctx)})"
    } ?: throw RuntimeException("AND expression is not finished")

    override fun refer(): LogicPartial<T> = this
}

interface CompareOperators {
    infix fun <T> Column<T>.EQ(v: Column<T>) = ColumnToColumnExpression("=", this, v)
    infix fun <T> Column<T>.GT(v: Column<T>) = ColumnToColumnExpression(">", this, v)
    infix fun <T> Column<T>.LT(v: Column<T>) = ColumnToColumnExpression("<", this, v)
    infix fun <T> Column<T>.GTE(v: Column<T>) = ColumnToColumnExpression(">=", this, v)
    infix fun <T> Column<T>.LTE(v: Column<T>) = ColumnToColumnExpression("<=", this, v)
    infix fun <T> Column<T>.NE(v: Column<T>) = ColumnToColumnExpression("!=", this, v)


    infix fun <T> Column<T>.EQ(v: Expression<T>) = ColumnToExpressionExpression("=", this, v)
    infix fun <T> Column<T>.GT(v: Expression<T>) = ColumnToExpressionExpression(">", this, v)
    infix fun <T> Column<T>.LT(v: Expression<T>) = ColumnToExpressionExpression("<", this, v)
    infix fun <T> Column<T>.GTE(v: Expression<T>) = ColumnToExpressionExpression(">=", this, v)
    infix fun <T> Column<T>.LTE(v: Expression<T>) = ColumnToExpressionExpression("<=", this, v)
    infix fun <T> Column<T>.NE(v: Expression<T>) = ColumnToExpressionExpression("!=", this, v)

    infix fun <T> Column<T>.EQ(v: T) = ColumnToValueExpression("=", this, v)
    infix fun <T> Column<T>.GT(v: T) = ColumnToValueExpression(">", this, v)
    infix fun <T> Column<T>.LT(v: T) = ColumnToValueExpression("<", this, v)
    infix fun <T> Column<T>.GTE(v: T) = ColumnToValueExpression(">=", this, v)
    infix fun <T> Column<T>.LTE(v: T) = ColumnToValueExpression("<=", this, v)
    infix fun <T> Column<T>.NE(v: T) = ColumnToValueExpression("!=", this, v)

    fun <T> Column<T>.BETWEEN(small: T, big: T) = BetweenExpression(this, small, big)
    fun <T> Column<T>.IN(vararg values: T) = MultipleValueExpression("in", this, values.toList())
    fun <T> Column<T>.NOT_IN(vararg values: T) = MultipleValueExpression("not in", this, values.toList())
    fun <T> Column<T>.IS_NULL() = SingleColumnExpression("is null", this)
    fun <T> Column<T>.IS_NOT_NULL() = SingleColumnExpression("is not null", this)

    infix fun Column<String>.LIKE(v: String) = ColumnToValueExpression("like", this, v)
    infix fun Column<String>.NOT_LIKE(v: String) = ColumnToValueExpression("not like", this, v)
}

interface ComputeOperators {
    operator fun <T : Number> Column<T>.plus(v: T) = ColumnToValueExpression("+", this, v)
    operator fun <T : Number> Column<T>.plus(v: Column<T>) = ColumnToColumnExpression("+", this, v)
    operator fun <T : Number> Column<T>.minus(v: T) = ColumnToValueExpression("-", this, v)
    operator fun <T : Number> Column<T>.minus(v: Column<T>) = ColumnToColumnExpression("-", this, v)
    operator fun <T : Number> Column<T>.times(v: T) = ColumnToValueExpression("*", this, v)
    operator fun <T : Number> Column<T>.times(v: Column<T>) = ColumnToColumnExpression("*", this, v)
    operator fun <T : Number> Column<T>.div(v: T) = ColumnToValueExpression("/", this, v)
    operator fun <T : Number> Column<T>.div(v: Column<T>) = ColumnToColumnExpression("/", this, v)
}

interface Operators: CompareOperators, ComputeOperators
