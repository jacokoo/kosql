package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.example.kosql.OrderDatabase
import com.github.jacokoo.kosql.spring.jdbc.KoSQL
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.beans

@SpringBootApplication
@Configuration
open class Main

fun main(args: Array<String>) {
    runApplication<Main>(*args) {
        addInitializers(beans {
            bean {OrderDatabase}
            bean<KoSQL>()
            bean<Demo2>()
        })
    }
}
