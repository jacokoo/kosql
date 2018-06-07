package com.github.jacokoo.kosql.compose

import com.github.jacokoo.kosql.compose.statements.*
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import com.github.jacokoo.kosql.compose.typesafe.ValueList
import java.sql.PreparedStatement

class SQLBuilder {
    fun <T: ColumnList> build(part: SelectStatement<T>): BuildResult = build(part.data, SQLBuilderContext(this, part))
    fun <T: ColumnList> build(data: SelectData<T>, ctx: SQLBuilderContext): BuildResult {
        if (data.table == null) throw RuntimeException("no table specified")
        return BuildResult.build(ctx) {
            append("SELECT ")
            append(data.columns.columns.map { it.toSQL(ctx) }.joinToString())

            append(" FROM ").append(data.table.toSQL(ctx))
            appendJoins(this, data.joins, ctx, it)
            appendExpression("WHERE", this, data.expression, ctx, it)

            if (data.groupBy.isNotEmpty()) append(" GROUP BY ")
            data.groupBy.map { it.toSQL(ctx) }.joinTo(this)

            appendExpression("HAVING", this, data.having, ctx, it)

            if (data.orderBy.isNotEmpty()) {
                append(" ORDER BY ")
            }
            data.orderBy.map { (col, order) -> "${col.toSQL(ctx)} $order" }.joinTo(this)

            if (data.rowCount != null && data.offset != null) {
                it.param(listOf(data.offset, data.rowCount))
                append(" LIMIT ?, ?")
            } else if (data.rowCount != null) {
                it.param(data.rowCount)
                append(" LIMIT ?")
            }
        }
    }

    fun build(update: UpdateStatement): BuildResult = build(update.data, SQLBuilderContext(this, update))
    fun build(data: UpdateData, ctx: SQLBuilderContext): BuildResult = BuildResult.build(ctx) {
        if (data.pairs.none()) throw RuntimeException("no column to update")

        append("UPDATE ").append(data.table.toSQL(ctx))
        appendJoins(this, data.joins, ctx, it)
        append(" SET ")
        data.pairs.map { (column, value) ->
            "${column.toSQL(ctx)} = " + when(value) {
                null -> "NULL"
                is Column<*> -> value.toSQL(ctx)
                is ColumnToColumnExpression<*> -> value.toSQL(ctx)
                is ColumnToValueExpression<*> -> {
                    it.param(value.params())
                    value.toSQL(ctx)
                }
                else -> {
                    it.param(value)
                    "?"
                }
            }
        }.joinTo(this)

        appendExpression("WHERE", this, data.expression, ctx, it)
    }

    fun build(delete: DeleteStatement): BuildResult = build(delete.data, SQLBuilderContext(this, delete))
    fun build(data: DeleteData, ctx: SQLBuilderContext): BuildResult {
        if (data.deletes.none()) throw RuntimeException("no table specified for delete")
        return BuildResult.build(ctx) {
            append("DELETE ")
            if (data.table == null) {
                append("FROM ")
                data.deletes.map { it.toSQL(ctx) }.joinTo(this)
            } else {
                data.deletes.map { ctx.alias(it) }.joinTo(this)
                append(" FROM ").append(data.table.toSQL(ctx))
            }
            appendJoins(this, data.joins, ctx, it)
            appendExpression("WHERE", this, data.expression, ctx, it)
        }
    }

    fun <T> build(insert: BatchInsertStatement<T>) = buildBatch(insert.data, SQLBuilderContext(this, insert))
    fun <T> buildBatch(data: InsertData<T>, ctx: SQLBuilderContext): BuildResult {
        assert(data.values.size > 1)
        return BuildResult.build(ctx, DefaultBatchParameterHolder()) {
            val params = it as DefaultParameterHolder
            append("INSERT INTO ").append(data.table.name)
            data.columns.columns.map { it.name }.joinTo(this, prefix = "(", postfix = ")")
            params.param(data.values)
            append(data.values.first().values.map {
                params.param(it)
                "?"
            }.joinToString(prefix = "(", postfix = ")"))
        }
    }

    fun <T> build(insert: InsertStatement<T>) = build(insert.data, SQLBuilderContext(this, insert))
    fun <T> build(data: InsertData<T>, ctx: SQLBuilderContext): BuildResult {
        assert(data.query != null || data.values.isNotEmpty())
        return BuildResult.build(ctx) { params ->
            append("INSERT INTO ").append(data.table.name)
            data.columns.columns.map { it.name }.joinTo(this, prefix = "(", postfix = ")")
            if (data.query == null) {
                append(" VALUES ")
                append(data.values.first().values.map {
                    params.param(it)
                    "?"
                }.joinToString(prefix = "(", postfix = ")"))
            } else {
                append(" ").append(build(data.query.data, ctx).sql)
            }
        }
    }

    private fun appendJoins(str: StringBuilder, joins: List<Join>, ctx: SQLBuilderContext, params: ParameterHolder) {
        if (!joins.none()) str.append(" ")
        joins.map {
            params.param(it.expression.params())
            "${it.type} JOIN ${it.table.toSQL(ctx)} ON ${it.expression!!.toSQL(ctx)}"
        }.joinTo(str, " ")
    }

    private fun appendExpression(keyword: String, str: StringBuilder, exp: Expression<*>?, ctx: SQLBuilderContext, params: ParameterHolder) {
        params.param(exp.params())
        exp?.let { if (it == Expression.TRUE) null else it }?.let {
            str.append(" $keyword ").append(it.toSQL(ctx))
        }
    }
}

interface ParameterHolder {
    fun param(v: Any?)
    fun param(v: List<Any?>) {v.forEach { param(it) }}
    fun fill(ps: PreparedStatement)
}

interface BatchParameterHolder: ParameterHolder {
    fun size(): Int
    fun fill(ps: PreparedStatement, index: Int)
}

class DefaultParameterHolder: ParameterHolder {
    private val params = mutableListOf<Any?>()

    override fun param(v: Any?) { params.add(v) }
    override fun fill(ps: PreparedStatement) { params.forEachIndexed {idx, value -> ps.setObject(idx + 1, value)} }
}

class DefaultBatchParameterHolder: BatchParameterHolder {
    private val params = mutableListOf<ValueList>()

    override fun size(): Int = params.size

    override fun param(v: Any?) {
        assert(v != null && v is ValueList)
        params.add(v as ValueList)
    }

    override fun fill(ps: PreparedStatement) {
        TODO("not implemented")
    }

    override fun fill(ps: PreparedStatement, index: Int) {
        params[index].also {
            it.values.forEachIndexed {idx, value -> ps.setObject(idx + 1, value)}
        }
    }
}

data class BuildResult(val sql: String, val params: ParameterHolder) {
    companion object {
        internal fun build(ctx: SQLBuilderContext, params: ParameterHolder = DefaultParameterHolder(), block: StringBuilder.(ParameterHolder) -> Unit): BuildResult {
            var str = StringBuilder()
            str.block(params)
            return BuildResult(str.toString(), params)
        }
    }
}

open class SQLBuilderContext(val builder: SQLBuilder, val statement: Statement) {
    private val prefix = "a_"
    private var aliasIndex = 0
    private var aliasMap: MutableMap<Nameable<*>, String> = mutableMapOf()

    internal var arguments: MutableList<Any?> = mutableListOf()

    fun alias(target: Nameable<*>): String? {
        if (aliasMap.contains(target)) return aliasMap[target]
        if (!target.aliasRequired) return target.let {
            if (it.alias == "") return null
            checkAlias(target)
        }
        return checkAlias(target)
    }

    private fun checkAlias(target: Nameable<*>): String {
        val a = if (target.alias == "" || aliasMap.values.contains(target.alias)) "$prefix${aliasIndex++}" else target.alias
        aliasMap[target] = a
        return a
    }

}
