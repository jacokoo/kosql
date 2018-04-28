package com.github.jacokoo.kosql.mapping

import com.github.jacokoo.kosql.statements.Operators
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.statements.*
import com.github.jacokoo.kosql.typesafe.Columns

interface Shortcuts: Operators {

    fun <T> executeInsert(statement: InsertStatement<T>): Pair<T, Int>
    fun <T> execute(qp: SelectStatement, mapper: ResultSetMapper<T>): List<T>

    fun <R, T: Entity<R, Table<R>>> T.save(): Boolean {
        val table = Database[this::class]!!
        val values = table.columns.map { it.type.toDb(this[it.name]) }
        val part = InsertEnd(InsertData(table, Columns(table.columns), listOf(values)))
        val (id, rows) = executeInsert(part)
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