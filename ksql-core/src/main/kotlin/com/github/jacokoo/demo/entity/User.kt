package com.github.jacokoo.demo.entity

import com.github.jacokoo.demo.CITY
import com.github.jacokoo.demo.CityTable
import com.github.jacokoo.ksql.Entity


open class City: Entity<CityTable> {
    override val TABLE: CityTable = CITY
    var id: Int = 0
    var name: String = ""
    var countryId: Int = 0

    override operator fun set(name: String, value: Any) {
        when (name) {
            CITY.ID.name -> this.id = value as Int
            CITY.NAME.name -> this.name = value as String
            CITY.COUNTRY_ID.name -> this.countryId = value as Int
        }
    }

    override fun get(name: String): Any? = when(name) {
        CITY.ID.name -> this.id
        CITY.NAME.name -> this.name
        CITY.COUNTRY_ID.name -> this.countryId
        else -> throw RuntimeException("no column $name")
    }
}
