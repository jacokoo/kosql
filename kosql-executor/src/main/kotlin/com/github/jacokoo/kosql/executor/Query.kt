package com.github.jacokoo.kosql.executor

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Database
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.statements.*
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import com.github.jacokoo.kosql.compose.typesafe.ValueList
import com.github.jacokoo.kosql.compose.typesafe.Values
import java.sql.ResultSet
import kotlin.reflect.KClass

internal class ResultIterator<T: ValueList>(private val t: SelectResult<T>): AbstractIterator<T>() {
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

class ColumnsToEntityMapper<T, R: Entity<T>>(val columns: ColumnList, val entityClass: KClass<R>): ResultSetMapper<R> {
    @Suppress("UNCHECKED_CAST")
    override fun map(rs: ResultSetRow): R {
        val cs = columns.columns.filter { Database[it.table as Table<T, R>] == entityClass }
        assert(cs.isNotEmpty())
        val clazz = Database[cs[0].table as Table<T, R>] ?: throw RuntimeException("no entity class found")
        return clazz.java.getDeclaredConstructor().newInstance().also {
            columns.columns.forEach {c -> if (cs.contains(c)) it[c.name] = rs[c]}
        } as R
    }
}

interface SelectResult<out T: ValueList>: Iterable<T> {
    val columns: ColumnList
    val values: List<T>

    @Suppress("UNCHECKED_CAST")
    fun <T> into(entityClass: KClass<Entity<T>>): List<Entity<T>> {
        val cs = columns.columns.filter { Database[it.table as Table<T, Entity<T>>] == entityClass }
        if (cs.none()) return listOf()

        return values.map { v -> entityClass.java.getDeclaredConstructor().newInstance().also { e ->
            columns.columns.forEachIndexed {i, c -> if (cs.contains(c)) e[c.name] = v[i]}
        } }
    }

    fun size() = values.size
    fun isEmpty() = values.isEmpty()
    operator fun get(idx: Int) = values[idx]

    override fun iterator(): Iterator<T> = ResultIterator(this)
}

class SelectResultsMapper(private val cs: ColumnList): ResultSetMapper<Values> {
    override fun map(rs: ResultSetRow) = Values(cs.columns.mapIndexed { idx, col -> rs[idx, col] })
}
data class SelectResults<T: ColumnList>(override val columns: ColumnList, override val values: List<Values>): SelectResult<Values> {
    constructor(cs: ColumnList, qp: SelectStatement<T>, ko: Query): this(cs, ko.execute(qp, SelectResultsMapper(cs)))
}

interface Query {
    fun <T, R: ColumnList> execute(select: SelectStatement<R>, mapper: ResultSetMapper<T>): List<T>
    fun execute(update: UpdateStatement): Int
    fun execute(delete: DeleteStatement): Int
    fun <T> execute(insert: InsertStatement<T>): Pair<T, Int>
    fun <T> execute(insert: BatchInsertStatement<T>): Int

    fun <T, R: ColumnList> execute(select: SelectStatement<R>, mapper: (ResultSetRow) -> T): List<T> = execute(select, object: ResultSetMapper<T> {
        override fun map(rs: ResultSetRow): T = mapper(rs)
    })
    fun <T, R: Entity<T>, L: ColumnList> execute(select: SelectStatement<L>, entityClass: KClass<out R>): List<R> = execute(select, ColumnsToEntityMapper(select.data.columns, entityClass))

    fun <T, R: ColumnList> SelectStatement<R>.fetch(mapper: ResultSetMapper<T>): List<T> = execute(this, mapper)
    fun <T, R: Entity<T>, L: ColumnList> SelectStatement<L>.fetch(entityClass: KClass<out R>) = execute(this, entityClass)
    fun <T, R: ColumnList> SelectStatement<R>.fetch(mapper: (ResultSetRow) -> T): List<T> = execute(this, mapper)
    fun <T: ColumnList> SelectStatement<T>.fetch(): SelectResults<T> = SelectResults(this.data.columns, this, this@Query)
}


