package com.github.jacokoo.kosql.mapping

import com.github.jacokoo.kosql.Table
import kotlin.reflect.KClass

object Database {
    private var entityToTable: MutableMap<KClass<out Entity<*, Table<*>>>, Table<out Any>> = mutableMapOf()
    private var tableToEntity: MutableMap<Table<out Any>, KClass<out Entity<*, Table<*>>>> = mutableMapOf()

    fun <T: Any> register(table: Table<out T>, entity: KClass<out Entity<T, Table<T>>>) {
        tableToEntity[table] = entity
        entityToTable[entity] = table
    }

    operator fun get(table: Table<*>): KClass<out Entity<*, Table<*>>>? = tableToEntity[table]
    operator fun get(entity: KClass<out Entity<*, Table<*>>>): Table<out Any>? = entityToTable[entity]
}