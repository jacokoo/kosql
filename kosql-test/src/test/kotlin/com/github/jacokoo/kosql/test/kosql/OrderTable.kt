package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.DateNullType
import com.github.jacokoo.kosql.compose.DateType
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.StringNullType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column7
import com.github.jacokoo.kosql.test.entity.Order
import java.time.LocalDate


open class OrderBase(): Entity<Int> {
    var id: Int = 0
    var date: LocalDate = LocalDate.of(1970, 1, 1)
    var requiredDate: LocalDate = LocalDate.of(1970, 1, 1)
    var shippedDate: LocalDate = LocalDate.of(1970, 1, 1)
    var status: String = ""
    var comments: String = ""
    var customerId: Int = 0

    constructor(other: OrderBase): this() {
        this.id = other.id
        this.date = other.date
        this.requiredDate = other.requiredDate
        this.shippedDate = other.shippedDate
        this.status = other.status
        this.comments = other.comments
        this.customerId = other.customerId
    }

    override fun get(name: String): Any? = when(name) {
        ORDER.ID.name -> this.id
        ORDER.DATE.name -> this.date
        ORDER.REQUIRED_DATE.name -> this.requiredDate
        ORDER.SHIPPED_DATE.name -> this.shippedDate
        ORDER.STATUS.name -> this.status
        ORDER.COMMENTS.name -> this.comments
        ORDER.CUSTOMER_ID.name -> this.customerId
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            ORDER.ID.name -> this.id = value as Int
            ORDER.DATE.name -> this.date = value as LocalDate
            ORDER.REQUIRED_DATE.name -> this.requiredDate = value as LocalDate
            ORDER.SHIPPED_DATE.name -> this.shippedDate = value as LocalDate
            ORDER.STATUS.name -> this.status = value as String
            ORDER.COMMENTS.name -> this.comments = value as String
            ORDER.CUSTOMER_ID.name -> this.customerId = value as Int
        }
    }

    override fun toString(): String = buildString {
        append("OrderBase (")
        append("id = $id, date = $date, requiredDate = $requiredDate, shippedDate = $shippedDate, status = $status, comments = $comments, customerId = $customerId")
        append(")")
    }

}


open class OrderTable protected constructor(alias: String = ""): Table<Int, Order>("t_order", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0, autoIncrement = true)
    val DATE = createColumn("f_date", DateType(), false, LocalDate.of(1970, 1, 1))
    val REQUIRED_DATE = createColumn("f_required_date", DateType(), false, LocalDate.of(1970, 1, 1))
    val SHIPPED_DATE = createColumn("f_shipped_date", DateNullType(), true, LocalDate.of(1970, 1, 1))
    val STATUS = createColumn("f_status", StringType(), false, "")
    val COMMENTS = createColumn("f_comments", StringNullType(), true, "")
    val CUSTOMER_ID = createColumn("f_customer_id", IntType(), false, 0)

    override fun AS(alias: String) = OrderTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column7(ID, DATE, REQUIRED_DATE, SHIPPED_DATE, STATUS, COMMENTS, CUSTOMER_ID)
}

object ORDER: OrderTable()
