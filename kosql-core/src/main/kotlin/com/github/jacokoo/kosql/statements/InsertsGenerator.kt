package com.github.jacokoo.kosql.statements

fun times(n: Int, b: (Int) -> String): String = (1..n).map { b(it) }.joinToString()

fun main(args: Array<String>) {
    val count  = 22

    val title = """
        |package com.github.jacokoo.kosql.statements
        |
        |import com.github.jacokoo.kosql.Column
        |import com.github.jacokoo.kosql.Table
        |
        |
    """.trimMargin()

    fun classPart(it: Int) = """
        |data class Field$it<T, ${times(it) { "T$it" }}>(val table: Table<T>, val c: Column$it<${times(it) {"T$it"}}>): ExtraValues<T> {
        |   override val data: InsertData<T> = InsertData(table, c, listOf())
        |   infix fun VALUES(v: Value$it<${times(it) {"T$it"}}>): Repeat$it<T, ${times(it) {"T$it"}}> = Repeat$it(append(data, v))
        |}
        |data class Value$it<${times(it) { "out T$it" }}>(${times(it) { "val v$it: T$it" }})
        |data class Repeat$it<T, ${times(it) { "in T$it" }}>(override val data: InsertData<T>): InsertPart<T> {
        |    infix fun AND(v: Value$it<${times(it) { "T$it" }}>): Repeat$it<T, ${times(it) { "T$it" }}> = Repeat$it(append(data, ${times(it) {"v.v$it"}}))
        |}
        |
    """.trimMargin()

    fun methodPart(it: Int) = """
        |    fun <${times(it) {"T$it"}}> V(${times(it) {"v$it: T$it"}}): Value$it<${times(it) {"T$it"}}> = Value$it(${times(it) {"v$it"}})
        |    operator fun <T, ${times(it) {"T$it"}}> Table<T>.invoke(${times(it) {"c$it: Column<T$it>"}}): Field$it<T, ${times(it) {"T$it"}}> = Field$it(this, Column$it(${times(it) {"c$it"}}))
        |
    """.trimMargin()

    println(buildString {
        append(title)
        (1..count).forEach { append(classPart(it)) }
        append("interface Inserts {\n")
        (1..count).forEach { append(methodPart(it)) }
        append("}")
    })
}