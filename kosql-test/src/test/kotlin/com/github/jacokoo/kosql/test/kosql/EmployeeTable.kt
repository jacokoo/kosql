package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.IntNullType
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column8
import com.github.jacokoo.kosql.test.entity.Employee


open class EmployeeBase(): Entity<Int> {
    var id: Int = 0
    var lastName: String = ""
    var firstAme: String = ""
    var extension: String = ""
    var email: String = ""
    var officeCode: String = ""
    var reportTo: Int = 0
    var jobTitle: String = ""

    constructor(other: EmployeeBase): this() {
        this.id = other.id
        this.lastName = other.lastName
        this.firstAme = other.firstAme
        this.extension = other.extension
        this.email = other.email
        this.officeCode = other.officeCode
        this.reportTo = other.reportTo
        this.jobTitle = other.jobTitle
    }

    override fun get(name: String): Any? = when(name) {
        EMPLOYEE.ID.name -> this.id
        EMPLOYEE.LAST_NAME.name -> this.lastName
        EMPLOYEE.FIRST_AME.name -> this.firstAme
        EMPLOYEE.EXTENSION.name -> this.extension
        EMPLOYEE.EMAIL.name -> this.email
        EMPLOYEE.OFFICE_CODE.name -> this.officeCode
        EMPLOYEE.REPORT_TO.name -> this.reportTo
        EMPLOYEE.JOB_TITLE.name -> this.jobTitle
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            EMPLOYEE.ID.name -> this.id = value as Int
            EMPLOYEE.LAST_NAME.name -> this.lastName = value as String
            EMPLOYEE.FIRST_AME.name -> this.firstAme = value as String
            EMPLOYEE.EXTENSION.name -> this.extension = value as String
            EMPLOYEE.EMAIL.name -> this.email = value as String
            EMPLOYEE.OFFICE_CODE.name -> this.officeCode = value as String
            EMPLOYEE.REPORT_TO.name -> this.reportTo = value as Int
            EMPLOYEE.JOB_TITLE.name -> this.jobTitle = value as String
        }
    }

    override fun toString(): String = buildString {
        append("EmployeeBase (")
        append("id = $id, lastName = $lastName, firstAme = $firstAme, extension = $extension, email = $email, officeCode = $officeCode, reportTo = $reportTo, jobTitle = $jobTitle")
        append(")")
    }

}


open class EmployeeTable protected constructor(alias: String = ""): Table<Int, Employee>("t_employee", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0, autoIncrement = true)
    val LAST_NAME = createColumn("f_last_name", StringType(), false, "")
    val FIRST_AME = createColumn("f_first_ame", StringType(), false, "")
    val EXTENSION = createColumn("f_extension", StringType(), false, "")
    val EMAIL = createColumn("f_email", StringType(), false, "")
    val OFFICE_CODE = createColumn("f_office_code", StringType(), false, "")
    val REPORT_TO = createColumn("f_report_to", IntNullType(), true, 0)
    val JOB_TITLE = createColumn("f_job_title", StringType(), false, "")

    override fun AS(alias: String) = EmployeeTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column8(ID, LAST_NAME, FIRST_AME, EXTENSION, EMAIL, OFFICE_CODE, REPORT_TO, JOB_TITLE)
}

object EMPLOYEE: EmployeeTable()
