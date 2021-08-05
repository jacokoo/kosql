package com.github.jacokoo.kosql.build.pg

import com.github.jacokoo.kosql.build.*
import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.expression.Exp
import com.github.jacokoo.kosql.compose.statement.InsertData
import com.github.jacokoo.kosql.compose.statement.UpdateData

class PostgresPart: DefaultPart()

class PostgresBuilder: DefaultBuilder(part = PostgresPart()) {
    override fun appendLimit(rowCount: Int?, offset: Int?, ctx: Context) {
        rowCount?.let { ctx.append(" LIMIT ${ctx.param(it)}") }
        offset?.let { ctx.append(" OFFSET ${ctx.param(it)}") }
    }

    override fun <T> build(data: InsertData<T>, ctx: Context): BuildResult {
        val result = super.build(data, ctx)
        val cols = data.table.columns.filter { it.autoIncrement }
        if (cols.isEmpty()) return result

        ctx.append(" RETURNING ")
        ctx.append(cols.joinToString { it.name })
        return if (result is BatchInsertResult) {
            ctx.result().let { BatchInsertResult(it.sql, it.params) }
        } else {
            ctx.result()
        }
    }

    override fun <K, T : Table<K, Entity<K>>> build(data: UpdateData<K, T>, ctx: Context): BuildResult {
        assert(data.pairs.isNotEmpty())
        ctx.append("UPDATE ")
        part.build(data.table, ctx)
        appendJoins(data.joins, ctx)
        ctx.join(data.pairs.toList(), prefix = " SET ") { (column, value) ->
            ctx.append(" ${column.name} = ")
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
}

class PostgresContext: DefaultContext(builder = PostgresBuilder()) {
    override fun placeholder(idx: Int): String = "\$$idx"
}
