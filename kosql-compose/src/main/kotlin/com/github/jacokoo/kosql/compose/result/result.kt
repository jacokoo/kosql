package com.github.jacokoo.kosql.compose.result

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.statement.ColumnList
import com.github.jacokoo.kosql.compose.statement.ValueList
import com.github.jacokoo.kosql.compose.statement.Values

data class Row(private val holder: (Int) -> Any?, private val columns: ColumnList) {
    operator fun <T> get(idx: Int, col: Column<T>): T = col.type.fromDb(holder(idx))

    fun <T, R: Entity<T>, S: Table<T, R>> into(table: S): R? {
        var allNull = true
        val entity = table.createEntity()
        columns.columns.forEachIndexed {idx, col ->
            if (col.table == table.inner) entity[col.name] = get(idx, col).also {
                if (allNull && it != col.type.nullValue) allNull = false
            }
        }

        return if (allNull) null else entity
    }
}

interface Mapper<out R> {
    fun map(rs: Row): R
}

internal class ResultIterator<T: ValueList>(private val t: SelectResult<T>): AbstractIterator<T>() {
    private var current = 0

    override fun computeNext() {
        if (current >= t.size()) done()
        else setNext(t.values[current++])
    }
}

interface SelectResult<out T: ValueList>: Iterable<T> {
    val columns: ColumnList
    val values: List<T>

    fun <T, R: Entity<T>, S: Table<T, R>> into(table: S): List<R> {
        val cs = columns.columns.filter { it.table == table.inner }
        if (cs.none()) return listOf()

        return values.mapNotNull { v ->
            table.createEntity().let { e ->
                var allNull = true
                columns.columns.forEachIndexed { i, c ->
                    if (cs.contains(c)) e[c.name] = v[i].also {
                        if (allNull && it != c.type.nullValue) allNull = false
                    }
                }
                if (allNull) null else e
            }
        }
    }

    fun size() = values.size
    fun isEmpty() = values.isEmpty()
    operator fun get(idx: Int) = values[idx]
    override fun iterator(): Iterator<T> = ResultIterator(this)
}

class ValuesMapper(private val cs: ColumnList): Mapper<Values> {
    override fun map(rs: Row) = Values(cs.columns.mapIndexed { idx, col -> rs[idx, col] })
}

data class Results(override val columns: ColumnList, override val values: List<Values>): SelectResult<Values>
