package com.github.jacokoo.kosql.statements

import com.github.jacokoo.kosql.*
import com.github.jacokoo.kosql.mapping.QueryResult1
import com.github.jacokoo.kosql.mapping.QueryResults
import com.github.jacokoo.kosql.mapping.to1

data class Join(val table: Table<*>, val type: JoinType, val expression: Expression<*>)

data class QueryData(
        val columns: List<Column<*>>,               // select columns
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
    fun AS(alias: String): TableLike = TableLike(data, alias, data.columns)
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
    fun FROM(t: Table<*>): WhereAndJoinPart = WhereAndJoinPart(data.copy(table = t))
}

interface Select {
    fun SELECT(columns: List<Column<*>>, block: SelectFromPart.() -> QueryPart): QueryResults
    fun <T1: Any> SELECT(c1: Column<T1>, block: SelectFromPart.() -> QueryPart): QueryResult1<T1> = SELECT(listOf(c1), block).to1()
}