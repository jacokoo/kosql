package com.github.jacokoo.kosql.mapping

import com.github.jacokoo.kosql.EmptyTable
import com.github.jacokoo.kosql.Table

interface Entity<T: Any, out R: Table<T>> {
    val TABLE: R
    operator fun set(name: String, value: Any)
    operator fun get(name: String): Any?
}

class EmptyEntity: Entity<Any, EmptyTable> {
    override val TABLE = EmptyTable()
    override fun get(name: String): Any? = null
    override fun set(name: String, value: Any) {}
}