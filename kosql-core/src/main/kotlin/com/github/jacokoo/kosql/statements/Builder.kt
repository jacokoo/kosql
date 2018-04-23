package com.github.jacokoo.kosql.statements

import com.github.jacokoo.kosql.*

class SQLBuilder {
    fun build(st: Statement): BuildResult = when(st) {
        is QueryPart -> build(st)
        is UpdatePart -> build(st)
        is DeletePart -> build(st)
        is InsertPart -> build(st)
        else -> throw RuntimeException("unsupported statement")
    }

    fun build(part: QueryPart): BuildResult = build(part.data, SQLBuilderContext(this, part))
    fun build(data: QueryData, ctx: SQLBuilderContext): BuildResult {
        if (data.table == null) throw RuntimeException("no table specified")
        return BuildResult.build(ctx) {
            append(" FROM ").append(data.table.toSQL(ctx))
            appendJoins(this, data.joins, ctx)
            appendExpression("WHERE", this, data.expression, ctx)

            if (data.groupBy.isNotEmpty()) append(" GROUP BY ")
            data.groupBy.map { it.toSQL(ctx) }.joinTo(this)

            appendExpression("HAVING", this, data.having, ctx)

            if (data.orderBy.isNotEmpty()) {
                append(" ORDER BY ")
            }
            data.orderBy.map { (col, order) -> "${col.toSQL(ctx)} $order" }.joinTo(this)

            if (data.rowCount != null && data.offset != null) {
                append(" LIMIT ${data.offset}, ${data.rowCount}")
            } else if (data.rowCount != null) {
                append(" LIMIT ${data.rowCount}")
            }

            val s = data.columns.columns.map { it.toSQL(ctx) }.joinToString()
            insert(0, s)
            insert(0, "SELECT ")
        }
    }

    fun build(update: UpdatePart): BuildResult = build(update.data, SQLBuilderContext(this, update))
    fun build(data: UpdateData, ctx: SQLBuilderContext): BuildResult = BuildResult.build(ctx) {
        if (data.pairs.none()) throw RuntimeException("no column to update")

        append("UPDATE ").append(data.table.toSQL(ctx))
        appendJoins(this, data.joins, ctx)
        append(" SET ")
        data.pairs.map { (column, value) ->
            "${column.toSQL(ctx)} = " + when(value) {
                null -> "NULL"
                is Column<*> -> value.toSQL(ctx)
                is ColumnToColumnExpression<*> -> value.toSQL(ctx)
                is ColumnToValueExpression<*> -> value.toSQL(ctx)
                else -> {
                    ctx.argument(value)
                    "?"
                }
            }
        }.joinTo(this)

        appendExpression("WHERE", this, data.expression, ctx)
    }

    fun build(delete: DeletePart): BuildResult = build(delete.data, SQLBuilderContext(this, delete))
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
            appendJoins(this, data.joins, ctx)

            appendExpression("WHERE", this, data.expression, ctx)
        }
    }

    fun build(insert: InsertPart): BuildResult = build(insert.data, SQLBuilderContext(this, insert))
    fun build(data: InsertData, ctx: SQLBuilderContext): BuildResult {
        if (data.query == null && data.values.none()) throw RuntimeException("no data to insert")
        return BuildResult.build(ctx) {
            append("INSERT INTO ").append(data.table.name)
            data.columns.columns.map { it.name }.joinTo(this, prefix = "(", postfix = ")")
            if (data.query == null) {
                append(" VALUES ")
                data.values.map { it.map {
                    ctx.argument(it)
                    "?"
                }.joinToString(prefix = "(", postfix = ")") }.joinTo(this)
            } else {
                append(" ").append(build(data.query.data, ctx).sql)
            }
        }
    }

    private fun appendJoins(str: StringBuilder, joins: List<Join>, ctx: SQLBuilderContext) {
        if (!joins.none()) str.append(" ")
        joins.map {
            "${it.type} JOIN ${it.table.toSQL(ctx)} ON ${it.expression.toSQL(ctx)}"
        }.joinTo(str, " ")
    }

    private fun appendExpression(keyword: String, str: StringBuilder, exp: Expression<*>?, ctx: SQLBuilderContext) {
        exp?.let { if (it == TRUE) null else it }?.let {
            str.append(" $keyword ").append(it.toSQL(ctx))
        }
    }
}

data class BuildResult(val sql: String, val context: SQLBuilderContext) {
    companion object {
        internal fun build(ctx: SQLBuilderContext, block: StringBuilder.() -> Unit): BuildResult {
            var str = StringBuilder()
            str.block()
            return BuildResult(str.toString(), ctx)
        }
    }
}

class SQLBuilderContext(val builder: SQLBuilder, val statement: Statement) {
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

    fun argument(v: Any?) {
        arguments.add(v)
    }

    private fun checkAlias(target: Nameable<*>): String {
        val a = if (target.alias == "" || aliasMap.values.contains(target.alias)) "$prefix${aliasIndex++}" else target.alias
        aliasMap[target] = a
        return a
    }
}
