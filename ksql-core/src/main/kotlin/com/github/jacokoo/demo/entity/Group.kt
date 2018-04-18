package com.github.jacokoo.demo.entity

import com.github.jacokoo.demo.COUNTRY
import com.github.jacokoo.demo.CountryTable
import com.github.jacokoo.ksql.Entity


open class Country(): Entity<CountryTable> {
    override val TABLE: CountryTable = COUNTRY
    var id: Int = 0
    var name: String = ""

    override operator fun set(name: String, value: Any) {
        when (name) {
            COUNTRY.ID.name -> this.id = value as Int
            COUNTRY.NAME.name -> this.name = value as String
        }
    }

    override fun get(name: String): Any? = when(name) {
        COUNTRY.ID.name -> this.id
        COUNTRY.NAME.name -> this.name
        else -> throw RuntimeException("no column $name")
    }
}
