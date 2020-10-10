package com.github.jacokoo.kosql.compose

import com.github.jacokoo.kosql.compose.expression.*
import com.github.jacokoo.kosql.compose.statement.Delete
import com.github.jacokoo.kosql.compose.statement.Insert
import com.github.jacokoo.kosql.compose.statement.Update
import com.github.jacokoo.kosql.compose.typesafe.Inserts
import com.github.jacokoo.kosql.compose.typesafe.Selects
import java.math.BigDecimal

abstract class Compose: Operator, Selects, Inserts, Update, Delete {
    val TRUE = Exp.TRUE
    val INSERT = Insert.INSERT
    val DELETE = Delete.DELETE

    fun <T: Number> sum(c: Column<T>): Column<BigDecimal> = Sum(c)
    fun <T: Number> avg(c: Column<T>): Column<BigDecimal> = Avg(c)
    fun <T: Number> min(c: Column<T>): Column<T> = Min(c)
    fun <T: Number> max(c: Column<T>): Column<T> = Max(c)
    fun <T> distinct(c: Column<T>): Column<T> = Distinct(c)
    fun count(): Column<Int> = Count<Any>()
    fun <T> count(column: Column<T>) = Count(column)
}