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

data class ResultSetRow(private val rs: ResultSet, private val columns: ColumnList) {
    operator fun <T> get(idx: Int, col: Column<T>): T = col.type.fromDb(rs.getObject(idx + 1))

    @Suppress("UNCHECKED_CAST")
    fun <T, R: Entity<T>, S: Table<T, R>> into(table: S): R? {
        val entityClass = Database.getEntity(table::class)!!
        val entity = entityClass.java.getDeclaredConstructor().newInstance()
        var allNull = true
        columns.columns.forEachIndexed {idx, col ->
            if (col.table == table) entity[col.name] = get(idx, col).also {
                if (allNull && it != col.type.nullValue) allNull = false
            }
        }

        return if (allNull) null else entity as R
    }
}

interface ResultSetMapper<out R> {
    fun map(rs: ResultSetRow): R
}

interface SelectResult<out T: ValueList>: Iterable<T> {
    val columns: ColumnList
    val values: List<T>

    @Suppress("UNCHECKED_CAST")
    fun <T, R: Entity<T>, S: Table<T, R>> into(table: S): List<R> {
        val cs = columns.columns.filter { it.table == table }
        if (cs.none()) return listOf()
        val entityClass = Database.getEntity(table::class)!!

        return values.mapNotNull { v -> entityClass.java.getDeclaredConstructor().newInstance().let { e ->
            var allNull = true
            columns.columns.forEachIndexed {i, c -> if (cs.contains(c)) e[c.name] = v[i].also {
                if (allNull && it != c.type.nullValue) allNull = false
            }}
            if (allNull) null else e as R
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
    fun <K, T: Table<K, Entity<K>>>execute(update: UpdateStatement<K, T>): Int
    fun execute(delete: DeleteStatement): Int
    fun <T> execute(insert: InsertStatement<T>): Pair<T, Int>
    fun <T> execute(insert: BatchInsertStatement<T>): Int

    fun <T, R: ColumnList> execute(select: SelectStatement<R>, mapper: ResultSetMapper<T>): List<T>
    fun <T, R: ColumnList> execute(select: SelectStatement<R>, mapper: (ResultSetRow) -> T): List<T> = execute(select, object: ResultSetMapper<T> {
        override fun map(rs: ResultSetRow): T = mapper(rs)
    })
    fun <T, R: Entity<T>, L: ColumnList> execute(select: SelectStatement<L>, table: Table<T, R>): List<R> = execute(select) { it.into(table)!! }

    fun <T, R: ColumnList> SelectStatement<R>.fetch(mapper: ResultSetMapper<T>): List<T> = execute(this, mapper)
    fun <T, R: Entity<T>, L: ColumnList> SelectStatement<L>.fetch(table: Table<T, R>): List<R> = execute(this, table)
    fun <T, R: ColumnList> SelectStatement<R>.fetch(mapper: (ResultSetRow) -> T): List<T> = execute(this, mapper)
    fun <T: ColumnList> SelectStatement<T>.fetch(): SelectResults<T> = SelectResults(this.data.columns, this, this@Query)
    fun <T, R: Entity<T>, L: ColumnList> SelectStatement<L>.fetch(table: Table<T, R>, setter: (R, ResultSetRow) -> Unit): List<R> {
        val map = mutableMapOf<T, R>()
        execute(this) {
            val idx = this.data.columns.columns.indexOf(table.primaryKey())
            val id = it[idx, table.primaryKey()]
            if (!map.containsKey(id)) {
                map[id] = it.into(table)!!
            }
            setter(map[id]!!, it)
        }
        return map.values.toList()
    }
}


