package com.github.jacokoo.ksql.statements

import com.github.jacokoo.ksql.*

data class UpdateData(
        val table: Table<*>,
        val joins: List<Join> = listOf(),
        val pairs: Map<Column<*>, Any?> = mapOf(),
        val expression: Expression<*>? = null
)

interface UpdatePart: Statement {
    val data: UpdateData
}

class SetBlock {
    var data: MutableMap<Column<*>, Any?> = mutableMapOf()

    operator fun <T: Any> set(col: Column<T>, v: T?) {
        data[col] = v
    }

    operator fun <T: Any> set(col: Column<T>, v: Column<T>) {
        data[col] = v
    }

    operator fun <T: Any> set(col: Column<T>, v: ColumnToColumnExpression<T>) {
        data[col] = v
    }

    operator fun <T: Any> set(col: Column<T>, v: ColumnToValueExpression<T>) {
        data[col] = v
    }
}

data class UpdateEnd(override val data: UpdateData): UpdatePart

data class UpdateWherePart(override val data: UpdateData): UpdatePart {
    infix fun WHERE(e: Expression<*>): UpdateEnd = UpdateEnd(data.copy(expression = e))
}

data class UpdateJoinPart(private val data: UpdateData, private val type: JoinType, private val t: Table<*>) {
    infix fun ON(e: Expression<*>): SetPart = SetPart(data.copy(joins = data.joins + Join(t, type, e)))
}

data class SetPart(override val data: UpdateData): UpdatePart {
    infix fun SET(block: (SetBlock) -> Unit): UpdateWherePart {
        val d = SetBlock()
        block(d)
        return UpdateWherePart(data.copy(pairs = d.data))
    }

    infix fun JOIN(t: Table<*>): UpdateJoinPart = UpdateJoinPart(data, JoinType.INNER, t)
    infix fun LEFT_JOIN(t: Table<*>): UpdateJoinPart = UpdateJoinPart(data, JoinType.LEFT, t)
    infix fun RIGHT_JOIN(t: Table<*>): UpdateJoinPart = UpdateJoinPart(data, JoinType.RIGHT, t)
    infix fun FULL_JOIN(t: Table<*>): UpdateJoinPart = UpdateJoinPart(data, JoinType.FULL, t)
    infix fun INNER_JOIN(t: Table<*>): UpdateJoinPart = UpdateJoinPart(data, JoinType.INNER, t)
}

interface Update {

    object UPDATE {
        operator fun invoke(table: Table<*>): SetPart = SetPart(UpdateData(table))
    }

}