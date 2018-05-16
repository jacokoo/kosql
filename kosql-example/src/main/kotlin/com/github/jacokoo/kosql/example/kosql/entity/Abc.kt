package com.github.jacokoo.kosql.example.kosql.entity

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.example.Color
import com.github.jacokoo.kosql.example.State
import com.github.jacokoo.kosql.example.kosql.table.ABC
import com.github.jacokoo.kosql.example.kosql.table.AbcTable

open class Abc: Entity<Int, AbcTable> {
    var id: Int = 0
    var a: Int? = null
    var color: Color = Color.RED
    var state: State = State.INIT
    var bool1: Boolean = false
    var bool2: Boolean = false
    var bit1: Long = 12L
    var text: String? = null

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

    fun copy(block: (Abc) -> Unit): Abc = Abc().also {
        it.id = id
        it.a = a
        it.color = color
        it.state = state
        it.bool1 = bool1
        it.bool2 = bool2
        it.bit1 = bit1
        it.text = text
        block(it)
    }

    override fun toString(): String = buildString {
        append("Abc (")
        append("id = $id, a = $a, color = $color, state = $state, bool1 = $bool1, bool2 = $bool2, bit1 = $bit1, text = $text")
        append(")")
    }}

