package com.github.jacokoo.demo

import com.github.jacokoo.demo.entity.City
import com.github.jacokoo.ksql.Table

open class CityTable protected constructor(alias: String = ""): Table("city", alias) {
    val ID = int("city_id")
    val NAME = string("city")
    val COUNTRY_ID = int("country_id").default(1)

    fun As(alias: String): CityTable = CityTable(alias)
    fun create(): City = City()
}

object CITY: CityTable()