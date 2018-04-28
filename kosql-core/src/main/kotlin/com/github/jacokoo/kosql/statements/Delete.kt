package com.github.jacokoo.kosql.statements

import com.github.jacokoo.kosql.JoinType
import com.github.jacokoo.kosql.Statement
import com.github.jacokoo.kosql.Table

data class DeleteData(
        val deletes: List<Table<*>> = listOf(),
        val table: Table<*>? = null,
        val joins: List<Join> = listOf(),
        val expression: Expression<*>? = null
)

interface DeleteStatement: Statement {
    val data: DeleteData
}

data class DeleteEnd(override val data: DeleteData): DeleteStatement

data class DeleteWherePart(override val data: DeleteData): DeleteStatement {
    infix fun WHERE(e: Expression<*>): DeleteEnd = DeleteEnd(data.copy(expression = e))
}

data class DeleteOnPart(override val data: DeleteData, private val type: JoinType, private val t: Table<*>): DeleteStatement {
    infix fun ON(e: Expression<*>): DeleteJoinPart = DeleteJoinPart(data.copy(joins = data.joins + Join(t, type, e)))
}

data class DeleteJoinPart(override val data: DeleteData) : DeleteStatement {
    infix fun JOIN(t: Table<*>): DeleteOnPart = DeleteOnPart(data, JoinType.INNER, t)
    infix fun LEFT_JOIN(t: Table<*>): DeleteOnPart = DeleteOnPart(data, JoinType.LEFT, t)
    infix fun RIGHT_JOIN(t: Table<*>): DeleteOnPart = DeleteOnPart(data, JoinType.RIGHT, t)
    infix fun FULL_JOIN(t: Table<*>): DeleteOnPart = DeleteOnPart(data, JoinType.FULL, t)
    infix fun INNER_JOIN(t: Table<*>): DeleteOnPart = DeleteOnPart(data, JoinType.INNER, t)

    infix fun WHERE(e: Expression<*>): DeleteEnd = DeleteEnd(data.copy(expression = e))
}

data class DeleteFromPart(override val data: DeleteData): DeleteStatement {
    infix fun FROM(table: Table<*>): DeleteJoinPart = DeleteJoinPart(data.copy(table = table))
}

interface Delete {
    object DELETE {
        operator fun invoke(vararg ts: Table<*>): DeleteFromPart = DeleteFromPart(DeleteData(deletes = ts.toList()))
        infix fun FROM(t: Table<*>): DeleteWherePart = DeleteWherePart(DeleteData(deletes = listOf(t)))
    }
}