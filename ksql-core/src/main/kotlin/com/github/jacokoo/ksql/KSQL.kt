package com.github.jacokoo.ksql

import com.github.jacokoo.ksql.mapping.Entity
import com.github.jacokoo.ksql.mapping.QueryResult
import com.github.jacokoo.ksql.statements.QueryPart
import com.github.jacokoo.ksql.statements.SQLBuilder
import javax.sql.DataSource

class KSQL(private val dataSource: DataSource) {
    private val builder = SQLBuilder()

    fun <T: Any> query(table: Table<T>, block: Query.() -> QueryPart): List<out Entity<T>> {
        val part = Query.block()
        val result = builder.build(part)
        val conn = dataSource.connection
        val st = conn.prepareStatement(result.sql)
        println(result.sql)
        result.context.arguments.forEachIndexed {idx, value -> st.setObject(idx + 1, value)}
        val resultSet = st.executeQuery()

        val re =  QueryResult(resultSet, result).into(table)
        conn.close()
        return re
    }
}