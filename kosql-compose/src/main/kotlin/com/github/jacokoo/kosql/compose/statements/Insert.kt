package com.github.jacokoo.kosql.compose.statements

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import com.github.jacokoo.kosql.compose.typesafe.Columns
import com.github.jacokoo.kosql.compose.typesafe.ValueList
import com.github.jacokoo.kosql.compose.typesafe.Values

data class InsertData<T>(
    val table: Table<T, Entity<T>>,
    val columns: ColumnList,
    val values: List<ValueList> = listOf(),
    val query: SelectStatement<*>? = null
)

interface InsertStatement<T>: Statement {
    val data: InsertData<T>
}

interface BatchInsertStatement<T>: InsertStatement<T>

data class InsertEnd<T>(override val data: InsertData<T>): InsertStatement<T>
data class Entities<T: Entity<*>>(val entities: List<T>)
interface ExtraValues<T> {
    val data: InsertData<T>

    infix fun VALUES(e: Entities<Entity<T>>): BatchInsertEnd<T> {
        assert(e.entities.all { Database.getTableClass(it::class) == data.table::class });
        val values = e.entities.map { ee -> Values(data.columns.columns.map { ee[it.name] }) }
        return BatchInsertEnd(data.copy(values = values))
    }

    infix fun FROM(q: SelectStatement<*>): InsertEnd<T> = InsertEnd(data.copy(query = q))
}

data class Fields<T>(val table: Table<T, Entity<T>>, val columns: ColumnList): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, columns, listOf())
    infix fun VALUES(v: Values): ValuesRepeatPart<T> = ValuesRepeatPart(data.copy(values = data.values + v))
}

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

            val table = Database.getTable(entities[0]::class)!!
            var columns = table.columns
            val id = table.primaryKey()
            if (id.autoIncrement) columns = columns.filter { it != id }
            val values = entities.map { e -> Values(columns.map { e[it.name] }) }
            return BatchInsertEnd(InsertData(table, Columns(columns), values))
        }
    }

    fun <T, E: Entity<T>> E(vararg e: E) = Entities(e.toList())
    operator fun<T> Table<T, Entity<T>>.invoke(vararg columns: Column<*>): Fields<T> = Fields(this, Columns(columns.toList()))
}
