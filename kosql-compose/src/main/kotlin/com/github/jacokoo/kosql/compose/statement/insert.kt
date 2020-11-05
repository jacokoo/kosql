package com.github.jacokoo.kosql.compose.statement

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.InnerTable
import com.github.jacokoo.kosql.compose.Table

interface ValueList {
    val values: List<Any?>
    operator fun get(idx: Int): Any? = values[idx]
}

data class Values(override val values: List<Any?>): ValueList

data class Fields<T>(val table: Table<T, Entity<T>>, val columns: ColumnList): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table.inner, columns, listOf())
    infix fun VALUES(v: Values): ValuesRepeatPart<T> = ValuesRepeatPart(data.copy(values = data.values + v))
}

interface ExtraValues<T> {
    val data: InsertData<T>
    infix fun FROM(q: SelectStatement<*>): InsertEnd<T> = InsertEnd(data.copy(query = q))
}

data class InsertData<T>(
    val table: InnerTable<T, Entity<T>>,
    val columns: ColumnList,
    val values: List<ValueList> = listOf(),
    val query: SelectStatement<*>? = null
)

interface InsertStatement<T>: Statement {
    val data: InsertData<T>
}

interface BatchInsertStatement<T>: InsertStatement<T>

data class InsertEnd<T>(override val data: InsertData<T>): InsertStatement<T>

data class ValuesRepeatPart<T>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Values): BatchValuesRepeatPart<T> = BatchValuesRepeatPart(data.copy(values = data.values + v))
}

data class BatchValuesRepeatPart<T>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Values): BatchValuesRepeatPart<T> = BatchValuesRepeatPart(data.copy(values = data.values + v))
}
data class BatchInsertEnd<T>(override val data: InsertData<T>): BatchInsertStatement<T>

interface Insert {
    object INSERT {
        infix fun <T> INTO(t: T): T = t
        operator fun <T, E: Entity<T>> invoke(vararg entities: E): BatchInsertEnd<T> {
            assert(entities.isNotEmpty());
            assert(entities.all { it::class == entities[0]::class })

            val table = entities[0].innerTable()
            var columns = table.columns
            val id = table.primaryKey()
            if (id.autoIncrement) columns = columns.filter { it != id }
            val values = entities.map { e -> Values(columns.map { e[it.name] }) }
            return BatchInsertEnd(InsertData(table, Columns(columns), values))
        }
    }

    operator fun<T> Table<T, Entity<T>>.invoke(vararg columns: Column<*>): Fields<T> = Fields(this, Columns(columns.toList()))
}
