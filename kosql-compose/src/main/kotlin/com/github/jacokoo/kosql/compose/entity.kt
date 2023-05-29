package com.github.jacokoo.kosql.compose

import kotlin.reflect.KClass

/**
 * T is the type of primary key
 */
interface Entity<T> {
    /**
     * set entity field value by column name
     */
    operator fun set(name: String, value: Any?)

    /**
     * get entity field value by column name
     */
    operator fun get(name: String): Any?

    fun innerTable(): InnerTable<T, Entity<T>>
    fun isEntityOf(c: KClass<*>): Boolean = c == innerTable()::class
}

enum class EnumType { INT, STRING }
