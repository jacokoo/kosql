package com.github.jacokoo.kosql.example.kosql

import com.github.jacokoo.kosql.compose.Database
import com.github.jacokoo.kosql.example.entity.*
import com.github.jacokoo.kosql.example.kosql.table.*

object OrderDatabase: Database {
    init {
        Database.register(ABC, Abc::class)
        Database.register(CUSTOMER, Customer::class)
        Database.register(ORDER, Order::class)
        Database.register(ORDER_ITEM, OrderItem::class)
        Database.register(PRODUCT, Product::class)
        Database.register(SUPPLIER, Supplier::class)
    }
}
