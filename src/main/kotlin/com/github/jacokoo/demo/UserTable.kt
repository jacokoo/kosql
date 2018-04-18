package com.github.jacokoo.demo

import com.github.jacokoo.demo.entity.User
import com.github.jacokoo.ksql.Table

open class UserTable protected constructor(alias: String = ""): Table("t_user", alias) {
    val ID = int("f_id")
    val NAME = string("f_name")
    val GROUP_ID = int("f_group_id").default(1)

    fun As(alias: String): UserTable = UserTable(alias)
    fun create(): User = User()
}

object USER: UserTable()