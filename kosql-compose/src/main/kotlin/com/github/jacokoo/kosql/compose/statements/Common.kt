package com.github.jacokoo.kosql.compose.statements

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.JoinType
import com.github.jacokoo.kosql.compose.Table

interface WhereData<out T> {
    fun getWhere(): Expression<*>?
    fun setWhere(e: Expression<*>?): T
}

interface WhereDataContainer<T: WhereData<T>, R>: ExpressionContainer<R> {
    val data: T
}

abstract class AbstractWhereDataContainer<T: WhereData<T>, R: WhereDataContainer<T, R>>:
    AbstractExpressionContainer<R>(),
    WhereDataContainer<T, R> {

    override fun refer() = refer(data)
    override fun set(exp: Expression<*>?, isAnd: Boolean): R =
        data.getWhere()?.let {
            refer(data.setWhere(if (isAnd) it.and(exp) else it.or(exp)))
        } ?: refer(data.setWhere(exp))

    abstract fun refer(data: T): R
}

interface WhereOperate<T: WhereData<T>, R: AbstractWhereDataContainer<T, R>> {
    val data: T
    fun refer(data: T): R
    infix fun WHERE(e: Expression<*>?): R = refer(data.setWhere(e))
    infix fun <L> WHERE(c: Column<L>) = PartialExpression(refer(data), c)
}

data class Join(val table: Table<*, Entity<*>>, val type: JoinType, val expression: Expression<*>? = null)

interface JoinData<out T> {
    fun addJoin(join: Join): T
    fun removeJoin(join: Join): T
}

interface JoinDataContainer<T: JoinData<T>, R>: ExpressionContainer<R> {
    val data: T
    val join: Join
}

interface JoinOnPart<T: JoinData<T>, R: AbstractJoinDataContainer<T, R>> {
    val data: T
    val join: Join

    abstract fun refer(data: T, join: Join): R

    infix fun ON(e: Expression<*>): R = join.copy(expression = e).let { refer(data.addJoin(it), it) }
    infix fun <T> ON(c: Column<T>) = PartialExpression(refer(data, join), c)
}

abstract class AbstractJoinDataContainer<T: JoinData<T>, R: JoinDataContainer<T, R>>:
    AbstractExpressionContainer<R>(),
    JoinDataContainer<T, R> {

    override fun set(exp: Expression<*>?, isAnd: Boolean): R = join.expression?.let {
        join.copy(expression = if (isAnd) it.and(exp) else it.or(exp)).let {
            refer(data.removeJoin(join).addJoin(it), it)
        }
    } ?: join.copy(expression = exp).let { refer(data.addJoin(it), it) }

    abstract fun refer(data: T, join: Join): R
}

interface JoinOperate<T: JoinData<T>, R: AbstractJoinDataContainer<T, R>, L: JoinOnPart<T, R>> {
    val data: T
    fun referJoinOn(data: T, join: Join): L

    infix fun JOIN(t: Table<*, Entity<*>>) = referJoinOn(data, Join(t, JoinType.INNER))
    infix fun LEFT_JOIN(t: Table<*, Entity<*>>) = referJoinOn(data, Join(t, JoinType.LEFT))
    infix fun RIGHT_JOIN(t: Table<*, Entity<*>>) = referJoinOn(data, Join(t, JoinType.RIGHT))
    infix fun FULL_JOIN(t: Table<*, Entity<*>>) = referJoinOn(data, Join(t, JoinType.FULL))
    infix fun INNER_JOIN(t: Table<*, Entity<*>>) = referJoinOn(data, Join(t, JoinType.INNER))
}
