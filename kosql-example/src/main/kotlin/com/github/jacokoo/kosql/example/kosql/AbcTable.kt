package com.github.jacokoo.kosql.example.kosql

import com.github.jacokoo.kosql.compose.BooleanType
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntEnumType
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.LongType
import com.github.jacokoo.kosql.compose.StringEnumType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column8
import com.github.jacokoo.kosql.example.Color
import com.github.jacokoo.kosql.example.State
import com.github.jacokoo.kosql.example.entity.Abc

class AbcTableColorEnumType: IntEnumType<Color>() {
    override val clazz: Class<Color> = Color::class.java
    override val nullValue: Color = Color.RED
}

class AbcTableStateEnumType: StringEnumType<State>() {
    override val clazz: Class<State> = State::class.java
    override val nullValue: State = State.INIT
}


open class AbcBase(): Entity<Int> {
    var id: Int = 0
    var a: Int? = null
    var color: Color = Color.RED
    var state: State = State.INIT
    var bool1: Boolean = false
    var bool2: Boolean = false
    var bit1: Long = 12L
    var text: String? = null

    constructor(other: AbcBase): this() {
        this.id = other.id
        this.a = other.a
        this.color = other.color
        this.state = other.state
        this.bool1 = other.bool1
        this.bool2 = other.bool2
        this.bit1 = other.bit1
        this.text = other.text
    }

    override fun get(name: String): Any? = when(name) {
        ABC.ID.name -> this.id
        ABC.A.name -> this.a
        ABC.COLOR.name -> this.color
        ABC.STATE.name -> this.state
        ABC.BOOL1.name -> this.bool1
        ABC.BOOL2.name -> this.bool2
        ABC.BIT1.name -> this.bit1
        ABC.TEXT.name -> this.text
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            ABC.ID.name -> this.id = value as Int
            ABC.A.name -> this.a = value as Int
            ABC.COLOR.name -> this.color = value as Color
            ABC.STATE.name -> this.state = value as State
            ABC.BOOL1.name -> this.bool1 = value as Boolean
            ABC.BOOL2.name -> this.bool2 = value as Boolean
            ABC.BIT1.name -> this.bit1 = value as Long
            ABC.TEXT.name -> this.text = value as String
        }
    }

    override fun toString(): String = buildString {
        append("AbcBase (")
        append("id = $id, a = $a, color = $color, state = $state, bool1 = $bool1, bool2 = $bool2, bit1 = $bit1, text = $text")
        append(")")
    }

}


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
