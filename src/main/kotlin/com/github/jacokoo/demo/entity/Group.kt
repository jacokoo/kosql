package com.github.jacokoo.demo.entity

import com.github.jacokoo.demo.GROUP
import com.github.jacokoo.demo.GroupTable
import com.github.jacokoo.ksql.Entity


open class Group(): Entity<GroupTable> {
    override val TABLE: GroupTable = GROUP
    var id: Int = 0
    var name: String = ""

    override operator fun set(name: String, value: Any) {
        when (name) {
            GROUP.ID.name -> this.id = value as Int
            GROUP.NAME.name -> this.name = value as String
        }
    }

    override fun get(name: String): Any? = when(name) {
        GROUP.ID.name -> this.id
        GROUP.NAME.name -> this.name
        else -> throw RuntimeException("no column $name")
    }
}
