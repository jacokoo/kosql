package com.github.jacokoo.kosql.compose.statement

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.expression.Exp

data class DeleteData(
    val deletes: List<Table<*, Entity<*>>> = listOf(),
    val table: Table<*, Entity<*>>? = null,
    val joins: List<Join> = listOf(),
    val expression: Exp<*>? = null
): WhereData<DeleteData>, JoinData<DeleteData> {
    override fun getWhere() = expression
    override fun setWhere(e: Exp<*>?) = copy(expression = e)
    override fun addJoin(join: Join) = copy(joins = joins + join)
    override fun removeJoin(join: Join) = copy(joins = joins - join)
}

interface DeleteStatement: Statement {
    val data: DeleteData
}

data class DeleteEnd(override val data: DeleteData): DeleteStatement

data class DeleteWhereDataContainer(override val data: DeleteData):
    AbstractWherePartial<DeleteData, DeleteWhereDataContainer>(), DeleteStatement {

    override fun refer(data: DeleteData) = DeleteWhereDataContainer(data)
}

interface DeleteWhereOperate: WhereOperate<DeleteData, DeleteWhereDataContainer> {
    override fun refer(data: DeleteData) = DeleteWhereDataContainer(data)
}

data class DeleteWherePart(override val data: DeleteData): DeleteWhereOperate, DeleteStatement

data class DeleteJoinDataContainer(override val data: DeleteData, override val join: Join):
    AbstractJoinPartial<DeleteData, DeleteJoinDataContainer>(), DeleteStatement,
    DeleteWhereOperate, DeleteJoinOperate {

    override fun refer() = this
    override fun refer(data: DeleteData, join: Join) = DeleteJoinDataContainer(data, join)
}

data class DeleteJoinOnPart(override val data: DeleteData, override val join: Join): JoinOnPart<DeleteData, DeleteJoinDataContainer>, DeleteStatement {
    override fun refer(data: DeleteData, join: Join) = DeleteJoinDataContainer(data, join)
}

interface DeleteJoinOperate: JoinOperate<DeleteData, DeleteJoinDataContainer, DeleteJoinOnPart> {
    override fun referJoinOn(data: DeleteData, join: Join) = DeleteJoinOnPart(data, join)
}

data class DeleteJoinPart(override val data: DeleteData): DeleteJoinOperate, DeleteWhereOperate, DeleteStatement

data class DeleteFromPart(override val data: DeleteData): DeleteStatement {
    infix fun FROM(table: Table<*, Entity<*>>): DeleteJoinPart = DeleteJoinPart(data.copy(table = table))
}

interface Delete {
    object DELETE {
        operator fun invoke(vararg ts: Table<*, Entity<*>>): DeleteFromPart = DeleteFromPart(DeleteData(deletes = ts.toList()))
        infix fun FROM(t: Table<*, Entity<*>>): DeleteWherePart = DeleteWherePart(DeleteData(deletes = listOf(t)))
    }
}
