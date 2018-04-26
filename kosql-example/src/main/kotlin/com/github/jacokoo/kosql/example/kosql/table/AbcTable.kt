package com.github.jacokoo.kosql.example.kosql.table

import com.github.jacokoo.kosql.BooleanType
import com.github.jacokoo.kosql.ByteArrayType
import com.github.jacokoo.kosql.IntType
import com.github.jacokoo.kosql.LongType
import com.github.jacokoo.kosql.StringType
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.example.Color
import com.github.jacokoo.kosql.example.State
import com.github.jacokoo.kosql.example.kosql.AbcTableColorEnumType
import com.github.jacokoo.kosql.example.kosql.AbcTableStateEnumType
import com.github.jacokoo.kosql.statements.Column9

open class AbcTable protected constructor(alias: String = ""): Table<Int>("t_abc", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0).autoIncrement()
    val A = createColumn("f_a", IntType(), true, null)
    val COLOR = createColumn("f_color", AbcTableColorEnumType(), false, Color.RED)
    val STATE = createColumn("f_state", AbcTableStateEnumType(), false, State.INIT)
    val BOOL1 = createColumn("f_bool1", BooleanType(), false, false)
    val BOOL2 = createColumn("f_bool2", BooleanType(), false, false)
    val BIT1 = createColumn("f_bit1", LongType(), false, 12L)
    val BIT2 = createColumn("f_bit2", ByteArrayType(), false, ByteArray(0))
    val TEXT = createColumn("f_text", StringType(), true, null)

    override fun AS(alias: String) = AbcTable(alias)
    override fun primaryKey() = ID
    operator fun invoke() = Column9(ID, A, COLOR, STATE, BOOL1, BOOL2, BIT1, BIT2, TEXT)
}

object ABC: AbcTable()
