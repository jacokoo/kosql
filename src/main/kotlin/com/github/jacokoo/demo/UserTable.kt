package com.github.jacokoo.demo

import com.github.jacokoo.ksql.Entity
import com.github.jacokoo.ksql.Table

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

open class UserTable protected constructor(alias: String = ""): Table("t_user", alias) {
    val ID = int("f_id")
    val NAME = string("f_name")
    val GROUP_ID = int("f_group_id").default(1)

    fun As(alias: String): UserTable = UserTable(alias)
    fun create(): User = User()
}

object USER: UserTable()