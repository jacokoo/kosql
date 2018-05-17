package com.github.jacokoo.kosql.example.kosql.table

import com.github.jacokoo.kosql.compose.BooleanType
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.LongType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column8
import com.github.jacokoo.kosql.example.Color
import com.github.jacokoo.kosql.example.State
import com.github.jacokoo.kosql.example.kosql.AbcTableColorEnumType
import com.github.jacokoo.kosql.example.kosql.AbcTableStateEnumType
import com.github.jacokoo.kosql.example.kosql.entity.Abc

open class AbcTable protected constructor(alias: String = ""): Table<Int, Abc>("t_abc", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0).autoIncrement()
    val A = createColumn("f_a", IntType(), true, null)
    val COLOR = createColumn("f_color", AbcTableColorEnumType(), false, Color.RED)
    val STATE = createColumn("f_state", AbcTableStateEnumType(), false, State.INIT)
    val BOOL1 = createColumn("f_bool1", BooleanType(), false, false)
    val BOOL2 = createColumn("f_bool2", BooleanType(), false, false)
    val BIT1 = createColumn("f_bit1", LongType(), false, 12L)
    val TEXT = createColumn("f_text", StringType(), true, null)

    override fun AS(alias: String) = AbcTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column8(ID, A, COLOR, STATE, BOOL1, BOOL2, BIT1, TEXT)
}

object ABC: AbcTable()
