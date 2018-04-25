package com.github.jacokoo.kosql.example.kosql.table

import com.github.jacokoo.kosql.IntType
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.example.Color
import com.github.jacokoo.kosql.example.State
import com.github.jacokoo.kosql.example.kosql.AbcTableColorEnumType
import com.github.jacokoo.kosql.example.kosql.AbcTableStateEnumType
import com.github.jacokoo.kosql.statements.Column4

open class AbcTable protected constructor(alias: String = ""): Table<Int>("t_abc", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0)
    val A = createColumn("f_a", IntType(), true, null)
    val COLOR = createColumn("f_color", AbcTableColorEnumType(), false, Color.RED)
    val STATE = createColumn("f_state", AbcTableStateEnumType(), false, State.INIT)

    override fun AS(alias: String) = AbcTable(alias)
    override fun primaryKey() = ID
    operator fun invoke() = Column4(ID, A, COLOR, STATE)
}

object ABC: AbcTable()
