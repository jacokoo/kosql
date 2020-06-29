package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.DateType
import com.github.jacokoo.kosql.compose.DecimalType
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column5
import com.github.jacokoo.kosql.test.entity.Payment
import java.math.BigDecimal
import java.time.LocalDate


open class PaymentBase(): Entity<Int> {
    var id: Int = 0
    var customerId: Int = 0
    var checkNumber: String = ""
    var date: LocalDate = LocalDate.of(1970, 1, 1)
    var amount: BigDecimal = BigDecimal("0")

    constructor(other: PaymentBase): this() {
        this.id = other.id
        this.customerId = other.customerId
        this.checkNumber = other.checkNumber
        this.date = other.date
        this.amount = other.amount
    }

    override fun get(name: String): Any? = when(name) {
        PAYMENT.ID.name -> this.id
        PAYMENT.CUSTOMER_ID.name -> this.customerId
        PAYMENT.CHECK_NUMBER.name -> this.checkNumber
        PAYMENT.DATE.name -> this.date
        PAYMENT.AMOUNT.name -> this.amount
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            PAYMENT.ID.name -> this.id = value as Int
            PAYMENT.CUSTOMER_ID.name -> this.customerId = value as Int
            PAYMENT.CHECK_NUMBER.name -> this.checkNumber = value as String
            PAYMENT.DATE.name -> this.date = value as LocalDate
            PAYMENT.AMOUNT.name -> this.amount = value as BigDecimal
        }
    }

    override fun toString(): String = buildString {
        append("PaymentBase (")
        append("id = $id, customerId = $customerId, checkNumber = $checkNumber, date = $date, amount = $amount")
        append(")")
    }

}


open class PaymentTable protected constructor(alias: String = ""): Table<Int, Payment>("f_payment", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0, autoIncrement = true)
    val CUSTOMER_ID = createColumn("f_customer_id", IntType(), false, 0)
    val CHECK_NUMBER = createColumn("f_check_number", StringType(), false, "")
    val DATE = createColumn("f_date", DateType(), false, LocalDate.of(1970, 1, 1))
    val AMOUNT = createColumn("f_amount", DecimalType(), false, BigDecimal("0"))

    override fun AS(alias: String) = PaymentTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column5(ID, CUSTOMER_ID, CHECK_NUMBER, DATE, AMOUNT)
}

object PAYMENT: PaymentTable()
