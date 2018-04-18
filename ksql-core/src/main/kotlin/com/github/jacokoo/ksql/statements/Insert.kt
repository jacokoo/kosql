package com.github.jacokoo.ksql.statements

import com.github.jacokoo.ksql.Column
import com.github.jacokoo.ksql.Statement
import com.github.jacokoo.ksql.Table
import com.github.jacokoo.ksql.mapping.Entity

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
data class Entities(val entities: List<Entity<*>>)
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

data class Fields(val table: Table<*>, val columns: List<Column<*>>)
data class Values(val values: List<Any>)
data class ValuesRepeatPart(override val data: InsertData): InsertPart {
    infix fun AND(v: Values): ValuesRepeatPart = ValuesRepeatPart(append(data, *v.values.toTypedArray()))
}

data class ValuesPart(override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Values): ValuesRepeatPart = ValuesRepeatPart(append(data, *v.values.toTypedArray()))
}

interface Insert {
    object INSERT {
        infix fun INTO(fields: Fields): ValuesPart = ValuesPart(InsertData(fields.table, fields.columns))
        operator fun invoke(vararg entities: Entity<*>): ValuesPart {
            if (entities.isEmpty()) throw RuntimeException("You have to supply at least one entity")
            val table = entities[0].TABLE
            val columns = table.columns
            val values = entities.map { e -> columns.map { it.type.toDb(e[it.name]) } }
            return ValuesPart(InsertData(table, columns, values))
        }
    }

    fun V(vararg v: Any): Values = Values(v.toList())
    fun <T: Table<*>> E(vararg e: Entity<*>): Entities = Entities(e.toList())
    operator fun Table<*>.invoke(vararg columns: Column<*>): Fields = Fields(this, columns.toList())

}
