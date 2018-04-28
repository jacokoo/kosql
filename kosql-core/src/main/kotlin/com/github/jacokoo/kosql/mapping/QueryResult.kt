package com.github.jacokoo.kosql.mapping

import com.github.jacokoo.kosql.Column
import com.github.jacokoo.kosql.statements.SelectStatement
import com.github.jacokoo.kosql.typesafe.ColumnList
import com.github.jacokoo.kosql.typesafe.Value
import com.github.jacokoo.kosql.typesafe.Values
import java.sql.ResultSet
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

internal class ResultIterator<T: Value>(private val t: QueryResult<T>): AbstractIterator<T>() {
    private var current = 0

    override fun computeNext() {
        if (current >= t.size()) done()
        else setNext(t.values[current++])
    }
}

data class ResultSetRow(private val rs: ResultSet) {
    operator fun <T> get(idx: Int, col: Column<T>): T = col.type.fromDb(rs.getObject(idx + 1))
    operator fun <T> get(col: Column<T>): T = col.type.fromDb(rs.getObject(col.name))

    operator fun get(idx: Int): Any? = rs.getObject(idx + 1)
    operator fun get(name: String): Any? = rs.getObject(name)
}

interface ResultSetMapper<out R> {
    fun map(rs: ResultSetRow): R
}

class ColumnsToEntityMapper<R: Entity<*, *>>(val columns: ColumnList, val entityClass: KClass<R>): ResultSetMapper<R> {
    @Suppress("UNCHECKED_CAST")
    override fun map(rs: ResultSetRow): R {
        val cs = columns.columns.filter { Database[it.table] == entityClass }
        if (cs.none()) throw RuntimeException("no columns for entity")
        val clazz = Database[cs[0].table] ?: throw RuntimeException("no entity class found")
        return clazz.createInstance().also {
            columns.columns.forEach {c -> if (cs.contains(c)) it[c.name] = rs[c]}
        } as R
    }
}

interface QueryResult<out T: Value>: Iterable<T> {
    val columns: ColumnList
    val values: List<T>

    @Suppress("UNCHECKED_CAST")
    fun <T: Entity<*, *>> into(entityClass: KClass<T>): List<T> {
        val cs = columns.columns.filter { Database[it.table] == entityClass }
        if (cs.none()) return listOf()

        return values.map { v -> entityClass.createInstance().also { e ->
            columns.columns.forEachIndexed {i, c -> if (cs.contains(c)) e[c.name] = v[i]}
        } }
    }

    fun size() = values.size
    fun isEmpty() = values.isEmpty()
    operator fun get(idx: Int) = values[idx]

    override fun iterator(): Iterator<T> = ResultIterator(this)
}

data class QueryResults(override val columns: ColumnList, override val values: List<Values>): QueryResult<Values> {
    constructor(cs: ColumnList, qp: SelectStatement, ko: QueryResultExtension): this(cs, ko.execute(qp, Mapper(cs)))
    private class Mapper(private val cs: ColumnList): ResultSetMapper<Values> {
        override fun map(rs: ResultSetRow) = Values(cs.columns.mapIndexed { idx, col -> rs[idx, col] })
    }
}

interface QueryResultExtension {
    fun <T> execute(qp: SelectStatement, mapper: ResultSetMapper<T>): List<T>
    fun <T> execute(qp: SelectStatement, mapper: (ResultSetRow) -> T): List<T> = execute(qp, object: ResultSetMapper<T> {
        override fun map(rs: ResultSetRow): T = mapper(rs)
    })
    fun <T: Entity<*, *>> execute(qp: SelectStatement, entityClass: KClass<T>): List<T> = execute(qp, ColumnsToEntityMapper(qp.data.columns, entityClass))

    fun <T> SelectStatement.fetch(mapper: ResultSetMapper<T>): List<T> = execute(this, mapper)
    fun <T> SelectStatement.fetchOne(mapper: ResultSetMapper<T>) = execute(this, mapper).firstOrNull()

    fun <T: Entity<*, *>> SelectStatement.fetch(entityClass: KClass<T>) = execute(this, entityClass)
    fun <T: Entity<*, *>> SelectStatement.fetchOne(entityClass: KClass<T>) = execute(this, entityClass).firstOrNull()

    fun <T> SelectStatement.fetch(mapper: (ResultSetRow) -> T): List<T> = execute(this, mapper)
    fun <T> SelectStatement.fetchOne(mapper: (ResultSetRow) -> T) = execute(this, mapper).firstOrNull()

    fun SelectStatement.fetch(): QueryResults = QueryResults(this.data.columns, this, this@QueryResultExtension)
    fun SelectStatement.fetchOne() = fetch().values.firstOrNull()
}


