package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.example.kosql.entity.Abc
import com.github.jacokoo.kosql.example.kosql.entity.Customer
import com.github.jacokoo.kosql.example.kosql.entity.Order
import com.github.jacokoo.kosql.example.kosql.entity.OrderItem
import com.github.jacokoo.kosql.example.kosql.entity.Product
import com.github.jacokoo.kosql.example.kosql.entity.Supplier
import com.github.jacokoo.kosql.example.kosql.table.ABC
import com.github.jacokoo.kosql.example.kosql.table.CUSTOMER
import com.github.jacokoo.kosql.example.kosql.table.ORDER
import com.github.jacokoo.kosql.example.kosql.table.ORDER_ITEM
import com.github.jacokoo.kosql.example.kosql.table.PRODUCT
import com.github.jacokoo.kosql.example.kosql.table.SUPPLIER
import com.github.jacokoo.kosql.mapping.Database


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