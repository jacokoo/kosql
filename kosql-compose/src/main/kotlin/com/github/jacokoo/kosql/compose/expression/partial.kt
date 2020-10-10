package com.github.jacokoo.kosql.compose.expression

import com.github.jacokoo.kosql.compose.Column

interface Partial<T> {
    fun set(exp: Exp<*>?, isAnd: Boolean = true): T

    fun <T> Exp<T>.and(right: Exp<*>?): Exp<T> = LogicalPartial(this, right, true)
    fun <T> Exp<T>.or(right: Exp<*>?): Exp<T> = LogicalPartial(this, right, false)
}

abstract class AbstractPartial<R: Partial<R>>: Partial<R> {
    abstract fun refer(): R
}

data class LogicalPartial<T>(
    val left: Exp<T>,
    val right: Exp<*>? = null,
    val isAnd: Boolean = true
): AbstractPartial<LogicalPartial<T>>(), Exp<T> {
    override fun refer(): LogicalPartial<T> = this
    override fun set(exp: Exp<*>?, isAnd: Boolean): LogicalPartial<T> = LogicalPartial(left, exp, isAnd)
}

data class PartialExp<L: Partial<L>, T>(val left: L, val right: Column<T>): CompareOperator {
    infix fun EQ(v: Column<T>): L = left.set(right.EQ(v))
    infix fun EQ(v: T?): L = left.set(right.EQ(v))
    infix fun EQ(v: Exp<T>?): L = left.set(right.EQ(v))

    infix fun GT(v: Column<T>): L = left.set(right.GT(v))
    infix fun GT(v: T?): L = left.set(right.GT(v))
    infix fun GT(v: Exp<T>?): L = left.set(right.GT(v))

    infix fun LT(v: Column<T>): L = left.set(right.LT(v))
    infix fun LT(v: T?): L = left.set(right.LT(v))
    infix fun LT(v: Exp<T>?): L = left.set(right.LT(v))

    infix fun GTE(v: Column<T>): L = left.set(right.GTE(v))
    infix fun GTE(v: T?): L = left.set(right.GTE(v))
    infix fun GTE(v: Exp<T>?): L = left.set(right.GTE(v))

    infix fun LTE(v: Column<T>): L = left.set(right.LTE(v))
    infix fun LTE(v: T?): L = left.set(right.LTE(v))
    infix fun LTE(v: Exp<T>?): L = left.set(right.LTE(v))

    infix fun NE(v: Column<T>): L = left.set(right.NE(v))
    infix fun NE(v: T?): L = left.set(right.NE(v))
    infix fun NE(v: Exp<T>?): L = left.set(right.NE(v))

    fun BETWEEN(small: T?, big: T?) = left.set(right.BETWEEN(small, big))
    fun IN(vararg values: T) = left.set(right.IN(*values))
    fun NOT_IN(vararg values: T) = left.set(right.NOT_IN(*values))
    fun IS_NULL() = left.set(right.IS_NULL())
    fun IS_NOT_NULL() = left.set(right.IS_NOT_NULL())
}

interface LogicalOperator {
    infix fun <T> Exp<T>?.AND(other: Exp<out Any>?): LogicalPartial<T>? = this?.let { LogicalPartial(this, other) }
    infix fun <T> Exp<T>?.OR(other: Exp<out Any>?): LogicalPartial<T>? = this?.let { LogicalPartial(this, other, false) }
}

interface StringPartialOperator {
    infix fun <L: Partial<L>> PartialExp<L, String>.LIKE(v: String?): L = left.set(right.LIKE(v))
    infix fun <L: Partial<L>> PartialExp<L, String>.NOT_LIKE(v: String?): L = left.set(right.NOT_LIKE(v))
}