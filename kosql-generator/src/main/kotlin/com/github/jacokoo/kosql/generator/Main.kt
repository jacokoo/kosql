package com.github.jacokoo.kosql.generator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.beans

@SpringBootApplication
@Configuration
open class Main

enum class Color { RED, GREEN, BLUE }
enum class State { INIT, STARTED, ENDED }

fun main(args: Array<String>) {
    runApplication<Main>(*args) {
        addInitializers(beans {
            bean {
                KoSQLGeneratorConfig(
                        outputDirectory = "/tmp/ko",
                        outputPackage = "com.github.jacokoo.kosql.example",
                        useEnums = listOf(
                                UseEnum.int("t_abc", "f_color", Color::class.java, Color.RED),
                                UseEnum.str("t_abc", "f_state", State::class.java, State.INIT)
                        )
                )
            }
            bean<KoSQLGenerator>()
        })
    } .getBean(KoSQLGenerator::class.java).also {
        it.doGenerate()
    }
}