package com.github.jacokoo.kosql.compose.statements

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.typesafe.Column1
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import com.github.jacokoo.kosql.compose.typesafe.Columns
import com.github.jacokoo.kosql.compose.typesafe.SelectStatement1

data class SelectData (
    val columns: ColumnList,               // select columns
    val table: Table<*, Entity<*>>? = null,                   // select from table
    val joins: List<Join> = listOf(),           // joins
    val expression: Expression<*>? = null,      // where expression
    val groupBy: List<Column<*>> = listOf(),    // group by columns
    val having: Expression<*>? = null,          // having expression
    val orderBy: List<Pair<Column<*>, Order>> = listOf(),   // order by pairs
    val offset: Int? = null,
    val rowCount: Int? = null
): WhereData<SelectData>, JoinData<SelectData> {
    override fun getWhere() = expression
    override fun setWhere(e: Expression<*>?) = copy(expression = e)
    override fun addJoin(join: Join) = copy(joins = joins + join)
    override fun removeJoin(join: Join) = copy(joins = joins - join)
}

interface SelectStatement: Statement {
    val data: SelectData
    fun AS(alias: String): TableLike = TableLike(data, alias, data.columns.columns)
    fun toCount(): SelectStatement1<Int> {
        val count = Count<Int>()
        val col = Column1(count)
        val dd = data.copy(columns = col, orderBy = listOf(), offset = null, rowCount = null)
        return SelectStatement1(Column1(Count<Int>()), dd)
    }
}

data class SelectEnd(override val data: SelectData): SelectStatement

data class LimitPart(override val data: SelectData): SelectStatement {
    infix fun OFFSET(os: Int): SelectEnd = SelectEnd(data.copy(offset = os))
}

interface LimitOperate {
    val data: SelectData
    infix fun LIMIT(count: Int): LimitPart = LimitPart(data.copy(rowCount = count))
}

data class OrderByMorePart(override val data: SelectData): LimitOperate, SelectStatement {
    infix fun AND(p: Pair<Column<*>, Order>): OrderByMorePart = OrderByMorePart(data.copy(orderBy = data.orderBy + p))
}

interface OrderByOperate {
    val data: SelectData
    infix fun ORDER_BY(p: Pair<Column<*>, Order>): OrderByMorePart = OrderByMorePart(data.copy(orderBy = data.orderBy + p))
}

data class AfterGroupByPart(override val data: SelectData): OrderByOperate, LimitOperate, SelectStatement

data class HavingPartial(override val data: SelectData): AbstractExpressionContainer<HavingPartial>(), OrderByOperate, LimitOperate, SelectStatement {
    override fun refer() = this

    override fun set(exp: Expression<*>?, isAnd: Boolean) = data.having?.let {
        HavingPartial(data.copy(having = if (isAnd) it.and(exp) else it.or(exp)))
    } ?: HavingPartial(data.copy(having = exp))
}

data class GroupByMorePart(override val data: SelectData): LimitOperate, OrderByOperate, SelectStatement {
    infix fun AND(column: Column<*>): GroupByMorePart = GroupByMorePart(data.copy(groupBy = data.groupBy + column))
    infix fun HAVING(e: Expression<*>): AfterGroupByPart = AfterGroupByPart(data.copy(having = e))
    infix fun <T> HAVING(c: Column<T>) = PartialExpression(HavingPartial(data), c)
}

interface GroupByOperate {
    val data: SelectData
    infix fun GROUP_BY(column: Column<*>): GroupByMorePart = GroupByMorePart(data.copy(groupBy = data.groupBy + column))
}


data class SelectWhereConainter(override val data: SelectData): AbstractWhereDataContainer<SelectData, SelectWhereConainter>(), SelectStatement {
    override fun refer(data: SelectData) = SelectWhereConainter(data)
}

interface SelectWhereOperate: WhereOperate<SelectData, SelectWhereConainter> {
    override fun refer(data: SelectData) = SelectWhereConainter(data)
}

data class SelectJoinDataContainer(override val data: SelectData, override val join: Join):
    AbstractJoinDataContainer<SelectData, SelectJoinDataContainer>(), SelectStatement,
    SelectWhereOperate, SelectJoinOperate, LimitOperate, OrderByOperate, GroupByOperate {
    override fun refer() = this
    override fun refer(data: SelectData, join: Join) = SelectJoinDataContainer(data, join)
}

data class SelectJoinOnPart(override val data: SelectData, override val join: Join): JoinOnPart<SelectData, SelectJoinDataContainer> {
    override fun refer(data: SelectData, join: Join) = SelectJoinDataContainer(data, join)
}

interface SelectJoinOperate: JoinOperate<SelectData, SelectJoinDataContainer, SelectJoinOnPart> {
    override fun referJoinOn(data: SelectData, join: Join) = SelectJoinOnPart(data, join)
}

data class WhereAndJoinPart(override val data: SelectData): SelectWhereOperate, SelectJoinOperate, LimitOperate, OrderByOperate, GroupByOperate, SelectStatement

data class SelectFromPart(private val data: SelectData): Operators {
    constructor(cs: ColumnList): this(SelectData(cs))
    constructor(vararg cs: Column<*>): this(SelectData(Columns(cs.toList())))

    fun FROM(t: Table<*, Entity<*>>) = WhereAndJoinPart(data.copy(table = t))
}

internal typealias SelectCreator = SelectFromPart.() -> SelectStatement

interface Select {
    fun SELECT(columns: Columns, block: SelectCreator) = SelectEnd(SelectFromPart(columns).block().data)
    fun SELECT(vararg tables: Table<*, Entity<*>>, block: SelectCreator) = SELECT(Columns(tables.fold(listOf()) { acc, i -> acc + i.columns }), block)
}

