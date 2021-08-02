package com.github.jacokoo.kosql.compose.statement

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.expression.ColumnToColumnExp
import com.github.jacokoo.kosql.compose.expression.ColumnToValueExp
import com.github.jacokoo.kosql.compose.expression.ComputeExp
import com.github.jacokoo.kosql.compose.expression.Exp


data class UpdateData<K, T: Table<K, Entity<K>>> (
    val table: T,
    val joins: List<Join> = listOf(),
    val pairs: Map<Column<*>, Any?> = mapOf(),
    val expression: Exp<*>? = null
): WhereData<UpdateData<K, T>>, JoinData<UpdateData<K, T>> {
    override fun getWhere() = expression
    override fun setWhere(e: Exp<*>?) = copy(expression = e)
    override fun addJoin(join: Join) = copy(joins = joins + join)
    override fun removeJoin(join: Join) = copy(joins = joins - join)
}

interface UpdateStatement<K, T: Table<K, Entity<K>>>: Statement {
    val data: UpdateData<K, T>
}

data class UpdateEnd<K, T: Table<K, Entity<K>>>(override val data: UpdateData<K, T>): UpdateStatement<K, T>

class UpdateCollector {
    private val inner: MutableMap<Column<*>, Any?> = mutableMapOf()
    fun getData(): Map<Column<*>, Any?> = inner

    operator fun <T> set(col: Column<T>, v: T) { inner[col] = v }
    operator fun <T> set(col: Column<T>, v: Column<T>) { inner[col] = v }
    operator fun <T> set(col: Column<T>, v: ColumnToColumnExp<T>) { inner[col] = v }
    operator fun <T> set(col: Column<T>, v: ColumnToValueExp<T>) { inner[col] = v }
    operator fun <T> set(col: Column<T>, v: ComputeExp<T>) { inner[col] = v }
}
data class UpdateWhereDataContainer<K, T: Table<K, Entity<K>>>(override val data: UpdateData<K, T>):
    AbstractWherePartial<UpdateData<K, T>, UpdateWhereDataContainer<K, T>>(), UpdateStatement<K, T> {
    override fun refer(data: UpdateData<K, T>) = UpdateWhereDataContainer(data)
}


interface UpdateWhereOperate<K, T: Table<K, Entity<K>>>: WhereOperate<UpdateData<K, T>, UpdateWhereDataContainer<K, T>> {
    override fun refer(data: UpdateData<K, T>) = UpdateWhereDataContainer(data)
}

data class UpdateWherePart<K, T: Table<K, Entity<K>>>(override val data: UpdateData<K, T>): UpdateWhereOperate<K, T>

data class UpdateJoinDataContainer<K, T: Table<K, Entity<K>>>(override val data: UpdateData<K, T>, override val join: Join):
    AbstractJoinPartial<UpdateData<K, T>, UpdateJoinDataContainer<K, T>>(), SetOperate<K, T>, UpdateStatement<K, T> {
    override fun refer() = this
    override fun refer(data: UpdateData<K, T>, join: Join) = UpdateJoinDataContainer(data, join)
}

data class UpdateJoinOnPart<K, T: Table<K, Entity<K>>>(override val data: UpdateData<K, T>, override val join: Join):
    JoinOnPart<UpdateData<K, T>, UpdateJoinDataContainer<K, T>> {
    override fun refer(data: UpdateData<K, T>, join: Join) = UpdateJoinDataContainer(data, join)
}

interface UpdateJoinOperate<K, T: Table<K, Entity<K>>>: JoinOperate<UpdateData<K, T>, UpdateJoinDataContainer<K, T>, UpdateJoinOnPart<K, T>> {
    override fun referJoinOn(data: UpdateData<K, T>, join: Join) = UpdateJoinOnPart(data, join)
}

interface SetOperate<K, T: Table<K, Entity<K>>>: UpdateStatement<K, T> {
    infix fun SET(block: T.(UpdateCollector) -> Unit) = UpdateCollector().also {
        data.table.block(it)
    }.let {UpdateWherePart(data.copy(pairs = it.getData()))}
}

data class SetPart<K, T: Table<K, Entity<K>>>(override val data: UpdateData<K, T>): SetOperate<K, T>, UpdateJoinOperate<K, T>, UpdateStatement<K, T>

interface Update {
    fun <K, T: Table<K, Entity<K>>> UPDATE(table: T): SetPart<K, T> = SetPart(UpdateData(table))
}
