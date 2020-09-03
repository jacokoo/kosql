package com.github.jacokoo.kosql.compose

import com.github.jacokoo.kosql.compose.statements.*
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import com.github.jacokoo.kosql.compose.typesafe.ValueList
import java.sql.PreparedStatement

private fun fnId(t: Any?): Any? = t

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
                it.param(listOf(data.offset to ::fnId, data.rowCount to ::fnId))
                append(" LIMIT ?, ?")
            } else if (data.rowCount != null) {
                it.param(data.rowCount to ::fnId)
                append(" LIMIT ?")
            }
        }
    }

    fun <K, T: Table<K, Entity<K>>> build(update: UpdateStatement<K, T>): BuildResult = build(update.data, SQLBuilderContext(this, update))
    fun <K, T: Table<K, Entity<K>>> build(data: UpdateData<K, T>, ctx: SQLBuilderContext): BuildResult = BuildResult.build(ctx) {
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
                is Expression<*>  -> {
                    it.param(value.params())
                    value.toSQL(ctx)
                }
                else -> {
                    it.param(value to column.type::toDb)
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
                val part = data.deletes.map { it.toSQL(ctx) }.joinToString()
                data.deletes.map { ctx.alias(it) }.joinTo(this)
                append(" FROM ${part}")
            } else {
                data.deletes.map { ctx.alias(it) }.joinTo(this)
                append(" FROM ").append(data.table.toSQL(ctx))
            }
            appendJoins(this, data.joins, ctx, it)
            appendExpression("WHERE", this, data.expression, ctx, it)
        }
    }

    fun <T> build(insert: BatchInsertStatement<T>) = buildBatch(insert.data, SQLBuilderContext(this, insert, DefaultBatchParameterHolder(insert.data.columns)))
    fun <T> buildBatch(data: InsertData<T>, ctx: SQLBuilderContext): BuildResult {
        assert(data.values.size > 1)
        return BuildResult.build(ctx) {
//            val params = it as DefaultParameterHolder
            append("INSERT INTO ").append(data.table.name)
            data.columns.columns.map { it.name }.joinTo(this, prefix = "(", postfix = ")")
            append(" VALUES ")
            it.param(data.values.map { v -> v to ::fnId })
            append(data.values.first().values.map {
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
                append(data.values.first().values.mapIndexed { index, any ->
                    params.param(any to data.columns.columns[index].type::toDb)
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
    fun param(v: Pair<Any?, (Any?) -> Any?>)
    fun param(v: List<Pair<Any?, (Any?) -> Any?>>) {v.forEach { param(it) }}
    fun fill(ps: PreparedStatement)
}

interface BatchParameterHolder: ParameterHolder {
    fun size(): Int
    fun fill(ps: PreparedStatement, index: Int)
}

class DefaultParameterHolder: ParameterHolder {
    private val params = mutableListOf<Pair<Any?, (Any?) -> Any?>>()

    fun getToDb(idx: Int) = params[idx].second

    override fun param(v: Pair<Any?, (Any?) -> Any?>) { params.add(v) }
    override fun fill(ps: PreparedStatement) {
        if (LOG.isDebugEnabled) {
            LOG.debug("execute with params: {}", params.map { it.first }.joinToString(prefix = "(", postfix = ")"))
        }
        params.forEachIndexed {idx, value -> ps.setObject(idx + 1, value.second(value.first))}
    }

    companion object {
        private val LOG = createLogger(this::class)
    }
}

class DefaultBatchParameterHolder(val columns: ColumnList): BatchParameterHolder {
    private val params = mutableListOf<ValueList>()

    override fun size(): Int = params.size

    override fun param(v: Pair<Any?, (Any?) -> Any?>) {
        assert(v.first != null && v.first is ValueList)
        params.add(v.first as ValueList)
    }

    override fun param(v: List<Pair<Any?, (Any?) -> Any?>>) {
        v.forEach { param(it) }
    }

    override fun fill(ps: PreparedStatement) {
        TODO("not implemented")
    }

    override fun fill(ps: PreparedStatement, index: Int) {
        if (LOG.isDebugEnabled) {
            LOG.debug("batch {}. execute with params: {}", index, params.joinToString(prefix = "(", postfix = ")"))
        }
        params[index].also {
            it.values.forEachIndexed {idx, value -> ps.setObject(idx + 1, columns.columns[idx].type.toDb(value))}
        }
    }

    companion object {
        private val LOG = createLogger(this::class)
    }
}

data class BuildResult(val sql: String, val params: ParameterHolder) {
    companion object {
        internal fun build(ctx: SQLBuilderContext, block: StringBuilder.(ParameterHolder) -> Unit) =
            BuildResult(StringBuilder().also { it.block(ctx.params) }.toString(), ctx.params)
    }
}

open class SQLBuilderContext(val builder: SQLBuilder, val statement: Statement, val params: ParameterHolder = DefaultParameterHolder()) {
    private val prefix = "a_"
    private var aliasIndex = 0
    private var aliasMap: MutableMap<Nameable<*>, String> = mutableMapOf()

    fun alias(target: Nameable<*>): String? {
        if (target.alias.isNotBlank()) return target.alias
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
