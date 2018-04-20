package com.github.jacokoo.kosql.mapping

import com.github.jacokoo.kosql.Column
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.statements.BuildResult
import com.github.jacokoo.kosql.statements.QueryPart
import java.sql.ResultSet
import kotlin.reflect.KClass

class QueryResult2(private val resultSet: ResultSet, private val sql: BuildResult) {

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

interface ResultRow {
    val values: List<Any>
    operator fun get(idx: Int): Any = values[idx]
}

interface QueryResult {
    val columns: List<Column<*>>
    val values: List<ResultRow>

    fun <T: Entity<*>> into(entityClass: KClass<T>): List<T> {
        val cs = columns.filter { it.table.entityClass() == entityClass }
        if (cs.none()) return listOf()

        return values.map { v -> cs[0].table.create().also { e ->
            columns.forEachIndexed {i, c -> if (cs.contains(c)) e[c.name] = v[i]}
        } as T }
    }
}

data class ResultRows(override val values: List<Any>): ResultRow
class QueryResults(override val columns: List<Column<*>>, override val values: List<ResultRow>): QueryResult

data class ResultRow1<T1: Any>(val v1: T1, override val values: List<Any> = listOf(v1)): ResultRow
class QueryResult1<T1: Any>(val c1: Column<T1>, override val values: List<ResultRow1<T1>>, override val columns: List<Column<*>> = listOf(c1)): QueryResult
fun <T: Any> QueryResults.to1() = QueryResult1(this.columns[0] as Column<T>, this.values.map { ResultRow1(it.values[0] as T) })