package com.github.jacokoo.kosql.compose.expression

import com.github.jacokoo.kosql.compose.Column

interface CompareOperator {
    infix fun <T> Column<T>.EQ(v: Column<T>): Exp<T> = ColumnToColumnExp("=", this, v)
    infix fun <T> Column<T>.GT(v: Column<T>): Exp<T> = ColumnToColumnExp(">", this, v)
    infix fun <T> Column<T>.LT(v: Column<T>): Exp<T> = ColumnToColumnExp("<", this, v)
    infix fun <T> Column<T>.GTE(v: Column<T>): Exp<T> = ColumnToColumnExp(">=", this, v)
    infix fun <T> Column<T>.LTE(v: Column<T>): Exp<T> = ColumnToColumnExp("<=", this, v)
    infix fun <T> Column<T>.NE(v: Column<T>): Exp<T> = ColumnToColumnExp("!=", this, v)

    infix fun <T> Column<T>.EQ(v: Exp<T>?): Exp<T>? = v?.let { ColumnToExpExp("=", this, v) }
    infix fun <T> Column<T>.GT(v: Exp<T>?): Exp<T>? = v?.let { ColumnToExpExp(">", this, v) }
    infix fun <T> Column<T>.LT(v: Exp<T>?): Exp<T>? = v?.let { ColumnToExpExp("<", this, v) }
    infix fun <T> Column<T>.GTE(v: Exp<T>?): Exp<T>? = v?.let { ColumnToExpExp(">=", this, v) }
    infix fun <T> Column<T>.LTE(v: Exp<T>?): Exp<T>? = v?.let { ColumnToExpExp("<=", this, v) }
    infix fun <T> Column<T>.NE(v: Exp<T>?): Exp<T>? = v?.let { ColumnToExpExp("!=", this, v) }

    infix fun <T> Column<T>.EQ(v: T?): Exp<T>? = v?.let { ColumnToValueExp("=", this, v) }
    infix fun <T> Column<T>.GT(v: T?): Exp<T>? = v?.let { ColumnToValueExp(">", this, v) }
    infix fun <T> Column<T>.LT(v: T?): Exp<T>? = v?.let { ColumnToValueExp("<", this, v) }
    infix fun <T> Column<T>.GTE(v: T?): Exp<T>? = v?.let { ColumnToValueExp(">=", this, v) }
    infix fun <T> Column<T>.LTE(v: T?): Exp<T>? = v?.let { ColumnToValueExp("<=", this, v) }
    infix fun <T> Column<T>.NE(v: T?): Exp<T>? = v?.let { ColumnToValueExp("!=", this, v) }

    fun <T> Column<T>.BETWEEN(small: T?, big: T?): Exp<T>? = when {
        big == null -> GTE(small)
        small == null -> LTE(big)
        else -> BetweenExp(this, small, big)
    }

    infix fun <T> Column<T>.IN(values: List<T>): Exp<T>? =
        if (values.isEmpty()) null
        else MultiValueExp("in", this, values)

    infix fun <T> Column<T>.NOT_IN(values: List<T>): Exp<T>? =
        if (values.isEmpty()) null
        else MultiValueExp("not in", this, values.toList())

    fun <T> Column<T>.IS_NULL(): Exp<T>? = SingleColumnExp("is null", this)
    fun <T> Column<T>.IS_NOT_NULL(): Exp<T>? = SingleColumnExp("is not null", this)

    infix fun Column<String>.LIKE(v: String?): Exp<String>? = v?.let { ColumnToValueExp("like", this, v) }
    infix fun Column<String>.NOT_LIKE(v: String?): Exp<String>? = v?.let { ColumnToValueExp("not like", this, v) }

    fun String?.LEFT() = this?.let { "$it%" }
    fun String?.RIGHT() = this?.let { "%$it" }
    fun String?.ALL() = this?.let { "%$it%" }
}

interface ComputeOperator {
    operator fun <T : Number> Column<T>.plus(v: T) = ColumnToValueExp("+", this, v)
    operator fun <T : Number> Column<T>.minus(v: T) = ColumnToValueExp("-", this, v)
    operator fun <T : Number> Column<T>.times(v: T) = ColumnToValueExp("*", this, v)
    operator fun <T : Number> Column<T>.div(v: T) = ColumnToValueExp("/", this, v)

    operator fun <T : Number> Column<T>.plus(v: Column<T>) = ComputeExp(ColumnToColumnExp("+", this, v))
    operator fun <T : Number> Column<T>.minus(v: Column<T>) = ComputeExp(ColumnToColumnExp("-", this, v))
    operator fun <T : Number> Column<T>.times(v: Column<T>) = ComputeExp(ColumnToColumnExp("*", this, v))
    operator fun <T : Number> Column<T>.div(v: Column<T>) = ComputeExp(ColumnToColumnExp("/", this, v))

    operator fun <T: Number> ComputeExp<T>.plus(v: Column<T>) = ComputeExp(ExpToColumnExp("+", this.exp, v))
    operator fun <T: Number> ComputeExp<T>.minus(v: Column<T>) = ComputeExp(ExpToColumnExp("-", this.exp, v))
    operator fun <T: Number> ComputeExp<T>.times(v: Column<T>) = ComputeExp(ExpToColumnExp("*", this.exp, v))
    operator fun <T: Number> ComputeExp<T>.div(v: Column<T>) = ComputeExp(ExpToColumnExp("/", this.exp, v))
}

interface Operator: CompareOperator, ComputeOperator, LogicalOperator, StringPartialOperator
