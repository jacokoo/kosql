package com.github.jacokoo.kosql.executor

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.statements.*
import com.github.jacokoo.kosql.compose.typesafe.Column1
import com.github.jacokoo.kosql.compose.typesafe.Columns
import com.github.jacokoo.kosql.compose.typesafe.SelectStatement1
import com.github.jacokoo.kosql.executor.typesafe.SelectResultMapper1

interface Shortcut: Query, Operators {
    fun <R, T: Entity<R, Table<R>>> T.save(): Boolean {
        val table = Database[this::class]!!
        val values = table.columns.map { it.type.toDb(this[it.name]) }
        val part = InsertEnd(InsertData(table, Columns(table.columns), listOf(values)))
        val (id, rows) = execute(part)
        if (rows != 1) return false

        if (table.primaryKey().autoIncrement) this[table.primaryKey().name] = id
        return true
    }

    @Suppress("UNCHECKED_CAST")
    fun <R, T: Entity<R, Table<R>>> T.update(): Int {
        val table = Database[this::class]!!
        val exp = table.primaryKey() EQ this[table.primaryKey().name]!! as R;
        val values = table.columns.filter { it != table.primaryKey() }.associate { it to this[it.name] }
        return execute(UpdateEnd(UpdateData(table, pairs = values, expression = exp)));
    }

    fun <T, R: Table<T>> R.byId(t: T): Entity<T, Table<T>>? {
        val entity = Database[this]!!
        val exp = this.primaryKey() EQ t
        val part = SelectEnd(SelectData(Columns(this.columns), this, expression = exp))
        return execute(part, ColumnsToEntityMapper(part.data.columns, entity)).firstOrNull()
    }

    fun <T, R: Table<T>> R.count(): Int = count(Expression.TRUE)

    fun <T, R: Table<T>> R.count(exp: Expression<Any>): Int {
        val col = Column1(Count<Any>())
        return execute(SelectStatement1(col, SelectData(col, this, expression = exp)), SelectResultMapper1(col)).firstOrNull()!!.v1;
    }

    fun <T, R: Table<T>> R.fetch(exp: Expression<*>, vararg orders: Pair<Column<*>, Order>): List<Entity<T, Table<T>>> {
        val entity = Database[this]!!
        val part = SelectEnd(SelectData(Columns(this.columns), this, expression = exp, orderBy = orders.toList()))
        return execute(part, ColumnsToEntityMapper(part.data.columns, entity));
    }

    fun <T, R: Table<T>> R.delete(t: T): Boolean =
        execute(DeleteEnd(DeleteData(table = this, expression = this.primaryKey() EQ t))) == 1

    fun <T, R: Table<T>> R.delete(exp: Expression<*>): Boolean =
        execute(DeleteEnd(DeleteData(table = this, expression = exp))) == 1

}