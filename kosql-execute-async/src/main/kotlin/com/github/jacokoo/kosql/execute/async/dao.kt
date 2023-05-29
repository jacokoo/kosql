package com.github.jacokoo.kosql.execute.async

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Order
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.expression.Count
import com.github.jacokoo.kosql.compose.expression.Exp
import com.github.jacokoo.kosql.compose.expression.Operator
import com.github.jacokoo.kosql.compose.statement.*
import com.github.jacokoo.kosql.compose.typesafe.Column1

interface Dao: Executor, Operator {
    suspend fun <T> Entity<T>.save(): T {
        val table = innerTable()
        val key = table.primaryKey()
        val columns = table.columns.filter { !it.autoIncrement || this[it.name] != it.type.nullValue }

        val values = Values(columns.map { this[it.name] })
        val id = execute(InsertEnd(InsertData(table, Columns(columns), listOf(values))))

        if (key.autoIncrement) this[key.name] = id
        return id
    }

    suspend fun <T, E: Entity<T>> List<E>.save(useManualId: Boolean = false): List<E> {
        assert(isNotEmpty())

        val table = first().innerTable()
        var columns = table.columns
        val key = table.primaryKey()
        if (!useManualId && key.autoIncrement) columns = columns.filter { it != key }
        val values = map { e -> Values(columns.map { e[it.name] }) }
        val ids = execute(BatchInsertEnd(InsertData(table, Columns(columns), values, null, true)))

        assert(size == ids.size)
        if (!useManualId && key.autoIncrement) {
            forEachIndexed { i, it -> it[key.name] = ids[i] }
        }
        return this
    }

    suspend fun <T, E: Entity<T>, R: Table<T, E>> R.byId(t: T): E?
            = execute(SelectEnd(SelectData(Columns(inner.columns), this, expression = primaryKey() EQ t)), this).firstOrNull()

    suspend fun <T, R: Table<T, Entity<T>>> R.count(exp: Exp<*>? = null): Int
            = SelectEnd(SelectData(Column1(Count<Any>()), this, expression = exp)).fetchValue()

    suspend fun <T, E: Entity<T>, R: Table<T, E>> R.fetch(exp: Exp<*>? = null, vararg orders: Pair<Column<*>, Order>): List<E>
            = execute(SelectEnd(SelectData(Columns(inner.columns), this, expression = exp, orderBy = orders.toList())), this)

    suspend fun <T, R: Table<T, Entity<T>>> R.delete(t: T): Boolean =
        execute(DeleteEnd(DeleteData(deletes = listOf(this), expression = primaryKey() EQ t))) == 1

    suspend fun <T, R: Table<T, Entity<T>>> R.delete(exp: Exp<*>? = null): Int =
        execute(DeleteEnd(DeleteData(deletes = listOf(this), expression = exp)))

}
