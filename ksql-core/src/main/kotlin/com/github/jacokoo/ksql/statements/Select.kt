package com.github.jacokoo.ksql.statements

import com.github.jacokoo.ksql.*

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
    infix fun ORDER_BY(p: Pair<Column<*>, Order>): OrderByPart = OrderByPart(data.copy(orderBy = data.orderBy + p))
}

interface GroupByOperate {
    val data: QueryData
    infix fun GROUP_BY(column: Column<*>): GroupByPart = GroupByPart(data.copy(groupBy = data.groupBy + column))
}

data class End(override val data: QueryData): QueryPart

data class LimitPart(override val data: QueryData): QueryPart {
    infix fun OFFSET(os: Int): End = End(data.copy(offset = os))
}

data class HavingPart(override val data: QueryData): OrderByOperate, LimitOperate, QueryPart

data class GroupByPart(override val data: QueryData): LimitOperate, OrderByOperate, QueryPart {
    infix fun AND(column: Column<*>): GroupByPart = GroupByPart(data.copy(groupBy = data.groupBy + column))
    infix fun HAVING(e: Expression<*>): HavingPart = HavingPart(data.copy(having = e))
}

data class OrderByPart(override val data: QueryData): LimitOperate, QueryPart {
    infix fun AND(p: Pair<Column<*>, Order>): OrderByPart = OrderByPart(data.copy(orderBy = data.orderBy + p))
}

data class WherePart(override val data: QueryData): LimitOperate, OrderByOperate, GroupByOperate, QueryPart

data class JoinPart(private val data: QueryData, private val type: JoinType, private val t: Table<*>) {
    infix fun ON(e: Expression<*>): FromPart = FromPart(data.copy(joins = data.joins + Join(t, type, e)))
}

data class FromPart(override val data: QueryData): LimitOperate, OrderByOperate, GroupByOperate, QueryPart {
    infix fun WHERE(e: Expression<*>): WherePart = WherePart(data.copy(expression = e))
    infix fun JOIN(t: Table<*>): JoinPart = JoinPart(data, JoinType.INNER, t)
    infix fun LEFT_JOIN(t: Table<*>): JoinPart = JoinPart(data, JoinType.LEFT, t)
    infix fun RIGHT_JOIN(t: Table<*>): JoinPart = JoinPart(data, JoinType.RIGHT, t)
    infix fun FULL_JOIN(t: Table<*>): JoinPart = JoinPart(data, JoinType.FULL, t)
    infix fun INNER_JOIN(t: Table<*>): JoinPart = JoinPart(data, JoinType.INNER, t)
}

data class SelectPart(private val data: QueryData) {
    infix fun FROM(t: Table<*>): FromPart = FromPart(data.copy(table = t))
}

interface Select {
    object SELECT {
        operator fun invoke(vararg columns: Column<out Any>): SelectPart = SelectPart(QueryData(columns = columns.toList()))
        operator fun invoke(table: Table<*>): FromPart = FromPart(QueryData(columns = table().toList(), table = table))
        operator fun invoke(): FromPart = FromPart(QueryData(columns = listOf(Query.count())))
    }
}
