package com.github.jacokoo.kosql.compose.statement

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.expression.AbstractPartial
import com.github.jacokoo.kosql.compose.expression.Exp
import com.github.jacokoo.kosql.compose.expression.Partial
import com.github.jacokoo.kosql.compose.expression.PartialExp

enum class JoinType {
    INNER, LEFT, RIGHT, FULL
}

data class Join(val table: Table<*, Entity<*>>, val type: JoinType, val expression: Exp<*>? = null)

interface JoinData<out T> {
    fun addJoin(join: Join): T
    fun removeJoin(join: Join): T
}

interface JoinPartial<T: JoinData<T>, R>: Partial<R> {
    val data: T
    val join: Join
}

abstract class AbstractJoinPartial<T: JoinData<T>, R: JoinPartial<T, R>>:
    AbstractPartial<R>(),
    JoinPartial<T, R> {

    override fun set(exp: Exp<*>?, isAnd: Boolean): R = join.expression?.let {
        join.copy(expression = if (isAnd) it.and(exp) else it.or(exp)).let {
            refer(data.removeJoin(join).addJoin(it), it)
        }
    } ?: join.copy(expression = exp).let { refer(data.addJoin(it), it) }

    abstract fun refer(data: T, join: Join): R
}

interface JoinOnPart<T: JoinData<T>, R: AbstractJoinPartial<T, R>> {
    val data: T
    val join: Join

    fun refer(data: T, join: Join): R

    infix fun ON(e: Exp<*>): R = join.copy(expression = e).let { refer(data.addJoin(it), it) }
    infix fun <T> ON(c: Column<T>) = PartialExp(refer(data, join), c)
}

interface JoinOperate<T: JoinData<T>, R: AbstractJoinPartial<T, R>, L: JoinOnPart<T, R>> {
    val data: T
    fun referJoinOn(data: T, join: Join): L

    infix fun JOIN(t: Table<*, Entity<*>>) = referJoinOn(data, Join(t, JoinType.INNER))
    infix fun LEFT_JOIN(t: Table<*, Entity<*>>) = referJoinOn(data, Join(t, JoinType.LEFT))
    infix fun RIGHT_JOIN(t: Table<*, Entity<*>>) = referJoinOn(data, Join(t, JoinType.RIGHT))
    infix fun FULL_JOIN(t: Table<*, Entity<*>>) = referJoinOn(data, Join(t, JoinType.FULL))
    infix fun INNER_JOIN(t: Table<*, Entity<*>>) = referJoinOn(data, Join(t, JoinType.INNER))
}