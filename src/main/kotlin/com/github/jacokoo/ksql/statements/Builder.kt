package com.github.jacokoo.ksql.statements

import com.github.jacokoo.ksql.Nameable
import com.github.jacokoo.ksql.TRUE

class SQLBuilder {
    fun build(part: QueryPart): BuildResult = build(part.data)

    fun build(data: QueryData): BuildResult = build(data, SQLBuilderContext(this))

    fun build(data: QueryData, ctx: SQLBuilderContext): BuildResult {
        if (data.table == null) throw RuntimeException("no table specified")
        return BuildResult(buildString {
            append(" FROM ").append(data.table.toSQL(ctx))

            if (!data.joins.none()) append(" ")
            data.joins.map {
                "${it.type} JOIN ${it.table.toSQL(ctx)} ON ${it.expression.toSQL(ctx)}"
            }.joinTo(this, " ")

            data.expression?.let { if (it == TRUE) null else it }?.let {
                append(" WHERE ").append(it.toSQL(ctx))
            }

            if (data.groupBy.isNotEmpty()) append(" GROUP BY ")
            data.groupBy.map { it.toSQL(ctx) }.joinTo(this)

            data.having?.let { if (it == TRUE) null else it }?.let {
                append(" HAVING ").append(it.toSQL(ctx))
            }

            if (data.orderBy.isNotEmpty()) {
                append(" ORDER BY ")
            }
            data.orderBy.map { (col, order) -> "${col.toSQL(ctx)} $order" }.joinTo(this)

            if (data.rowCount != null && data.offset != null) {
                append(" LIMIT ${data.offset}, ${data.rowCount}")
            } else if (data.rowCount != null) {
                append(" LIMIT ${data.rowCount}")
            }

            val s = data.columns.map { it.toSQL(ctx) }.joinToString()
            insert(0, s)
            insert(0, "SELECT ")

        }, ctx)
    }

}

data class BuildResult(val sql: String, val context: SQLBuilderContext)

class SQLBuilderContext(val builder: SQLBuilder) {
    private val prefix = "a_"
    private var aliasIndex = 0
    private var aliasMap: MutableMap<Nameable<*>, String> = mutableMapOf()

    private var arguments: MutableList<Any> = mutableListOf()

    fun alias(target: Nameable<*>): String? {
        if (aliasMap.contains(target)) return aliasMap[target]
        if (!target.aliasRequired) return target.let {
            if (it.alias == "") return null
            checkAlias(target)
        }
        return checkAlias(target)
    }

    fun argument(v: Any) {
        arguments.add(v)
    }

    private fun checkAlias(target: Nameable<*>): String {
        val a = if (target.alias == "" || aliasMap.values.contains(target.alias)) "$prefix${aliasIndex++}" else target.alias
        aliasMap[target] = a
        return a
    }
}
