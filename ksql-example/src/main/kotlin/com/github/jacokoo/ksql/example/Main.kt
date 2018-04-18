package com.github.jacokoo.ksql.example

import com.github.jacokoo.ksql.KSQL
import com.github.jacokoo.ksql.example.table.ORDER
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.beans

@SpringBootApplication
@Configuration
open class Main

fun main(args: Array<String>) {
    val ctx = runApplication<Main>(*args) {
        beans { bean<KSQL>() }
    }
    val k = ctx.getBean(KSQL::class.java)
    val a = k.query(ORDER) {
        SELECT(ORDER) WHERE (ORDER.ID EQ 1)
    }

    a.forEach { println(it) }
}