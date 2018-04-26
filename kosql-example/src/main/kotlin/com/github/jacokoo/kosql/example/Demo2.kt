package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.KoSQL
import com.github.jacokoo.kosql.example.kosql.table.ABC
import javax.annotation.PostConstruct

class Demo2(private val ko: KoSQL) {

    @PostConstruct fun demo() {
        ko.run {
            val a = (INSERT INTO ABC(ABC.ID, ABC.TEXT) VALUES V(10, "aa")).execute()
            println(a)
        }
    }
}