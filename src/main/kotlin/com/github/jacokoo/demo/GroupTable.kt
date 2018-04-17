package com.github.jacokoo.demo

import com.github.jacokoo.ksql.Entity
import com.github.jacokoo.ksql.Table

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

open class GroupTable protected constructor(alias: String = ""): Table("t_group", alias) {
    val ID = int("f_id")
    val NAME = string("f_name").nullable()

    fun As(alias: String): GroupTable = GroupTable(alias)
    fun create(): Group = Group()
}

object GROUP: GroupTable()