package com.github.jacokoo.kosql.test

import com.github.jacokoo.kosql.spring.jdbc.KoSQL
import com.github.jacokoo.kosql.test.kosql.DemoDatabase
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.beans

@SpringBootApplication
@Configuration
open class Main

val config = beans {
    bean {DemoDatabase}
    bean<KoSQL>()
    bean<Demo>()
}

fun main(args: Array<String>) {
    runApplication<Main>(*args) { addInitializers(config) }
}

