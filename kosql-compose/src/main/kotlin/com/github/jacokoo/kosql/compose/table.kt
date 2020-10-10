package com.github.jacokoo.kosql.compose

import com.github.jacokoo.kosql.compose.type.DataType

interface As<out T> {
    infix fun AS(alias: String): T
}

interface Named<out T>: As<T> {
    val name: String
    val alias: String
    val aliasRequired: Boolean
}

abstract class InnerTable<T, out R: Entity<T>>(
    override val name: String,
    override val alias: String = ""
): Named<InnerTable<T, R>> {
    override val aliasRequired: Boolean = true
    private lateinit var key: Column<T>

    var columns: List<Column<*>> = listOf()
        protected set

    fun createPrimaryKey(
        name: String, type: DataType<T>, autoIncrement: Boolean = false
    ): Column<T> = createColumn(name, type, false, null, autoIncrement).also {
        key = it
    }

    fun <D> createColumn(
        name: String, type: DataType<D>,
        allowNull: Boolean = false, defaultValue: D? = null,
        autoIncrement: Boolean = false
    ): Column<D> = DefaultColumn(
        this, name, type,
        allowNull = allowNull,
        defaultValue = defaultValue ?: type.nullValue,
        autoIncrement = autoIncrement
    ).also { columns += it }

    fun primaryKey(): Column<T> = key
}

interface Table<T, out R: Entity<T>>: As<Table<T, R>> {
    val inner: InnerTable<T, R>
    fun createEntity(): R
    fun primaryKey(): Column<T>
}

open class EmptyInnerTable(alias: String = ""): InnerTable<Any, Entity<Any>>(alias, alias) {
    override fun AS(alias: String): EmptyInnerTable {
        throw RuntimeException("Never call AS method of an empty table.")
    }
}

