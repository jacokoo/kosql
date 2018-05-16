package com.github.jacokoo.kosql.example.kosql.entity

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.example.kosql.table.CUSTOMER
import com.github.jacokoo.kosql.example.kosql.table.CustomerTable

open class Customer: Entity<Int, CustomerTable> {
    var id: Int = 0
    var firstName: String = ""
    var lastName: String = ""
    var city: String? = null
    var country: String? = null
    var phone: String? = null

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

    fun copy(block: (Customer) -> Unit): Customer = Customer().also {
        it.id = id
        it.firstName = firstName
        it.lastName = lastName
        it.city = city
        it.country = country
        it.phone = phone
        block(it)
    }

    override fun toString(): String = buildString {
        append("Customer (")
        append("id = $id, firstName = $firstName, lastName = $lastName, city = $city, country = $country, phone = $phone")
        append(")")
    }}

