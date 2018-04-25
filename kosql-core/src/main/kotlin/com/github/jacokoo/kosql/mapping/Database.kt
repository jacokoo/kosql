package com.github.jacokoo.kosql.mapping

import com.github.jacokoo.kosql.Table
import kotlin.reflect.KClass

interface Database {

    @Suppress("UNCHECKED_CAST")
    companion object {
        private var entityToTable: MutableMap<in KClass<out Entity<*, Table<*>>>, Table<out Any>> = mutableMapOf()
        private var tableToEntity: MutableMap<in Table<out Any>, KClass<out Entity<*, Table<*>>>> = mutableMapOf()

        fun <T: Any> register(table: Table<out T>, entity: KClass<out Entity<T, Table<T>>>) {
            tableToEntity[table] = entity
            entityToTable[entity] = table
        }

        operator fun <T> get(table: Table<T>): KClass<out Entity<T, Table<T>>>? = tableToEntity[table] as KClass<out Entity<T, Table<T>>>
        operator fun <T> get(entity: KClass<out Entity<T, Table<T>>>): Table<T>? = entityToTable[entity] as Table<T>
    }
}