package com.github.jacokoo.kosql.mapping

import com.github.jacokoo.kosql.Column
import com.github.jacokoo.kosql.statements.*
import kotlin.reflect.KClass

interface ResultRow {
    val values: List<Any>
    operator fun get(idx: Int): Any = values[idx]
}

internal class ResultIterator<T: ResultRow>(private val t: QueryResult<T>): AbstractIterator<T>() {
    private val count = t.values.size
    private var current = 0

    override fun computeNext() {
        if (current >= count) done()
        else setNext(t.values[current++])
    }
}

interface QueryResult<out T: ResultRow>: Iterable<T> {
    val columns: List<Column<*>>
    val values: List<T>

    @Suppress("UNCHECKED_CAST")
    fun <T: Entity<*, *>> into(entityClass: KClass<T>): List<T> {
        val cs = columns.filter { it.table.entityClass() == entityClass }
        if (cs.none()) return listOf()

        return values.map { v -> cs[0].table.create().also { e ->
            columns.forEachIndexed {i, c -> if (cs.contains(c)) e[c.name] = v[i]}
        } as T }
    }

    fun size() = values.size
    fun isEmpty() = values.isEmpty()
    operator fun get(idx: Int) = values[idx]

    override fun iterator(): Iterator<T> = ResultIterator(this)
}

data class ResultRows(override val values: List<Any>): ResultRow
class QueryResults(override val columns: List<Column<*>>, override val values: List<ResultRows>): QueryResult<ResultRows>

data class SelectStatement1<T1: Any>(val c1: Column<T1>, override val data: QueryData): QueryPart
data class ResultRow1<T1: Any>(val v1: T1, override val values: List<Any> = listOf(v1)): ResultRow
data class QueryResult1<T1: Any>(private val c1: Column<T1>, override val values: List<ResultRow1<T1>>, override val columns: List<Column<*>> = listOf(c1)): QueryResult<ResultRow1<T1>>


@Suppress("UNCHECKED_CAST")
interface QueryResultExtension {
    fun execute(qp: QueryPart): QueryResults
    fun SelectStatement.fetch(): QueryResults = execute(this)


    fun <T: Any> QueryResults.to1() {
        QueryResult1(this.columns[0] as Column<T>, this.values.map { ResultRow1(it.values[0] as T) })
        TODO("try to remove the map loop")
    }

    operator fun <T1: Any> Select.SELECT.invoke(c1: Column<T1>, block: SelectFromPart.() -> QueryPart): SelectStatement1<T1> =
            SelectStatement1(c1, SelectFromPart(QueryData(listOf(c1))).block().data)
    fun <T1: Any> SelectStatement1<T1>.fetch(): QueryResult1<T1> =
            execute(this).let { QueryResult1(it.columns[0] as Column<T1>, it.values.map { ResultRow1(it.values[0] as T1) }) }

}


