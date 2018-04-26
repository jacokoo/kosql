package com.github.jacokoo.kosql.statements

import com.github.jacokoo.kosql.*

data class Join(val table: Table<*>, val type: JoinType, val expression: Expression<*>)

data class QueryData(
        val columns: ColumnList,               // select columns
        val table: Table<*>? = null,                   // select from table
        val joins: List<Join> = listOf(),           // joins
        val expression: Expression<*>? = null,      // where expression
        val groupBy: List<Column<*>> = listOf(),    // group by columns
        val having: Expression<*>? = null,          // having expression
        val orderBy: List<Pair<Column<*>, Order>> = listOf(),   // order by pairs
        val offset: Int? = null,
        val rowCount: Int? = null
)

interface QueryPart: Statement {
    val data: QueryData
    fun AS(alias: String): TableLike = TableLike(data, alias, data.columns.columns)
    fun toCount(): SelectStatement1<Int> {
        val count = Count<Int>()
        val col = Column1(count)
        val dd = data.copy(columns = col, orderBy = listOf(), offset = null, rowCount = null)
        return SelectStatement1(Column1(Count<Int>()), dd)
    }
}

interface LimitOperate {
    val data: QueryData
    infix fun LIMIT(count: Int): LimitPart = LimitPart(data.copy(rowCount = count))
}

interface OrderByOperate {
    val data: QueryData
    infix fun ORDER_BY(p: Pair<Column<*>, Order>): OrderByMorePart = OrderByMorePart(data.copy(orderBy = data.orderBy + p))
}

interface GroupByOperate {
    val data: QueryData
    infix fun GROUP_BY(column: Column<*>): GroupByMorePart = GroupByMorePart(data.copy(groupBy = data.groupBy + column))
}

data class SelectEnd(override val data: QueryData): QueryPart

data class LimitPart(override val data: QueryData): QueryPart {
    infix fun OFFSET(os: Int): SelectEnd = SelectEnd(data.copy(offset = os))
}

data class AfterGroupByPart(override val data: QueryData): OrderByOperate, LimitOperate, QueryPart

data class GroupByMorePart(override val data: QueryData): LimitOperate, OrderByOperate, QueryPart {
    infix fun AND(column: Column<*>): GroupByMorePart = GroupByMorePart(data.copy(groupBy = data.groupBy + column))
    infix fun HAVING(e: Expression<*>): AfterGroupByPart = AfterGroupByPart(data.copy(having = e))
}

data class OrderByMorePart(override val data: QueryData): LimitOperate, QueryPart {
    infix fun AND(p: Pair<Column<*>, Order>): OrderByMorePart = OrderByMorePart(data.copy(orderBy = data.orderBy + p))
}

data class AfterWherePart(override val data: QueryData): LimitOperate, OrderByOperate, GroupByOperate, QueryPart

data class JoinOnPart(private val data: QueryData, private val type: JoinType, private val t: Table<*>) {
    infix fun ON(e: Expression<*>): WhereAndJoinPart = WhereAndJoinPart(data.copy(joins = data.joins + Join(t, type, e)))
}

data class WhereAndJoinPart(override val data: QueryData): LimitOperate, OrderByOperate, GroupByOperate, QueryPart {
    infix fun WHERE(e: Expression<*>): AfterWherePart = AfterWherePart(data.copy(expression = e))
    infix fun JOIN(t: Table<*>): JoinOnPart = JoinOnPart(data, JoinType.INNER, t)
    infix fun LEFT_JOIN(t: Table<*>): JoinOnPart = JoinOnPart(data, JoinType.LEFT, t)
    infix fun RIGHT_JOIN(t: Table<*>): JoinOnPart = JoinOnPart(data, JoinType.RIGHT, t)
    infix fun FULL_JOIN(t: Table<*>): JoinOnPart = JoinOnPart(data, JoinType.FULL, t)
    infix fun INNER_JOIN(t: Table<*>): JoinOnPart = JoinOnPart(data, JoinType.INNER, t)
}

data class SelectFromPart(private val data: QueryData): Operators {
    constructor(cs: ColumnList): this(QueryData(cs))
    constructor(vararg cs: Column<*>): this(QueryData(Columns(cs.toList())))

    fun FROM(t: Table<*>): WhereAndJoinPart = WhereAndJoinPart(data.copy(table = t))
}

data class SelectStatement(override val data: QueryData): QueryPart

internal typealias SelectCreator = SelectFromPart.() -> QueryPart

interface Select {
    object SELECT {
        // operator fun invoke(vararg columns: Column<out Any>): SelectFromPart = SelectFromPart(QueryData(columns.toList()))
        // operator fun invoke(table: Table<*>): WhereAndJoinPart = WhereAndJoinPart(QueryData(table().toList(), table))

        operator fun invoke(columns: Columns, block: SelectCreator) = SelectStatement(SelectFromPart(columns).block().data)
        operator fun invoke(vararg tables: Table<*>, block: SelectCreator) = invoke(Columns(tables.fold(listOf()) {acc, i -> acc + i.columns}), block)
    }
}

