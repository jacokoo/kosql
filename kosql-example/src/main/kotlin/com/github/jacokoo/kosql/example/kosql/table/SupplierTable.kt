package com.github.jacokoo.kosql.example.kosql.table

import com.github.jacokoo.kosql.IntType
import com.github.jacokoo.kosql.StringType
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.typesafe.Column8

open class SupplierTable protected constructor(alias: String = ""): Table<Int>("t_supplier", alias, "") {
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
    operator fun invoke() = Column8(ID, COMPANY_NAME, CONTACT_NAME, CONTACT_TITLE, CITY, COUNTRY, PHONE, FAX)
}

object SUPPLIER: SupplierTable()
