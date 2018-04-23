package com.github.jacokoo.kosql.generator

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
            bean<Demo>()
        })
    }
}