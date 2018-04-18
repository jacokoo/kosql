package com.github.jacokoo.ksql.mapping

import com.github.jacokoo.ksql.Table
import com.github.jacokoo.ksql.statements.BuildResult
import com.github.jacokoo.ksql.statements.QueryPart
import java.sql.ResultSet

class QueryResult(private val resultSet: ResultSet, private val sql: BuildResult) {

    fun <T: Any> into(t: Table<T>): List<Entity<T>> {
        var list = mutableListOf<Entity<T>>()
        val columns = (sql.context.statement as QueryPart).data.columns.filter { it.table.name == t.name }
        if (columns.none()) return list

        while (resultSet.next()) {
            val entity = t.create()
            columns.forEachIndexed {idx, col ->
                entity[col.name] = col.type.fromDb(resultSet.getObject(idx + 1))
            }
            list.add(entity)
        }

        return list
    }

}