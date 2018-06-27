package com.github.jacokoo.kosql.compose

import com.github.jacokoo.kosql.compose.statements.*
import com.github.jacokoo.kosql.compose.typesafe.Inserts
import com.github.jacokoo.kosql.compose.typesafe.Selects
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

fun createLogger(clz: KClass<*>) = LoggerFactory.getLogger(clz.java.name.substringBefore("\$Companion"))

open class Composer: Operators, Selects, Inserts, Update, Delete {
    val TRUE = Expression.TRUE
    val INSERT = Insert.INSERT
    val DELETE = Delete.DELETE

    fun <T: Number> sum(c: Column<T>): Column<out T> = Sum(c)
    fun <T: Number> avg(c: Column<T>): Column<out T> = Avg(c)
    fun <T: Number> min(c: Column<T>): Column<out T> = Min(c)
    fun <T: Number> max(c: Column<T>): Column<out T> = Max(c)
    fun <T> distinct(c: Column<T>): Column<out T> = Distinct(c)
    fun count(): Column<Int> = Count<Any>()
    fun <T> count(column: Column<T>) = Count(column)
}
