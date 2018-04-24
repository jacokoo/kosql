package com.github.jacokoo.kosql.example.kosql.entity

import com.github.jacokoo.kosql.example.kosql.table.ABC
import com.github.jacokoo.kosql.example.kosql.table.AbcTable
import com.github.jacokoo.kosql.mapping.Entity

open class Abc: Entity<Int, AbcTable> {
    var id: Int = 0
    var a: Int? = null

    override fun get(name: String): Any? = when(name) {
        ABC.ID.name -> this.id
        ABC.A.name -> this.a
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            ABC.ID.name -> this.id = value as Int
            ABC.A.name -> this.a = value as Int
        }
    }

}

