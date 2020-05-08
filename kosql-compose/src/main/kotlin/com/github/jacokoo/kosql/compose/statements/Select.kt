package com.github.jacokoo.kosql.compose.statements

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.typesafe.Column1
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import com.github.jacokoo.kosql.compose.typesafe.Columns
import com.github.jacokoo.kosql.compose.typesafe.SelectStatement1

data class SelectData<T: ColumnList> (
    val columns: T,               // select columns
    val table: Table<*, Entity<*>>? = null,                   // select from table
    val joins: List<Join> = listOf(),           // joins
    val expression: Expression<*>? = null,      // where expression
    val groupBy: List<Column<*>> = listOf(),    // group by columns
    val having: Expression<*>? = null,          // having expression
    val orderBy: List<Pair<Column<*>, Order>> = listOf(),   // order by pairs
    val offset: Int? = null,
    val rowCount: Int? = null
): WhereData<SelectData<T>>, JoinData<SelectData<T>> {
    override fun getWhere() = expression
    override fun setWhere(e: Expression<*>?) = copy(expression = e)
    override fun addJoin(join: Join) = copy(joins = joins + join)
    override fun removeJoin(join: Join) = copy(joins = joins - join)
}

interface SelectStatement<T: ColumnList>: Statement {
    val data: SelectData<T>
    fun AS(alias: String): TableLike<T> = TableLike(data, alias, data.columns.columns)
    fun toCount(): SelectEnd<Column1<Int>> {
        val count = Count(data.columns.columns[0])
        val col = Column1(count)
        val dd = SelectData(col, data.table, data.joins, data.expression, data.groupBy, data.having)
        return SelectEnd(dd)
    }
}

data class SelectEnd<T: ColumnList>(override val data: SelectData<T>): SelectStatement<T>

data class LimitPart<T: ColumnList>(override val data: SelectData<T>): SelectStatement<T> {
    infix fun OFFSET(os: Int): SelectEnd<T> = SelectEnd(data.copy(offset = os))
}

interface LimitOperate<T: ColumnList> {
    val data: SelectData<T>
    infix fun LIMIT(count: Int): LimitPart<T> = LimitPart(data.copy(rowCount = count))
}

data class OrderByMorePart<T: ColumnList>(override val data: SelectData<T>): LimitOperate<T>, SelectStatement<T> {
    infix fun AND(p: Pair<Column<*>, Order>): OrderByMorePart<T> = OrderByMorePart(data.copy(orderBy = data.orderBy + p))
}

interface OrderByOperate<T: ColumnList> {
    val data: SelectData<T>
    infix fun ORDER_BY(p: Pair<Column<*>, Order>): OrderByMorePart<T> = OrderByMorePart(data.copy(orderBy = data.orderBy + p))
}

data class AfterGroupByPart<T: ColumnList>(override val data: SelectData<T>): OrderByOperate<T>, LimitOperate<T>, SelectStatement<T>

data class HavingPartial<T: ColumnList>(override val data: SelectData<T>): AbstractExpressionContainer<HavingPartial<T>>(), OrderByOperate<T>, LimitOperate<T>, SelectStatement<T> {
    override fun refer() = this

    override fun set(exp: Expression<*>?, isAnd: Boolean) = data.having?.let {
        HavingPartial(data.copy(having = if (isAnd) it.and(exp) else it.or(exp)))
    } ?: HavingPartial(data.copy(having = exp))
}

data class GroupByMorePart<T: ColumnList>(override val data: SelectData<T>): LimitOperate<T>, OrderByOperate<T>, SelectStatement<T> {
    infix fun AND(column: Column<*>): GroupByMorePart<T> = GroupByMorePart(data.copy(groupBy = data.groupBy + column))
    infix fun HAVING(e: Expression<*>): AfterGroupByPart<T> = AfterGroupByPart(data.copy(having = e))
    infix fun <T> HAVING(c: Column<T>) = PartialExpression(HavingPartial(data), c)
}

interface GroupByOperate<T: ColumnList> {
    val data: SelectData<T>
    infix fun GROUP_BY(column: Column<*>): GroupByMorePart<T> = GroupByMorePart(data.copy(groupBy = data.groupBy + column))
}

data class SelectWhereContainer<T: ColumnList>(override val data: SelectData<T>):
    AbstractWhereDataContainer<SelectData<T>, SelectWhereContainer<T>>(), SelectStatement<T>,
    GroupByOperate<T>, OrderByOperate<T>, LimitOperate<T> {
    override fun refer(data: SelectData<T>) = SelectWhereContainer(data)
}

interface SelectWhereOperate<T: ColumnList>: WhereOperate<SelectData<T>, SelectWhereContainer<T>> {
    override fun refer(data: SelectData<T>) = SelectWhereContainer(data)
}

data class SelectJoinDataContainer<T: ColumnList>(override val data: SelectData<T>, override val join: Join):
    AbstractJoinDataContainer<SelectData<T>, SelectJoinDataContainer<T>>(), SelectStatement<T>,
    SelectWhereOperate<T>, SelectJoinOperate<T>, LimitOperate<T>, OrderByOperate<T>, GroupByOperate<T> {
    override fun refer() = this
    override fun refer(data: SelectData<T>, join: Join) = SelectJoinDataContainer(data, join)
}

data class SelectJoinOnPart<T: ColumnList>(override val data: SelectData<T>, override val join: Join): JoinOnPart<SelectData<T>, SelectJoinDataContainer<T>> {
    override fun refer(data: SelectData<T>, join: Join) = SelectJoinDataContainer(data, join)
}

interface SelectJoinOperate<T: ColumnList>: JoinOperate<SelectData<T>, SelectJoinDataContainer<T>, SelectJoinOnPart<T>> {
    override fun referJoinOn(data: SelectData<T>, join: Join) = SelectJoinOnPart(data, join)
}

data class WhereAndJoinPart<T: ColumnList>(override val data: SelectData<T>): SelectWhereOperate<T>, SelectJoinOperate<T>, LimitOperate<T>, OrderByOperate<T>, GroupByOperate<T>, SelectStatement<T>

interface SelectFromOperate<T: ColumnList> {
    val data: SelectData<T>
    infix fun FROM(t: Table<*, Entity<*>>) = WhereAndJoinPart(data.copy(table = t))
}

data class SelectFromPart<T: ColumnList>(override val data: SelectData<T>): SelectFromOperate<T>

interface Select {
    fun SELECT(columns: Columns) = SelectFromPart(SelectData(columns))
    fun SELECT(vararg tables: Table<*, Entity<*>>) = SELECT(Columns(tables.fold(listOf()) { acc, i -> acc + i.columns }))
}

