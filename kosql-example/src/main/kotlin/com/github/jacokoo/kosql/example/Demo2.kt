package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.KoSQL
import com.github.jacokoo.kosql.example.kosql.entity.Abc
import com.github.jacokoo.kosql.example.kosql.table.ABC
import javax.annotation.PostConstruct

class Demo2(private val ko: KoSQL) {

    @PostConstruct fun demo() {
        ko.run {
            INSERT(Abc().also {
                it.bool2 = true; it.bit1 = 1099511627775L
                it.bit2 = "abcd".toByteArray()
                it.text = "efghj"
            }).execute().also { println(it) }

            val a = Abc().also {
                it.a = 1; it.state = State.ENDED
                it.color = Color.GREEN; it.bool2 = true; it.bool1 = false
                it.bit1 = 20L; it.bit2 = "nima".toByteArray()
            }

            INSERT(a, a.copy { it.a = 2 }, a.copy { it.a = 3 }).executeBatch()

            (UPDATE(ABC) SET {
                it[ABC.BOOL2] = false
                it[ABC.BOOL1] = true
            } WHERE (ABC.ID EQ 1)).execute().also { println("updated $it") }

            SELECT(ABC()) {
                FROM(ABC)
            }.fetch(Abc::class).forEach { println(it) }
        }
    }
}