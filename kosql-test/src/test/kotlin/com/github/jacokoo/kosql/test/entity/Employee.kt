package com.github.jacokoo.kosql.test.entity

import com.github.jacokoo.kosql.test.kosql.EmployeeBase

class Employee: EmployeeBase {

    constructor(): super()
    constructor(other: Employee): super(other)

    fun copy(block: (Employee) -> Unit): Employee = Employee(this).also(block)

}
