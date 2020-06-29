package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.Database
import com.github.jacokoo.kosql.test.entity.Customer
import com.github.jacokoo.kosql.test.entity.Employee
import com.github.jacokoo.kosql.test.entity.Office
import com.github.jacokoo.kosql.test.entity.Order
import com.github.jacokoo.kosql.test.entity.OrderDetail
import com.github.jacokoo.kosql.test.entity.Payment
import com.github.jacokoo.kosql.test.entity.Product
import com.github.jacokoo.kosql.test.entity.ProductLine

object DemoDatabase: Database {
    init {
        Database.register(PAYMENT, Payment::class)
        Database.register(PRODUCT, Product::class)
        Database.register(PRODUCT_LINE, ProductLine::class)
        Database.register(CUSTOMER, Customer::class)
        Database.register(EMPLOYEE, Employee::class)
        Database.register(OFFICE, Office::class)
        Database.register(ORDER, Order::class)
        Database.register(ORDER_DETAIL, OrderDetail::class)
    }
}