package com.github.jacokoo.kosql.compose

import com.github.jacokoo.kosql.compose.statements.*
import com.github.jacokoo.kosql.compose.typesafe.Inserts
import com.github.jacokoo.kosql.compose.typesafe.Selects
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import kotlin.reflect.KClass

fun createLogger(clz: KClass<*>) = LoggerFactory.getLogger(clz.java.name.substringBefore("\$Companion"))

open class Composer: Operators, Selects, Inserts, Update, Delete {
    val TRUE = Expression.TRUE
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
