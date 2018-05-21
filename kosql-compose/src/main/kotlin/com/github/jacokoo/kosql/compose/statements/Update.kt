package com.github.jacokoo.kosql.compose.statements

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Statement
import com.github.jacokoo.kosql.compose.Table

data class UpdateData (
    val table: Table<*, Entity<*>>,
    val joins: List<Join> = listOf(),
    val pairs: Map<Column<*>, Any?> = mapOf(),
    val expression: Expression<*>? = null
): WhereData<UpdateData>, JoinData<UpdateData> {
    override fun getWhere() = expression
    override fun setWhere(e: Expression<*>?) = copy(expression = e)
    override fun addJoin(join: Join) = copy(joins = joins + join)
    override fun removeJoin(join: Join) = copy(joins = joins - join)
}

interface UpdateStatement: Statement {
    val data: UpdateData
}

data class UpdateEnd(override val data: UpdateData): UpdateStatement

class SetBlock {
    var data: MutableMap<Column<*>, Any?> = mutableMapOf()
    operator fun <T> set(col: Column<T>, v: T) { data[col] = v }
    operator fun <T> set(col: Column<T>, v: Column<T>) { data[col] = v }
    operator fun <T> set(col: Column<T>, v: ColumnToColumnExpression<T>) { data[col] = v }
    operator fun <T> set(col: Column<T>, v: ColumnToValueExpression<T>) { data[col] = v }
}

data class UpdateWhereDataContainer(override val data: UpdateData): AbstractWhereDataContainer<UpdateData, UpdateWhereDataContainer>() {
    override fun refer(data: UpdateData) = UpdateWhereDataContainer(data)
}

interface UpdateWhereOperate: WhereOperate<UpdateData, UpdateWhereDataContainer> {
    override fun refer(data: UpdateData) = UpdateWhereDataContainer(data)
}

data class UpdateWherePart(override val data: UpdateData): UpdateWhereOperate

data class UpdateJoinDataContainer(override val data: UpdateData, override val join: Join):
    AbstractJoinDataContainer<UpdateData, UpdateJoinDataContainer>(), SetOperate {
    override fun refer() = this
    override fun refer(data: UpdateData, join: Join) = UpdateJoinDataContainer(data, join)
}

data class UpdateJoinOnPart(override val data: UpdateData, override val join: Join): JoinOnPart<UpdateData, UpdateJoinDataContainer> {
    override fun refer(data: UpdateData, join: Join) = UpdateJoinDataContainer(data, join)
}

interface UpdateJoinOperate: JoinOperate<UpdateData, UpdateJoinDataContainer, UpdateJoinOnPart> {
    override fun referJoinOn(data: UpdateData, join: Join) = UpdateJoinOnPart(data, join)
}

interface SetOperate: UpdateStatement {
    infix fun SET(block: (SetBlock) -> Unit) = SetBlock().also(block).let {UpdateWherePart(data.copy(pairs = it.data))}
}

data class SetPart(override val data: UpdateData): SetOperate, UpdateJoinOperate, UpdateStatement

interface Update {
    fun UPDATE(table: Table<*, Entity<*>>): SetPart = SetPart(UpdateData(table))
}
