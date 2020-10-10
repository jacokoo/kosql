package com.github.jacokoo.kosql.compose.statement

import com.github.jacokoo.kosql.compose.*

private class InnerTableLike<T: ColumnList>(val data: SelectData<T>, alias: String, val original: List<Column<*>>): EmptyInnerTable(alias) {
    val map = original.associateWith { DefaultColumn(this, if (it.alias == "") it.name else it.alias, it.type) }
    init {
        this.columns = map.values.toList()
    }
}

class TableLike<T: ColumnList>(data: SelectData<T>, alias: String, original: List<Column<*>>): Table<Any, Entity<Any>> {
    private val table = InnerTableLike(data, alias, original)
    val columns get() = table.columns

    override val inner: InnerTable<Any, Entity<Any>>
        get() = table

    val data: SelectData<T> get() = table.data

    override fun createEntity(): Entity<Any> {
        throw RuntimeException("Never call createEntity method of TableLike")
    }

    override fun primaryKey(): Column<Any> {
        throw RuntimeException("Never call primaryKey method of TableLike")
    }

    override fun AS(alias: String): Table<Any, Entity<Any>> {
        throw RuntimeException("Never call AS method of TableLike")
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T> get(col: Column<T>): Column<T> {
        val c = table.original.find { it.table == col.table && it.name == col.name }
            ?: throw RuntimeException("Can not find column $col.name in table-like ${table.alias}")
        return table.map[c] as Column<T>
    }

    @Suppress("UNCHECKED_CAST")
    inline operator fun <reified T> get(name: String): Column<T> {
        return columns.find { it.name == name }!! as Column<T>
    }
}