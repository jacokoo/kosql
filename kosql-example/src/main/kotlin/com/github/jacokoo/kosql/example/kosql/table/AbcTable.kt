package com.github.jacokoo.kosql.example.kosql.table

import com.github.jacokoo.kosql.BooleanType
import com.github.jacokoo.kosql.IntType
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.example.Color
import com.github.jacokoo.kosql.example.State
import com.github.jacokoo.kosql.example.kosql.AbcTableColorEnumType
import com.github.jacokoo.kosql.example.kosql.AbcTableStateEnumType
import com.github.jacokoo.kosql.statements.Column6

open class AbcTable protected constructor(alias: String = ""): Table<Int>("t_abc", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0).autoIncrement()
    val A = createColumn("f_a", IntType(), true, null)
    val COLOR = createColumn("f_color", AbcTableColorEnumType(), false, Color.RED)
    val STATE = createColumn("f_state", AbcTableStateEnumType(), false, State.INIT)
    val BOOL1 = createColumn("f_bool1", BooleanType(), true, null)
    val BOOL2 = createColumn("f_bool2", BooleanType(), false, false)

    override fun AS(alias: String) = AbcTable(alias)
    override fun primaryKey() = ID
    operator fun invoke() = Column6(ID, A, COLOR, STATE, BOOL1, BOOL2)
}

object ABC: AbcTable()
