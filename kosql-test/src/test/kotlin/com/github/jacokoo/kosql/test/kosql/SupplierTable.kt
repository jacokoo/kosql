package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column8
import com.github.jacokoo.kosql.test.entity.Supplier


open class SupplierBase(): Entity<Int> {
    var id: Int = 0
    var companyName: String = ""
    var contactName: String? = null
    var contactTitle: String? = null
    var city: String? = null
    var country: String? = null
    var phone: String? = null
    var fax: String? = null

    constructor(other: SupplierBase): this() {
        this.id = other.id
        this.companyName = other.companyName
        this.contactName = other.contactName
        this.contactTitle = other.contactTitle
        this.city = other.city
        this.country = other.country
        this.phone = other.phone
        this.fax = other.fax
    }

    override fun get(name: String): Any? = when(name) {
        SUPPLIER.ID.name -> this.id
        SUPPLIER.COMPANY_NAME.name -> this.companyName
        SUPPLIER.CONTACT_NAME.name -> this.contactName
        SUPPLIER.CONTACT_TITLE.name -> this.contactTitle
        SUPPLIER.CITY.name -> this.city
        SUPPLIER.COUNTRY.name -> this.country
        SUPPLIER.PHONE.name -> this.phone
        SUPPLIER.FAX.name -> this.fax
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            SUPPLIER.ID.name -> this.id = value as Int
            SUPPLIER.COMPANY_NAME.name -> this.companyName = value as String
            SUPPLIER.CONTACT_NAME.name -> this.contactName = value as String
            SUPPLIER.CONTACT_TITLE.name -> this.contactTitle = value as String
            SUPPLIER.CITY.name -> this.city = value as String
            SUPPLIER.COUNTRY.name -> this.country = value as String
            SUPPLIER.PHONE.name -> this.phone = value as String
            SUPPLIER.FAX.name -> this.fax = value as String
        }
    }

    override fun toString(): String = buildString {
        append("SupplierBase (")
        append("id = $id, companyName = $companyName, contactName = $contactName, contactTitle = $contactTitle, city = $city, country = $country, phone = $phone, fax = $fax")
        append(")")
    }

}


open class SupplierTable protected constructor(alias: String = ""): Table<Int, Supplier>("t_supplier", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0).autoIncrement()
    val COMPANY_NAME = createColumn("f_company_name", StringType(), false, "")
    val CONTACT_NAME = createColumn("f_contact_name", StringType(), true, null)
    val CONTACT_TITLE = createColumn("f_contact_title", StringType(), true, null)
    val CITY = createColumn("f_city", StringType(), true, null)
    val COUNTRY = createColumn("f_country", StringType(), true, null)
    val PHONE = createColumn("f_phone", StringType(), true, null)
    val FAX = createColumn("f_fax", StringType(), true, null)

    override fun AS(alias: String) = SupplierTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column8(ID, COMPANY_NAME, CONTACT_NAME, CONTACT_TITLE, CITY, COUNTRY, PHONE, FAX)
}

object SUPPLIER: SupplierTable()
