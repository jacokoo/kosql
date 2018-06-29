package com.github.jacokoo.kosql.test

import com.github.jacokoo.kosql.generator.KoSQLGenerator
import com.github.jacokoo.kosql.generator.KoSQLGeneratorConfig
import com.github.jacokoo.kosql.generator.UseEnum
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.beans

@SpringBootApplication
@Configuration
open class Generator

enum class Color { RED, GREEN, BLUE }
enum class State { INIT, STARTED, ENDED }

fun main(args: Array<String>) {
    runApplication<Generator>(*args) {
        addInitializers(beans {
            bean {
                KoSQLGeneratorConfig(
                    // outputDirectory = "/Users/guyong/ws/fun/kotlin/kosql2/kosql-example/src/main/kotlin",
                    outputDirectory = "/tmp/kosql/oo",
                    outputPackage = "com.github.jacokoo.kosql.test",
                    useEnums = listOf(
                            UseEnum.int("t_support_type", "f_int_enum", Color::class.java, Color.RED),
                            UseEnum.str("t_support_type", "f_string_enum", State::class.java, State.INIT)
                    ),
                    needEntitySubClass = true
                )
            }
            bean<KoSQLGenerator>()
        })
    } .getBean(KoSQLGenerator::class.java).also {
        it.doGenerate()
    }
}