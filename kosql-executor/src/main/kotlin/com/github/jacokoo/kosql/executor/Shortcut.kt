package com.github.jacokoo.kosql.executor

import com.github.jacokoo.kosql.compose.Database
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.statements.*
import com.github.jacokoo.kosql.compose.typesafe.Columns

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

    fun <T, R: Table<T>> R.byId(t: T): Entity<T, Table<T>>? {
        val entity = Database[this]!!
        val exp = this.primaryKey() EQ t
        val part = SelectEnd(SelectData(Columns(this.columns), this, expression = exp))
        return execute(part, ColumnsToEntityMapper(part.data.columns, entity)).firstOrNull()
    }
}
