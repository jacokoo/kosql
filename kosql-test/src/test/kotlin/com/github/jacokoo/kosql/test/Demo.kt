package com.github.jacokoo.kosql.test

import com.github.jacokoo.kosql.spring.jdbc.KoSQL
import com.github.jacokoo.kosql.test.kosql.*
import com.github.jacokoo.kosql.test.entity.*
import javax.annotation.PostConstruct
import java.time.LocalDate

class Demo(val ko: KoSQL) {

    @PostConstruct
    fun demo() = ko.run {
        (SELECT(ORDER) FROM ORDER).fetch(ORDER).forEach {
            println(it)
        }

        (SELECT(ORDER) FROM ORDER
            WHERE ORDER.ID EQ 1 AND (ORDER.ID EQ 2 AND (ORDER.ID EQ 3)) AND ORDER.ID EQ 4
        ).fetch(ORDER)
    }

    @PostConstruct
    fun insert() = ko.tx {
        Order().also {
            it.date = LocalDate.now()
            it.requiredDate = LocalDate.now()
            it.status = "Shipped"
            it.customerId = 128

            it.save()
        }
    }
}
