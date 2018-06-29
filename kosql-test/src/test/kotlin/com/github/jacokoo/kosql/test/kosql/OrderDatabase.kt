package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.Database
import com.github.jacokoo.kosql.test.entity.Customer
import com.github.jacokoo.kosql.test.entity.Order
import com.github.jacokoo.kosql.test.entity.OrderItem
import com.github.jacokoo.kosql.test.entity.Product
import com.github.jacokoo.kosql.test.entity.Supplier
import com.github.jacokoo.kosql.test.entity.SupportType

object OrderDatabase: Database {
    init {
        Database.register(CUSTOMER, Customer::class)
        Database.register(ORDER, Order::class)
        Database.register(ORDER_ITEM, OrderItem::class)
        Database.register(PRODUCT, Product::class)
        Database.register(SUPPLIER, Supplier::class)
        Database.register(SUPPORT_TYPE, SupportType::class)
    }
}
