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

    fun innerTable(): InnerTable<T, @JvmWildcard Entity<T>>
    fun isEntityOf(c: KClass<*>): Boolean = c == innerTable()::class
}

enum class EnumType { INT, STRING }

annotation class Item<T: Enum<T>>(val column: String, val enum: KClass<T>, val defaultIndex: Int = 0, val type: EnumType = EnumType.INT)

annotation class UseEnum(val value: Array<Item<*>>)
