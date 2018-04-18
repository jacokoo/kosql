package com.github.jacokoo.demo.entity

import com.github.jacokoo.demo.USER
import com.github.jacokoo.demo.UserTable
import com.github.jacokoo.ksql.Entity


open class User: Entity<UserTable> {
    override val TABLE: UserTable = USER
    var id: Int = 0
    var name: String = ""
    var groupId: Int = 0

    override operator fun set(name: String, value: Any) {
        when (name) {
            USER.ID.name -> this.id = value as Int
            USER.NAME.name -> this.name = value as String
            USER.GROUP_ID.name -> this.groupId = value as Int
        }
    }

    override fun get(name: String): Any? = when(name) {
        USER.ID.name -> this.id
        USER.NAME.name -> this.name
        USER.GROUP_ID.name -> this.groupId
        else -> throw RuntimeException("no column $name")
    }
}
