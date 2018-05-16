package com.github.jacokoo.kosql.compose.typesafe

fun times(n: Int, b: (Int) -> String): String = (1..n).map { b(it) }.joinToString()

fun main(args: Array<String>) {
    val count  = 22

    val title = """
        |package com.github.jacokoo.kosql.compose.typesafe
        |
        |import com.github.jacokoo.kosql.compose.Column
        |import com.github.jacokoo.kosql.compose.Table
        |import com.github.jacokoo.kosql.compose.statements.ExtraValues
        |import com.github.jacokoo.kosql.compose.statements.InsertData
        |import com.github.jacokoo.kosql.compose.statements.InsertStatement
        |import com.github.jacokoo.kosql.compose.statements.append
        |
        |
    """.trimMargin()

    fun classPart(it: Int) = """
        |data class Field$it<T, ${times(it) { "T$it" }}>(val table: Table<T>, val c: Column$it<${times(it) { "T$it" }}>): ExtraValues<T> {
        |   override val data: InsertData<T> = InsertData(table, c, listOf())
        |   infix fun VALUES(v: Value$it<${times(it) { "T$it" }}>): Repeat$it<T, ${times(it) { "T$it" }}> = Repeat$it(append(data, v))
        |}
        |data class Repeat$it<T, ${times(it) { "T$it" }}>(override val data: InsertData<T>): InsertStatement<T> {
        |    infix fun AND(v: Value$it<${times(it) { "T$it" }}>): Repeat$it<T, ${times(it) { "T$it" }}> = Repeat$it(append(data, v))
        |}
        |
    """.trimMargin()

    fun methodPart(it: Int) = """
        |    operator fun <T, ${times(it) { "T$it" }}> Table<T>.invoke(${times(it) { "c$it: Column<T$it>" }}): Field$it<T, ${times(it) { "T$it" }}> = Field$it(this, Column$it(${times(it) { "c$it" }}))
        |
    """.trimMargin()

    println(buildString {
        append(title)
        (1..count).forEach { append(classPart(it)) }
        append("\ninterface Inserts: ValueSupport {\n")
        (1..count).forEach { append(methodPart(it)) }
        append("}")
    })
}
