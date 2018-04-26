package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.KoSQL
import com.github.jacokoo.kosql.example.kosql.entity.Abc
import com.github.jacokoo.kosql.example.kosql.table.ABC
import javax.annotation.PostConstruct

class Demo2(private val ko: KoSQL) {

    @PostConstruct fun demo() {
        ko.run {
            INSERT(
                Abc().also { it.a = 11; it.state = State.STARTED },
                Abc().also { it.a = 12; it.color = Color.GREEN }
            ).executeBatch().let { (ids, rows) ->
                println(ids)
                println(rows)
            }

            INSERT(Abc().also { it.a = 13 }).execute().let { (id, rows) ->
                println(id)
                println(rows)
            }

            SELECT(ABC()) {
                FROM(ABC)
            }.fetch(Abc::class).forEach {
                println("${it.id}, ${it.color}, ${it.a}, ${it.state}")
            }
        }
    }
}