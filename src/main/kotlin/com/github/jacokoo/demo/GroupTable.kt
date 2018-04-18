package com.github.jacokoo.demo

import com.github.jacokoo.demo.entity.Group
import com.github.jacokoo.ksql.Table

open class GroupTable protected constructor(alias: String = ""): Table("t_group", alias) {
    val ID = int("f_id")
    val NAME = string("f_name").nullable()

    fun As(alias: String): GroupTable = GroupTable(alias)
    fun create(): Group = Group()
}

object GROUP: GroupTable()