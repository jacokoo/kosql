package com.github.jacokoo.kosql.build

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.expression.Exp
import com.github.jacokoo.kosql.compose.statement.*

interface Builder {
    val part: Part

    fun <T: ColumnList> build(data: SelectData<T>, ctx: Context = DefaultContext(this)): BuildResult
    fun <K, T: Table<K, Entity<K>>> build(data: UpdateData<K, T>, ctx: Context = DefaultContext(this)): BuildResult
    fun build(data: DeleteData, ctx: Context = DefaultContext(this)): BuildResult
    fun <T> build(data: InsertData<T>, ctx: Context = DefaultContext(this)): BuildResult

    fun <T: ColumnList> build(st: SelectStatement<T>, ctx: Context = DefaultContext(this)) = build(st.data, ctx)
    fun <K, T: Table<K, Entity<K>>> build(st: UpdateStatement<K, T>, ctx: Context = DefaultContext(this)) = build(st.data, ctx)
    fun build(st: DeleteStatement, ctx: Context = DefaultContext(this)) = build(st.data, ctx)
    fun <T> build(st: InsertStatement<T>, ctx: Context = DefaultContext(this)) = build(st.data, ctx)

    fun <T: Any> Context.join(
        parts: List<T>, separator: String = ",", prefix: String = "", suffix: String = "",
        fn: (T) -> Unit = { part.build(it, this) }
    ) {
        append(prefix)
        parts.forEachIndexed { idx, it ->
            if (idx > 0) {
                append("$separator ")
            }
            fn(it)
        }
        append(suffix)
    }
}

open class BuildResult(val sql: String, val params: List<Any?>)
class BatchInsertResult(sql: String, params: List<Any?>): BuildResult(sql, params)

open class DefaultBuilder(override val part: Part = DefaultPart()): Builder {
    override fun <T : ColumnList> build(data: SelectData<T>, ctx: Context): BuildResult {
        assert(data.table != null)
        ctx.join(data.columns.columns, prefix = "SELECT ")
        ctx.pad("FROM")
        part.build(data.table!!, ctx)
        appendJoins(data.joins, ctx)
        appendExpression("WHERE", data.expression, ctx)

        if (data.groupBy.isNotEmpty()) {
            ctx.join(data.groupBy, prefix = " GROUP BY ")
        }

        appendExpression("HAVING", data.having, ctx)

        if (data.orderBy.isNotEmpty()) {
            ctx.join(data.orderBy, prefix = " ORDER BY ") { (col, order) ->
                part.build(col, ctx)
                ctx.append(" $order")
            }
        }

        appendLimit(data.rowCount, data.offset, ctx)

        return ctx.result()
    }

    override fun <K, T : Table<K, Entity<K>>> build(data: UpdateData<K, T>, ctx: Context): BuildResult {
        assert(data.pairs.isNotEmpty())
        ctx.append("UPDATE ")
        part.build(data.table, ctx)
        appendJoins(data.joins, ctx)
        ctx.join(data.pairs.toList(), prefix = " SET ") { (column, value) ->
            part.build(column, ctx)
            ctx.append(" = ")
            when(value) {
                null -> ctx.append("NULL")
                is Column<*>, is Exp<*> -> part.build(value, ctx)
                else -> {
                    ctx.append(ctx.param(column.type.toDb(value)))
                }
            }
        }
        appendExpression("WHERE", data.expression, ctx)
        return ctx.result()
    }

    override fun build(data: DeleteData, ctx: Context): BuildResult {
        assert(data.deletes.isNotEmpty())
        ctx.append("DELETE ")
        ctx.join(data.deletes) { ctx.append(ctx.alias(it.inner)!!) }
        ctx.pad("FROM")
        ctx.join(data.deletes)
        appendJoins(data.joins, ctx)
        appendExpression("WHERE", data.expression, ctx)
        return ctx.result()
    }

    override fun <T> build(data: InsertData<T>, ctx: Context): BuildResult {
        assert(data.values.isNotEmpty())
        ctx.append("INSERT INTO ")
        ctx.append(data.table.name)
        if (data.columns.columns.isNotEmpty()) {
            ctx.append(data.columns.columns.joinToString(prefix = "(", postfix = ")") { it.name })
        }
        if (data.query != null) {
            ctx.append(" ")
            build(data.query!!, ctx)
            return ctx.result()
        }

        ctx.pad("VALUES")

        if (data.batch) {
            ctx.append(data.values[0].values.mapIndexed { idx, _ ->
                ctx.placeholder(idx + 1)
            }.joinToString(prefix = "(", postfix = ")"))
            data.values.forEach {
                ctx.param(it.values.mapIndexed { idx, i -> data.columns.columns[idx].type.toDb(i) })
            }
            return ctx.result().let {
                BatchInsertResult(it.sql, it.params)
            }
        }

        ctx.append(data.values.first().values.mapIndexed { idx, it ->
            ctx.param(data.columns.columns[idx].type.toDb(it))
        }.joinToString(prefix = "(", postfix = ")"))
        return ctx.result()
    }

    open fun appendLimit(rowCount: Int?, offset: Int?, ctx: Context) {
        if (rowCount != null && offset != null) {
            val p1 = ctx.param(offset)
            val p2 = ctx.param(rowCount)
            ctx.append(" LIMIT $p1, $p2")
        } else if (rowCount != null) {
            val p = ctx.param(rowCount)
            ctx.append(" LIMIT $p")
        }
    }

    protected fun appendJoins(joins: List<Join>, ctx: Context) {
        if (joins.isEmpty()) ctx.append(" ")
        else joins.forEach {
            ctx.pad("${it.type} JOIN")
            part.build(it.table, ctx)
            ctx.pad("ON")
            part.build(it.expression!!, ctx)
        }
    }

    protected fun appendExpression(keyword: String, exp: Exp<*>?, ctx: Context) {
        if (exp == null || exp == Exp.TRUE) return
        ctx.pad(keyword)
        part.build(exp, ctx)
    }
}
