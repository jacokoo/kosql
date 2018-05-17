package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.generator.DefaultNamingStrategy
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

class Name(): DefaultNamingStrategy() {
    override fun entityClassName(tableName: String): String {
        return super.entityClassName(tableName) + ""
    }
}

fun main(args: Array<String>) {
    runApplication<Generator>(*args) {
        addInitializers(beans {
            bean {
                KoSQLGeneratorConfig(
                    outputDirectory = "/Users/guyong/ws/fun/kotlin/kosql2/kosql-example/src/main/kotlin",
                    outputPackage = "com.github.jacokoo.kosql.example",
                    namingStrategy = Name(),
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
