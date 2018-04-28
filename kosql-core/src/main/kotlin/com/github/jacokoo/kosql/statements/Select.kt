package com.github.jacokoo.kosql.statements

import com.github.jacokoo.kosql.*
import com.github.jacokoo.kosql.typesafe.Column1
import com.github.jacokoo.kosql.typesafe.ColumnList
import com.github.jacokoo.kosql.typesafe.Columns
import com.github.jacokoo.kosql.typesafe.SelectStatement1

data class Join(val table: Table<*>, val type: JoinType, val expression: Expression<*>)

data class SelectData(
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

interface LimitOperate {
    val data: SelectData
    infix fun LIMIT(count: Int): LimitPart = LimitPart(data.copy(rowCount = count))
}

interface OrderByOperate {
    val data: SelectData
    infix fun ORDER_BY(p: Pair<Column<*>, Order>): OrderByMorePart = OrderByMorePart(data.copy(orderBy = data.orderBy + p))
}

interface GroupByOperate {
    val data: SelectData
    infix fun GROUP_BY(column: Column<*>): GroupByMorePart = GroupByMorePart(data.copy(groupBy = data.groupBy + column))
}

interface JoinOperate {
    val data: SelectData
    infix fun JOIN(t: Table<*>) = JoinOnPart(data, JoinType.INNER, t)
    infix fun LEFT_JOIN(t: Table<*>) = JoinOnPart(data, JoinType.LEFT, t)
    infix fun RIGHT_JOIN(t: Table<*>) = JoinOnPart(data, JoinType.RIGHT, t)
    infix fun FULL_JOIN(t: Table<*>) = JoinOnPart(data, JoinType.FULL, t)
    infix fun INNER_JOIN(t: Table<*>) = JoinOnPart(data, JoinType.INNER, t)
}

interface WhereOperate {
    val data: SelectData
    infix fun WHERE(e: Expression<*>): AfterWherePart = AfterWherePart(data.copy(expression = e))
    infix fun <T> WHERE(c: Column<T>) = PartialExpression(WherePartial(data), c)
}

data class SelectEnd(override val data: SelectData): SelectStatement

data class LimitPart(override val data: SelectData): SelectStatement {
    infix fun OFFSET(os: Int): SelectEnd = SelectEnd(data.copy(offset = os))
}

data class AfterGroupByPart(override val data: SelectData): OrderByOperate, LimitOperate, SelectStatement

data class HavingPartial(override val data: SelectData): ExpressionContainer<HavingPartial>, OrderByOperate, LimitOperate, SelectStatement {
    override fun set(exp: Expression<*>) = data.having?.let {
        HavingPartial(data.copy(having = it.and(exp)))
    } ?: HavingPartial(data.copy(having = exp))

    infix fun <T> AND(column: Column<T>) = PartialExpression(this, column)
    infix fun <T> AND(e: Expression<T>) = HavingPartial(data.copy(having = data.having!!.and(e)))
    infix fun <T> OR(e: Expression<T>) = HavingPartial(data.copy(having = data.having!!.or(e)))
}

data class GroupByMorePart(override val data: SelectData): LimitOperate, OrderByOperate, SelectStatement {
    infix fun AND(column: Column<*>): GroupByMorePart = GroupByMorePart(data.copy(groupBy = data.groupBy + column))
    infix fun HAVING(e: Expression<*>): AfterGroupByPart = AfterGroupByPart(data.copy(having = e))
    infix fun <T> HAVING(c: Column<T>) = PartialExpression(HavingPartial(data), c)
}

data class OrderByMorePart(override val data: SelectData): LimitOperate, SelectStatement {
    infix fun AND(p: Pair<Column<*>, Order>): OrderByMorePart = OrderByMorePart(data.copy(orderBy = data.orderBy + p))
}

data class AfterWherePart(override val data: SelectData): LimitOperate, OrderByOperate, GroupByOperate, SelectStatement

data class JoinOnPartial(
        override val data: SelectData, private val type: JoinType, private val t: Table<*>, private val join: Join? = null
): ExpressionContainer<JoinOnPartial>, WhereOperate, JoinOperate, LimitOperate, OrderByOperate, GroupByOperate, SelectStatement {
    override fun set(exp: Expression<*>) = join?.let { jj ->
        jj.copy(expression = jj.expression.and(exp)).let { this.copy(join = it, data = data.copy(joins = data.joins - jj + it)) }
    } ?: Join(t, type, exp).let { this.copy(join = it, data = data.copy(joins = data.joins + it)) }

    infix fun <T> AND(column: Column<T>) = PartialExpression(this, column)
    infix fun <T> AND(e: Expression<T>) =
            join!!.copy(expression = join.expression.and(e)).let { this.copy(join = it, data = data.copy(joins = data.joins - join + it)) }
    infix fun <T> OR(e: Expression<T>) =
        join!!.copy(expression = join.expression.or(e)).let { this.copy(join = it, data = data.copy(joins = data.joins - join + it)) }
}

data class JoinOnPart(private val data: SelectData, private val type: JoinType, private val t: Table<*>) {
    infix fun ON(e: Expression<*>) = WhereAndJoinPart(data.copy(joins = data.joins + Join(t, type, e)))
    infix fun <T> ON(c: Column<T>) = PartialExpression(JoinOnPartial(data, type, t), c)
}

data class WherePartial(override val data: SelectData): ExpressionContainer<WherePartial>, SelectStatement, LimitOperate, OrderByOperate, GroupByOperate {
    override fun set(exp: Expression<*>) = data.expression?.let {
        WherePartial(data.copy(expression = it.and(exp)))
    } ?: WherePartial(data.copy(expression = exp))

    infix fun <T> AND(column: Column<T>) = PartialExpression(this, column)
    infix fun <T> AND(e: Expression<T>) = WherePartial(data.copy(expression = data.expression!!.and(e)))
    infix fun <T> OR(e: Expression<T>) = WherePartial(data.copy(expression = data.expression!!.or(e)))
}

data class WhereAndJoinPart(override val data: SelectData): WhereOperate, JoinOperate, LimitOperate, OrderByOperate, GroupByOperate, SelectStatement

data class SelectFromPart(private val data: SelectData): Operators {
    constructor(cs: ColumnList): this(SelectData(cs))
    constructor(vararg cs: Column<*>): this(SelectData(Columns(cs.toList())))

    fun FROM(t: Table<*>): WhereAndJoinPart = WhereAndJoinPart(data.copy(table = t))
}

internal typealias SelectCreator = SelectFromPart.() -> SelectStatement

interface Select {
    object SELECT {
        operator fun invoke(columns: Columns, block: SelectCreator) = SelectEnd(SelectFromPart(columns).block().data)
        operator fun invoke(vararg tables: Table<*>, block: SelectCreator) = invoke(Columns(tables.fold(listOf()) { acc, i -> acc + i.columns }), block)
    }
}

