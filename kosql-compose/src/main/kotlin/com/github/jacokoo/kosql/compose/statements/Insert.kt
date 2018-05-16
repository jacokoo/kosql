package com.github.jacokoo.kosql.compose.statements

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import com.github.jacokoo.kosql.compose.typesafe.Columns
import com.github.jacokoo.kosql.compose.typesafe.Value
import com.github.jacokoo.kosql.compose.typesafe.Values
import kotlin.reflect.KClass

data class InsertData<T>(
    val table: Table<T>,
    val columns: ColumnList,
    val values: List<List<Any?>> = listOf(),
    val query: SelectStatement? = null
)

interface InsertStatement<T>: Statement {
    val data: InsertData<T>
}

internal fun <T> append(data: InsertData<T>, vararg cs: Value): InsertData<T> {
    return data.copy(values = data.values + cs.map { it.values })
}

data class InsertEnd<T>(override val data: InsertData<T>): InsertStatement<T>
data class Entities(val entities: List<Entity<*, *>>)
interface ExtraValues<T> {
    val data: InsertData<T>

    @Suppress("UNCHECKED_CAST")
    infix fun VALUES(e: Entities): InsertEnd<T> {
        val es = e.entities.filter { Database[it::class as KClass<out Entity<T, Table<T>>>] != data.table }
        if (!es.none()) throw RuntimeException("There have entities not match table")
        val values = e.entities.map { ee -> data.columns.columns.map { it.type.toDb(ee[it.name]) } }
        return InsertEnd(data.copy(values = values))
    }

    infix fun FROM(q: SelectStatement): InsertEnd<T> = InsertEnd(data.copy(query = q))
}

data class Fields<T>(val table: Table<T>, val columns: ColumnList): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, columns, listOf())
    infix fun VALUES(v: Values): ValuesRepeatPart<T> = ValuesRepeatPart(append(data, v))
}

data class ValuesRepeatPart<T>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Values): ValuesRepeatPart<T> = ValuesRepeatPart(append(data, v))
}

interface Insert {
    object INSERT {
        infix fun <T> INTO(t: T): T = t
        operator fun <T: Any, R: Table<T>> invoke(vararg entities: Entity<T, R>): InsertEnd<T> {
            if (entities.isEmpty()) throw RuntimeException("You have to supply at least one entity")
            val table = Database[entities[0]::class]!!
            val columns = table.columns
            val values = entities.map { e -> columns.map { it.type.toDb(e[it.name]) } }
            return InsertEnd(InsertData(table, Columns(columns), values))
        }
    }

    fun <T: Any, R: Table<T>> E(vararg e: Entity<T, R>): Entities = Entities(e.toList())
    operator fun<T> Table<T>.invoke(vararg columns: Column<*>): Fields<T> = Fields(this, Columns(columns.toList()))
}