package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.DecimalNullType
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntNullType
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.StringNullType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Columns
import com.github.jacokoo.kosql.test.entity.Customer
import java.math.BigDecimal


open class CustomerBase(): Entity<Int> {
    var id: Int = 0
    var name: String = ""
    var contactLastName: String = ""
    var contactFirstName: String = ""
    var phone: String = ""
    var addressLine1: String = ""
    var addressLine2: String = ""
    var city: String = ""
    var state: String = ""
    var postalCode: String = ""
    var country: String = ""
    var employeeId: Int = 0
    var creditLimit: BigDecimal = BigDecimal("0")

    constructor(other: CustomerBase): this() {
        this.id = other.id
        this.name = other.name
        this.contactLastName = other.contactLastName
        this.contactFirstName = other.contactFirstName
        this.phone = other.phone
        this.addressLine1 = other.addressLine1
        this.addressLine2 = other.addressLine2
        this.city = other.city
        this.state = other.state
        this.postalCode = other.postalCode
        this.country = other.country
        this.employeeId = other.employeeId
        this.creditLimit = other.creditLimit
    }

    override fun get(name: String): Any? = when(name) {
        CUSTOMER.ID.name -> this.id
        CUSTOMER.NAME.name -> this.name
        CUSTOMER.CONTACT_LAST_NAME.name -> this.contactLastName
        CUSTOMER.CONTACT_FIRST_NAME.name -> this.contactFirstName
        CUSTOMER.PHONE.name -> this.phone
        CUSTOMER.ADDRESS_LINE1.name -> this.addressLine1
        CUSTOMER.ADDRESS_LINE2.name -> this.addressLine2
        CUSTOMER.CITY.name -> this.city
        CUSTOMER.STATE.name -> this.state
        CUSTOMER.POSTAL_CODE.name -> this.postalCode
        CUSTOMER.COUNTRY.name -> this.country
        CUSTOMER.EMPLOYEE_ID.name -> this.employeeId
        CUSTOMER.CREDIT_LIMIT.name -> this.creditLimit
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            CUSTOMER.ID.name -> this.id = value as Int
            CUSTOMER.NAME.name -> this.name = value as String
            CUSTOMER.CONTACT_LAST_NAME.name -> this.contactLastName = value as String
            CUSTOMER.CONTACT_FIRST_NAME.name -> this.contactFirstName = value as String
            CUSTOMER.PHONE.name -> this.phone = value as String
            CUSTOMER.ADDRESS_LINE1.name -> this.addressLine1 = value as String
            CUSTOMER.ADDRESS_LINE2.name -> this.addressLine2 = value as String
            CUSTOMER.CITY.name -> this.city = value as String
            CUSTOMER.STATE.name -> this.state = value as String
            CUSTOMER.POSTAL_CODE.name -> this.postalCode = value as String
            CUSTOMER.COUNTRY.name -> this.country = value as String
            CUSTOMER.EMPLOYEE_ID.name -> this.employeeId = value as Int
            CUSTOMER.CREDIT_LIMIT.name -> this.creditLimit = value as BigDecimal
        }
    }

    override fun toString(): String = buildString {
        append("CustomerBase (")
        append("id = $id, name = $name, contactLastName = $contactLastName, contactFirstName = $contactFirstName, phone = $phone, addressLine1 = $addressLine1, addressLine2 = $addressLine2, city = $city, state = $state, postalCode = $postalCode, country = $country, employeeId = $employeeId, creditLimit = $creditLimit")
        append(")")
    }

}


open class CustomerTable protected constructor(alias: String = ""): Table<Int, Customer>("t_customer", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0, autoIncrement = true)
    val NAME = createColumn("f_name", StringType(), false, "")
    val CONTACT_LAST_NAME = createColumn("f_contact_last_name", StringType(), false, "")
    val CONTACT_FIRST_NAME = createColumn("f_contact_first_name", StringType(), false, "")
    val PHONE = createColumn("f_phone", StringType(), false, "")
    val ADDRESS_LINE1 = createColumn("f_address_line1", StringType(), false, "")
    val ADDRESS_LINE2 = createColumn("f_address_line2", StringNullType(), true, "")
    val CITY = createColumn("f_city", StringType(), false, "")
    val STATE = createColumn("f_state", StringNullType(), true, "")
    val POSTAL_CODE = createColumn("f_postal_code", StringNullType(), true, "")
    val COUNTRY = createColumn("f_country", StringType(), false, "")
    val EMPLOYEE_ID = createColumn("f_employee_id", IntNullType(), true, 0)
    val CREDIT_LIMIT = createColumn("f_credit_limit", DecimalNullType(), true, BigDecimal("0"))

    override fun AS(alias: String) = CustomerTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Columns(ID, NAME, CONTACT_LAST_NAME, CONTACT_FIRST_NAME, PHONE, ADDRESS_LINE1, ADDRESS_LINE2, CITY, STATE, POSTAL_CODE, COUNTRY, EMPLOYEE_ID, CREDIT_LIMIT)
}

object CUSTOMER: CustomerTable()
