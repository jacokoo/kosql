package com.github.jacokoo.kosql.compose.typesafe

fun main(args: Array<String>) {
    val count = 22

    val title = """
        |package com.github.jacokoo.kosql.compose.typesafe
        |
        |import com.github.jacokoo.kosql.compose.Column
        |import com.github.jacokoo.kosql.compose.statements.*
        |
    """.trimMargin()

    fun classPart(it: Int) = """
        |
        |data class SelectStatement$it<${times(it) { "T$it" }}>(val c: Column$it<${times(it) { "T$it" }}>, override val data: SelectData): SelectStatement
    """.trimMargin()

    fun methodPart(it: Int) = """
        |
        |    fun <${times(it) { "T$it" }}> SELECT(${times(it) { "c$it: Column<T$it>" }}, block: SelectCreator) =  SelectStatement$it(Column$it(${times(it) { "c$it" }}), SelectFromPart(${times(it) { "c$it" }}).block().data)
        |    fun <${times(it) { "T$it" }}> SELECT(c: Column$it<${times(it) { "T$it" }}>, block: SelectCreator) =  SelectStatement$it(c, SelectFromPart(c).block().data)
        |
    """.trimMargin()

    println(buildString {
        append(title)
        (1..count).forEach { append(classPart(it)) }
        append("\n\ninterface Selects: Select {")
        (1..count).forEach { append(methodPart(it)) }
        append("}")
    })
}
