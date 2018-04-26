package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.KoSQL
import com.github.jacokoo.kosql.example.kosql.entity.Abc
import com.github.jacokoo.kosql.example.kosql.table.ABC
import java.nio.charset.Charset
import javax.annotation.PostConstruct

class Demo2(private val ko: KoSQL) {

    @PostConstruct fun demo() {
        ko.run {
            INSERT(Abc().also { it.bool2 = true; it.bit1 = 1099511627775L; it.bit2 = "abcd".toByteArray() }).execute().also { println(it) }

            (UPDATE(ABC) SET {
                it[ABC.BOOL2] = false
                it[ABC.BOOL1] = true
            } WHERE (ABC.ID EQ 1)).execute().also { println("updated $it") }

            SELECT(ABC()) {
                FROM(ABC)
            }.fetch(Abc::class).forEach {
                println("${it.id}, ${it.color}, ${it.a}, ${it.state}, ${it.bool1}, ${it.bool2}, ${it.bit1}, ${it.bit2.toString(Charset.defaultCharset())}")
            }
        }
    }
}