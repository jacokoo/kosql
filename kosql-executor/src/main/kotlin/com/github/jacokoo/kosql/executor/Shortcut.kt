package com.github.jacokoo.kosql.executor

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.statements.*
import com.github.jacokoo.kosql.compose.typesafe.Column1
import com.github.jacokoo.kosql.compose.typesafe.Columns
import com.github.jacokoo.kosql.executor.typesafe.SelectResultMapper1
import kotlin.reflect.KClass

interface Shortcut: Query, Operators {
    fun <T> Entity<T>.save(): T? {
        val table = Database[this::class]!!
        val values = table.columns.map { it.type.toDb(this[it.name]) }
        val part = InsertEnd(InsertData(table, Columns(table.columns), listOf(values)))
        val (id, rows) = execute(part)
        if (rows != 1) return null

        if (table.primaryKey().autoIncrement) this[table.primaryKey().name] = id
        return id
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> Entity<T>.update(): Int {
        val table = Database[this::class]!!
        val exp = table.primaryKey() EQ this[table.primaryKey().name]!! as T;
        val values = table.columns.filter { it != table.primaryKey() }.associate { it to this[it.name] }
        return execute(UpdateEnd(UpdateData(table, pairs = values, expression = exp)));
    }

    @Suppress("UNCHECKED_CAST")
    fun <T, E: Entity<T>, R: Table<T, E>> R.byId(t: T): E? {
        val entity = Database[this]!! as KClass<E>
        val exp = this.primaryKey() EQ t
        val part = SelectEnd(SelectData(Columns(this.columns), this, expression = exp))
        return execute(part, ColumnsToEntityMapper(part.data.columns, entity)).firstOrNull()
    }

    fun <T, R: Table<T, Entity<T>>> R.count(): Int = count(null)

    fun <T, R: Table<T, Entity<T>>> R.count(exp: Expression<Any>?): Int {
        val col = Column1(Count<Any>())
        return execute(SelectEnd(SelectData(col, this, expression = exp)), SelectResultMapper1(col)).firstOrNull()!!.v1;
    }

    @Suppress("UNCHECKED_CAST")
    fun <T, E: Entity<T>, R: Table<T, E>> R.fetch(exp: Expression<*>?, vararg orders: Pair<Column<*>, Order>): List<E> {
        val entity = Database[this]!! as KClass<E>
        val part = SelectEnd(SelectData(Columns(this.columns), this, expression = exp, orderBy = orders.toList()))
        return execute(part, ColumnsToEntityMapper(part.data.columns, entity));
    }

    fun <T, R: Table<T, Entity<T>>> R.delete(t: T): Boolean =
        execute(DeleteEnd(DeleteData(table = this, expression = this.primaryKey() EQ t))) == 1

    fun <T, R: Table<T, Entity<T>>> R.delete(exp: Expression<*>?): Boolean =
        execute(DeleteEnd(DeleteData(table = this, expression = exp))) == 1

}
