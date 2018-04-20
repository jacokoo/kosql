package com.github.jacokoo.kosql

import com.github.jacokoo.kosql.statements.*

enum class Order { ASC, DESC }

enum class JoinType {
    INNER, LEFT, RIGHT, FULL
}

interface SQLPart {
    fun toSQL(ctx: SQLBuilderContext): String
}

interface Statement

open class Query: Operators, Select, Update, Insert, Inserts, Delete {
    val TRUE = com.github.jacokoo.kosql.TRUE
    // val SELECT = Select.SELECT
    val UPDATE = Update.UPDATE
    val INSERT = Insert.INSERT
    val DELETE = Delete.DELETE

    fun <T: Number> sum(c: Column<T>): Column<T> = Sum(c)
    fun <T: Number> avg(c: Column<T>): Column<T> = Avg(c)
    fun <T: Number> min(c: Column<T>): Column<T> = Min(c)
    fun <T: Number> max(c: Column<T>): Column<T> = Max(c)
    fun <T: Any> distinct(c: Column<T>): Column<T> = Distinct(c)
    fun count(): Column<Int> = Count<Any>()
    fun <T: Any> count(column: Column<T>) = Count(column)
}