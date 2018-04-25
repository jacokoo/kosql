package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.KoSQL
import com.github.jacokoo.kosql.example.kosql.entity.Abc
import com.github.jacokoo.kosql.example.kosql.table.ABC
import javax.annotation.PostConstruct

class Demo2(private val ko: KoSQL) {

    @PostConstruct fun demo() {
        ko.run {
            val a1 = Abc().also {
                it.a = 100
                it.color = Color.GREEN
                it.state = State.STARTED
            }

            val a2 = Abc().also {
                it.a = 88
            }

            val (id, rows) = INSERT(a1, a2).execute()
            println(id)
            println(rows)

            val abcs = SELECT(ABC()) {
                FROM(ABC)
            }.fetch(Abc::class)

            abcs.forEach {
                println("${it.id}, ${it.color}, ${it.a}, ${it.state}")
            }
        }
    }
}