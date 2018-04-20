package com.github.jacokoo.kosql.statements

import com.github.jacokoo.kosql.Column
import com.github.jacokoo.kosql.Statement
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.mapping.Entity

data class InsertData(
        val table: Table<*>,
        val columns: List<Column<*>>,
        val values: List<List<Any>> = listOf(),
        val query: QueryPart? = null
)

interface InsertPart: Statement {
    val data: InsertData
}

internal fun append(data: InsertData, vararg cs: Any): InsertData {
    return data.copy(values = data.values + listOf(cs.toList()))
}

data class InsertEnd(override val data: InsertData): InsertPart
data class Entities(val entities: List<Entity<*, *>>)
interface ExtraValues {
    val data: InsertData
    infix fun VALUES(e: Entities): InsertEnd {
        val es = e.entities.filter { it.TABLE != data.table }
        if (!es.none()) throw RuntimeException("There have entities not match table")
        val values = e.entities.map { ee -> data.columns.map { it.type.toDb(ee[it.name]) } }
        return InsertEnd(data.copy(values = values))
    }

    infix fun FROM(q: QueryPart): InsertEnd = InsertEnd(data.copy(query = q))
}

data class Fields(val table: Table<*>, val columns: List<Column<*>>): ExtraValues {
    override val data: InsertData = InsertData(table, columns, listOf())
    infix fun VALUES(v: Values): ValuesRepeatPart = ValuesRepeatPart(append(data, *v.values.toTypedArray()))
}

data class Values(val values: List<Any>)
data class ValuesRepeatPart(override val data: InsertData): InsertPart {
    infix fun AND(v: Values): ValuesRepeatPart = ValuesRepeatPart(append(data, *v.values.toTypedArray()))
}

interface Insert {
    object INSERT {
        infix fun <T> INTO(t: T): T = t
        operator fun <T: Any, R: Table<T>> invoke(vararg entities: Entity<T, R>): InsertEnd {
            if (entities.isEmpty()) throw RuntimeException("You have to supply at least one entity")
            val table = entities[0].TABLE
            val columns = table.columns
            val values = entities.map { e -> columns.map { it.type.toDb(e[it.name]) } }
            return InsertEnd(InsertData(table, columns, values))
        }
    }

    fun V(vararg v: Any): Values = Values(v.toList())
    fun <T: Any, R: Table<T>> E(vararg e: Entity<T, R>): Entities = Entities(e.toList())
    operator fun Table<*>.invoke(vararg columns: Column<*>): Fields = Fields(this, columns.toList())

}
