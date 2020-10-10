package com.github.jacokoo.kosql.compose.statement

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.expression.AbstractPartial
import com.github.jacokoo.kosql.compose.expression.Exp
import com.github.jacokoo.kosql.compose.expression.Partial
import com.github.jacokoo.kosql.compose.expression.PartialExp

interface WhereData<out T> {
    fun getWhere(): Exp<*>?
    fun setWhere(e: Exp<*>?): T
}

interface WherePartial<T: WhereData<T>, R>: Partial<R> {
    val data: T
}

abstract class AbstractWherePartial<T: WhereData<T>, R: WherePartial<T, R>>: AbstractPartial<R>(), WherePartial<T, R> {
    override fun refer() = refer(data)

    override fun set(exp: Exp<*>?, isAnd: Boolean): R =
        data.getWhere()?.let {
            refer(data.setWhere(if (isAnd) it.and(exp) else it.or(exp)))
        } ?: refer(data.setWhere(exp))

    abstract fun refer(data: T): R
}

interface WhereOperate<T: WhereData<T>, R: AbstractWherePartial<T, R>> {
    val data: T
    fun refer(data: T): R
    infix fun WHERE(e: Exp<*>?): R = refer(data.setWhere(e))
    infix fun <L> WHERE(c: Column<L>) = PartialExp(refer(data), c)
}
