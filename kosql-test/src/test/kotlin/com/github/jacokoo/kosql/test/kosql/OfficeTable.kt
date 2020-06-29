package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.StringNullType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column9
import com.github.jacokoo.kosql.test.entity.Office


open class OfficeBase(): Entity<Int> {
    var id: Int = 0
    var city: String = ""
    var phone: String = ""
    var addressLine1: String = ""
    var addressLine2: String = ""
    var state: String = ""
    var country: String = ""
    var postalCode: String = ""
    var territory: String = ""

    constructor(other: OfficeBase): this() {
        this.id = other.id
        this.city = other.city
        this.phone = other.phone
        this.addressLine1 = other.addressLine1
        this.addressLine2 = other.addressLine2
        this.state = other.state
        this.country = other.country
        this.postalCode = other.postalCode
        this.territory = other.territory
    }

    override fun get(name: String): Any? = when(name) {
        OFFICE.ID.name -> this.id
        OFFICE.CITY.name -> this.city
        OFFICE.PHONE.name -> this.phone
        OFFICE.ADDRESS_LINE1.name -> this.addressLine1
        OFFICE.ADDRESS_LINE2.name -> this.addressLine2
        OFFICE.STATE.name -> this.state
        OFFICE.COUNTRY.name -> this.country
        OFFICE.POSTAL_CODE.name -> this.postalCode
        OFFICE.TERRITORY.name -> this.territory
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            OFFICE.ID.name -> this.id = value as Int
            OFFICE.CITY.name -> this.city = value as String
            OFFICE.PHONE.name -> this.phone = value as String
            OFFICE.ADDRESS_LINE1.name -> this.addressLine1 = value as String
            OFFICE.ADDRESS_LINE2.name -> this.addressLine2 = value as String
            OFFICE.STATE.name -> this.state = value as String
            OFFICE.COUNTRY.name -> this.country = value as String
            OFFICE.POSTAL_CODE.name -> this.postalCode = value as String
            OFFICE.TERRITORY.name -> this.territory = value as String
        }
    }

    override fun toString(): String = buildString {
        append("OfficeBase (")
        append("id = $id, city = $city, phone = $phone, addressLine1 = $addressLine1, addressLine2 = $addressLine2, state = $state, country = $country, postalCode = $postalCode, territory = $territory")
        append(")")
    }

}


open class OfficeTable protected constructor(alias: String = ""): Table<Int, Office>("t_office", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0, autoIncrement = true)
    val CITY = createColumn("f_city", StringType(), false, "")
    val PHONE = createColumn("f_phone", StringType(), false, "")
    val ADDRESS_LINE1 = createColumn("f_address_line1", StringType(), false, "")
    val ADDRESS_LINE2 = createColumn("f_address_line2", StringNullType(), true, "")
    val STATE = createColumn("f_state", StringNullType(), true, "")
    val COUNTRY = createColumn("f_country", StringType(), false, "")
    val POSTAL_CODE = createColumn("f_postal_code", StringType(), false, "")
    val TERRITORY = createColumn("f_territory", StringType(), false, "")

    override fun AS(alias: String) = OfficeTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column9(ID, CITY, PHONE, ADDRESS_LINE1, ADDRESS_LINE2, STATE, COUNTRY, POSTAL_CODE, TERRITORY)
}

object OFFICE: OfficeTable()
