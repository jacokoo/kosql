package com.github.jacokoo.kosql.test

import com.github.jacokoo.kosql.test.entity.Order
import com.github.jacokoo.kosql.test.kosql.ORDER
import com.github.jacokoo.kosql.spring.jdbc.KoSQL
import javax.annotation.PostConstruct

class Demo(private val ko: KoSQL) {
    val template = ko.template {
        SELECT(-ORDER) FROM ORDER WHERE ORDER.ID LT 10 AND ORDER.CUSTOMER_ID LT 100
    }

    @PostConstruct
    fun demo() = ko.run {
        val a: Int? = null
        println(ORDER.byId(1))
        println(ORDER.count())
        println(ORDER.count(ORDER.ID EQ a))
        println(template.fetch(Order::class, 0 to 10, 1 to a))

        template.fetch(1 to 40).forEach {
            println(it)
        }
    }
}

