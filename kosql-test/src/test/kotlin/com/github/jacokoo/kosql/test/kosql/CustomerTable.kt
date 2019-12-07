package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column6
import com.github.jacokoo.kosql.test.entity.Customer


open class CustomerBase(): Entity<Int> {
    var id: Int = 0
    var firstName: String = ""
    var lastName: String = ""
    var city: String? = null
    var country: String? = null
    var phone: String? = null

    constructor(other: CustomerBase): this() {
        this.id = other.id
        this.firstName = other.firstName
        this.lastName = other.lastName
        this.city = other.city
        this.country = other.country
        this.phone = other.phone
    }

    override fun get(name: String): Any? = when(name) {
        CUSTOMER.ID.name -> this.id
        CUSTOMER.FIRST_NAME.name -> this.firstName
        CUSTOMER.LAST_NAME.name -> this.lastName
        CUSTOMER.CITY.name -> this.city
        CUSTOMER.COUNTRY.name -> this.country
        CUSTOMER.PHONE.name -> this.phone
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            CUSTOMER.ID.name -> this.id = value as Int
            CUSTOMER.FIRST_NAME.name -> this.firstName = value as String
            CUSTOMER.LAST_NAME.name -> this.lastName = value as String
            CUSTOMER.CITY.name -> this.city = value as String
            CUSTOMER.COUNTRY.name -> this.country = value as String
            CUSTOMER.PHONE.name -> this.phone = value as String
        }
    }

    override fun toString(): String = buildString {
        append("CustomerBase (")
        append("id = $id, firstName = $firstName, lastName = $lastName, city = $city, country = $country, phone = $phone")
        append(")")
    }

}


open class CustomerTable protected constructor(alias: String = ""): Table<Int, Customer>("t_customer", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0, autoIncrement = true)
    val FIRST_NAME = createColumn("f_first_name", StringType(), false, "")
    val LAST_NAME = createColumn("f_last_name", StringType(), false, "")
    val CITY = createColumn("f_city", StringType(), true, null)
    val COUNTRY = createColumn("f_country", StringType(), true, null)
    val PHONE = createColumn("f_phone", StringType(), true, null)

    override fun AS(alias: String) = CustomerTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column6(ID, FIRST_NAME, LAST_NAME, CITY, COUNTRY, PHONE)
}

object CUSTOMER: CustomerTable()
