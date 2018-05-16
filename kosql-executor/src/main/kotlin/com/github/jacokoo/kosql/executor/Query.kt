package com.github.jacokoo.kosql.executor

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Database
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.statements.DeleteStatement
import com.github.jacokoo.kosql.compose.statements.InsertStatement
import com.github.jacokoo.kosql.compose.statements.SelectStatement
import com.github.jacokoo.kosql.compose.statements.UpdateStatement
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import com.github.jacokoo.kosql.compose.typesafe.Value
import com.github.jacokoo.kosql.compose.typesafe.Values
import java.sql.ResultSet
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

internal class ResultIterator<T: Value>(private val t: SelectResult<T>): AbstractIterator<T>() {
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

interface SelectResult<out T: Value>: Iterable<T> {
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

data class SelectResults(override val columns: ColumnList, override val values: List<Values>): SelectResult<Values> {
    constructor(cs: ColumnList, qp: SelectStatement, ko: Query): this(cs, ko.execute(qp, Mapper(cs)))
    private class Mapper(private val cs: ColumnList): ResultSetMapper<Values> {
        override fun map(rs: ResultSetRow) = Values(cs.columns.mapIndexed { idx, col -> rs[idx, col] })
    }
}

interface Query {
    fun <T> execute(select: SelectStatement, mapper: ResultSetMapper<T>): List<T>
    fun execute(update: UpdateStatement): Int
    fun execute(delete: DeleteStatement): Int
    fun <T> execute(insert: InsertStatement<T>): Pair<T, Int>
    fun <T> executeBatch(insert: InsertStatement<T>): Pair<List<T>, Int>

    fun <T> execute(select: SelectStatement, mapper: (ResultSetRow) -> T): List<T> = execute(select, object: ResultSetMapper<T> {
        override fun map(rs: ResultSetRow): T = mapper(rs)
    })
    fun <T: Entity<*, *>> execute(select: SelectStatement, entityClass: KClass<T>): List<T> = execute(select, ColumnsToEntityMapper(select.data.columns, entityClass))

    fun <T> SelectStatement.fetch(mapper: ResultSetMapper<T>): List<T> = execute(this, mapper)
    fun <T: Entity<*, *>> SelectStatement.fetch(entityClass: KClass<T>) = execute(this, entityClass)
    fun <T> SelectStatement.fetch(mapper: (ResultSetRow) -> T): List<T> = execute(this, mapper)
    fun SelectStatement.fetch(): SelectResults = SelectResults(this.data.columns, this, this@Query)
}

