package com.github.jacokoo.kosql.build.pg

import com.github.jacokoo.kosql.build.*
import com.github.jacokoo.kosql.compose.statement.InsertData

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
}

class PostgresContext: DefaultContext(builder = PostgresBuilder()) {
    override fun placeholder(idx: Int): String = "\$$idx"
}
