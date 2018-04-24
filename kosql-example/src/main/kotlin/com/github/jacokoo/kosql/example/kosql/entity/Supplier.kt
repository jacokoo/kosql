package com.github.jacokoo.kosql.example.kosql.entity

import com.github.jacokoo.kosql.example.kosql.table.SUPPLIER
import com.github.jacokoo.kosql.example.kosql.table.SupplierTable
import com.github.jacokoo.kosql.mapping.Entity

open class Supplier: Entity<Int, SupplierTable> {
    var id: Int = 0
    var companyName: String = ""
    var contactName: String? = null
    var contactTitle: String? = null
    var city: String? = null
    var country: String? = null
    var phone: String? = null
    var fax: String? = null

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

}

