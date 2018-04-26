package com.github.jacokoo.kosql.example.kosql.table

import com.github.jacokoo.kosql.IntType
import com.github.jacokoo.kosql.StringType
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.statements.Column6

open class CustomerTable protected constructor(alias: String = ""): Table<Int>("t_customer", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0).autoIncrement()
    val FIRST_NAME = createColumn("f_first_name", StringType(), false, "")
    val LAST_NAME = createColumn("f_last_name", StringType(), false, "")
    val CITY = createColumn("f_city", StringType(), true, null)
    val COUNTRY = createColumn("f_country", StringType(), true, null)
    val PHONE = createColumn("f_phone", StringType(), true, null)

    override fun AS(alias: String) = CustomerTable(alias)
    override fun primaryKey() = ID
    operator fun invoke() = Column6(ID, FIRST_NAME, LAST_NAME, CITY, COUNTRY, PHONE)
}

object CUSTOMER: CustomerTable()
