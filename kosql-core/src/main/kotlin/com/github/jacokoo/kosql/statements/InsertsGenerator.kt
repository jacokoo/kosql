package com.github.jacokoo.kosql.statements

import java.io.File

fun times(n: Int, b: (Int) -> String): String = (1..n).map { b(it) }.joinToString()

fun main(args: Array<String>) {
    val count  = 22

    fun template(it: Int) = """
        |package com.github.jacokoo.kosql.statements.inverts
        |
        |import com.github.jacokoo.kosql.Column
        |import com.github.jacokoo.kosql.Table
        |import com.github.jacokoo.kosql.statements.*
        |
        |data class Field$it<${times(it) { "T$it" }}>(val table: Table<*>, ${times(it) { "val c$it: Column<T$it>" }}) {
        |   infix fun<${times(it) {"T$it"}}> VALUES(v: Value$it<${times(it) {"T$it"}}>): Repeat$it<${times(it) {"T$it"}}> = Repeat$it(append(InsertData(this.table, listOf(${times(it) {"this.c$it"}})), v))
        |}
        |data class Value$it<${times(it) { "out T$it" }}>(${times(it) { "val v$it: T$it" }})
        |data class Repeat$it<${times(it) { "in T$it" }}>(override val data: InsertData): InsertPart {
        |    infix fun AND(v: Value$it<${times(it) { "T$it" }}>): Repeat$it<${times(it) { "T$it" }}> = Repeat$it(append(data, ${times(it) {"v.v$it"}}))
        |}
        |
        |interface Inserts$it {
        |    fun <${times(it) {"T$it"}}> V(${times(it) {"v$it: T$it"}}): Value$it<${times(it) {"T$it"}}> = Value$it(${times(it) {"v$it"}})
        |    operator fun <${times(it) {"T$it"}}> Table<*>.invoke(${times(it) {"c$it: Column<T$it>"}}): Field$it<${times(it) {"T$it"}}> = Field$it(this, ${times(it) {"c$it"}})
        |}
    """.trimMargin()

    val title = """
        |package com.github.jacokoo.kosql.statements
        |
        |import com.github.jacokoo.kosql.Column
        |import com.github.jacokoo.kosql.Table
        |
    """.trimMargin()

    fun classPart(it: Int) = """
        |data class Field$it<${times(it) { "T$it" }}>(val table: Table<*>, ${times(it) { "val c$it: Column<T$it>" }}): ExtraValues {
        |   override val data: InsertData = InsertData(table, listOf(${times(it) {"c$it"}}), listOf())
        |   infix fun VALUES(v: Value$it<${times(it) {"T$it"}}>): Repeat$it<${times(it) {"T$it"}}> = Repeat$it(append(data, v))
        |}
        |data class Value$it<${times(it) { "out T$it" }}>(${times(it) { "val v$it: T$it" }})
        |data class Repeat$it<${times(it) { "in T$it" }}>(override val data: InsertData): InsertPart {
        |    infix fun AND(v: Value$it<${times(it) { "T$it" }}>): Repeat$it<${times(it) { "T$it" }}> = Repeat$it(append(data, ${times(it) {"v.v$it"}}))
        |}
        |
    """.trimMargin()

    fun methodPart(it: Int) = """
        |    fun <${times(it) {"T$it"}}> V(${times(it) {"v$it: T$it"}}): Value$it<${times(it) {"T$it"}}> = Value$it(${times(it) {"v$it"}})
        |    operator fun <${times(it) {"T$it"}}> Table<*>.invoke(${times(it) {"c$it: Column<T$it>"}}): Field$it<${times(it) {"T$it"}}> = Field$it(this, ${times(it) {"c$it"}})
        |
    """.trimMargin()

    fun mainSeperated(args: Array<String>) {
        val output = "/tmp/inserts"
        val count  = if (args.isNotEmpty()) args[0].toInt() else 22

        File(output).also {
            if (!it.exists()) it.mkdir()
        }

        println((1..count).map {n -> File(output, "Inserts$n.kt").also {
            if (it.exists()) it.delete()
            it.createNewFile()
            it.writer().use { it.write(template(n)) }
        }.let { it.name.slice(0..(it.name.indexOf(".") - 1)) }}.joinToString())
    }

    println(buildString {
        append(title)
        (1..count).forEach { append(classPart(it)) }
        append("interface Inserts {\n")
        (1..count).forEach { append(methodPart(it)) }
        append("}")
    })
}