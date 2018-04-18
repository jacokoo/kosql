package com.github.jacokoo.demo

import com.github.jacokoo.demo.entity.Country
import com.github.jacokoo.ksql.Table

open class CountryTable protected constructor(alias: String = ""): Table("country", alias) {
    val ID = int("country_id")
    val NAME = string("country")

    fun As(alias: String): CountryTable = CountryTable(alias)
    fun create(): Country = Country()
}

object COUNTRY: CountryTable()