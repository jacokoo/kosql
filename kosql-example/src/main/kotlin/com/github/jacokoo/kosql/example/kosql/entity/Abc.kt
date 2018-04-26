package com.github.jacokoo.kosql.example.kosql.entity

import com.github.jacokoo.kosql.example.Color
import com.github.jacokoo.kosql.example.State
import com.github.jacokoo.kosql.example.kosql.table.ABC
import com.github.jacokoo.kosql.example.kosql.table.AbcTable
import com.github.jacokoo.kosql.mapping.Entity

open class Abc: Entity<Int, AbcTable> {
    var id: Int = 0
    var a: Int? = null
    var color: Color = Color.RED
    var state: State = State.INIT
    var bool1: Boolean = false
    var bool2: Boolean = false
    var bit1: Long = 12L
    var bit2: ByteArray = ByteArray(0)

    override fun get(name: String): Any? = when(name) {
        ABC.ID.name -> this.id
        ABC.A.name -> this.a
        ABC.COLOR.name -> this.color
        ABC.STATE.name -> this.state
        ABC.BOOL1.name -> this.bool1
        ABC.BOOL2.name -> this.bool2
        ABC.BIT1.name -> this.bit1
        ABC.BIT2.name -> this.bit2
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
            ABC.BIT2.name -> this.bit2 = value as ByteArray
        }
    }

}

