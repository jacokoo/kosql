package com.github.jacokoo.kosql

interface Operators {
    infix fun <T> Expression<T>.AND(other: Expression<out Any>?) = other?.let { ComposeExpression<T>("AND", this, it, false) } ?: this
    infix fun <T> Expression<T>.OR(other: Expression<out Any>?) = other?.let { ComposeExpression<T>("OR", this, it, true) } ?: this


    infix fun <T : Any> Column<T>.EQ(v: Column<T>) = ColumnToColumnExpression("=", this, v)
    infix fun <T : Any> Column<T>.GT(v: Column<T>) = ColumnToColumnExpression(">", this, v)
    infix fun <T : Any> Column<T>.LT(v: Column<T>) = ColumnToColumnExpression("<", this, v)
    infix fun <T : Any> Column<T>.GTE(v: Column<T>) = ColumnToColumnExpression(">=", this, v)
    infix fun <T : Any> Column<T>.LTE(v: Column<T>) = ColumnToColumnExpression("<=", this, v)
    infix fun <T : Any> Column<T>.NE(v: Column<T>) = ColumnToColumnExpression("!=", this, v)


    infix fun <T : Any> Column<T>.EQ(v: Expression<T>) = ColumnToExpressionExpression("=", this, v)
    infix fun <T : Any> Column<T>.GT(v: Expression<T>) = ColumnToExpressionExpression(">", this, v)
    infix fun <T : Any> Column<T>.LT(v: Expression<T>) = ColumnToExpressionExpression("<", this, v)
    infix fun <T : Any> Column<T>.GTE(v: Expression<T>) = ColumnToExpressionExpression(">=", this, v)
    infix fun <T : Any> Column<T>.LTE(v: Expression<T>) = ColumnToExpressionExpression("<=", this, v)
    infix fun <T : Any> Column<T>.NE(v: Expression<T>) = ColumnToExpressionExpression("!=", this, v)

    infix fun <T : Any> Expression<T>.EQ(v: Column<T>) = ColumnToExpressionExpression("=", v, this)
    infix fun <T : Any> Expression<T>.GT(v: Column<T>) = ColumnToExpressionExpression(">", v, this)
    infix fun <T : Any> Expression<T>.LT(v: Column<T>) = ColumnToExpressionExpression("<", v, this)
    infix fun <T : Any> Expression<T>.GTE(v: Column<T>) = ColumnToExpressionExpression(">=", v, this)
    infix fun <T : Any> Expression<T>.LTE(v: Column<T>) = ColumnToExpressionExpression("<=", v, this)
    infix fun <T : Any> Expression<T>.NE(v: Column<T>) = ColumnToExpressionExpression("!=", v, this)


    infix fun <T : Any> Column<T>.EQ(v: T) = ColumnToValueExpression("=", this, v)
    infix fun <T : Any> Column<T>.GT(v: T) = ColumnToValueExpression(">", this, v)
    infix fun <T : Any> Column<T>.LT(v: T) = ColumnToValueExpression("<", this, v)
    infix fun <T : Any> Column<T>.GTE(v: T) = ColumnToValueExpression(">=", this, v)
    infix fun <T : Any> Column<T>.LTE(v: T) = ColumnToValueExpression("<=", this, v)
    infix fun <T : Any> Column<T>.NE(v: T) = ColumnToValueExpression("!=", this, v)

    infix fun <T : Any> T.EQ(v: Column<T>) = ColumnToValueExpression("=", v, this)
    infix fun <T : Any> T.GT(v: Column<T>) = ColumnToValueExpression(">", v, this)
    infix fun <T : Any> T.LT(v: Column<T>) = ColumnToValueExpression("<", v, this)
    infix fun <T : Any> T.GTE(v: Column<T>) = ColumnToValueExpression(">=", v, this)
    infix fun <T : Any> T.LTE(v: Column<T>) = ColumnToValueExpression("<=", v, this)
    infix fun <T : Any> T.NE(v: Column<T>) = ColumnToValueExpression("!=", v, this)


    fun <T : Any> Column<T>.BETWEEN(small: T, big: T) = BetweenExpression(this, small, big)
    fun <T : Any> Column<T>.IN(vararg values: T) = MultipleValueExpression("in", this, values.toList())
    fun <T : Any> Column<T>.NOT_IN(vararg values: T) = MultipleValueExpression("not in", this, values.toList())
    fun <T : Any> Column<T>.IS_NULL() = SingleColumnExpression("is null", this)
    fun <T : Any> Column<T>.IS_NOT_NULL() = SingleColumnExpression("is not null", this)

    infix fun Column<String>.LIKE(v: String) = ColumnToValueExpression("like", this, v)
    infix fun Column<String>.NOT_LIKE(v: String) = ColumnToValueExpression("not like", this, v)

    operator fun <T : Number> Column<T>.plus(v: T) = ColumnToValueExpression("+", this, v)
    operator fun <T : Number> Column<T>.plus(v: Column<T>) = ColumnToColumnExpression("+", this, v)
    operator fun <T : Number> Column<T>.minus(v: T) = ColumnToValueExpression("-", this, v)
    operator fun <T : Number> Column<T>.minus(v: Column<T>) = ColumnToColumnExpression("-", this, v)
    operator fun <T : Number> Column<T>.times(v: T) = ColumnToValueExpression("*", this, v)
    operator fun <T : Number> Column<T>.times(v: Column<T>) = ColumnToColumnExpression("*", this, v)
    operator fun <T : Number> Column<T>.div(v: T) = ColumnToValueExpression("/", this, v)
    operator fun <T : Number> Column<T>.div(v: Column<T>) = ColumnToColumnExpression("/", this, v)
}