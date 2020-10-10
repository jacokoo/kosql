package com.github.jacokoo.kosql.compose.typesafe.generator


fun main() {
    val count  = 10

    val title = """
        |package com.github.jacokoo.kosql.compose.typesafe
        |
        |import com.github.jacokoo.kosql.compose.*
        |import com.github.jacokoo.kosql.compose.statement.*
        |
        |
    """.trimMargin()

    fun classPart(it: Int) = """
        |data class Field$it<T, ${times(it) { "T$it" }}>(val table: Table<T, Entity<T>>, val c: Column$it<${times(it) { "T$it" }}>): ExtraValues<T> {
        |   override val data: InsertData<T> = InsertData(table.inner, c, listOf())
        |   infix fun VALUES(v: Value$it<${times(it) { "out T$it" }}>): Repeat$it<T, ${times(it) { "T$it" }}> = Repeat$it(data.copy(values = data.values + v))
        |}
        |data class Repeat$it<T, ${times(it) { "T$it" }}>(override val data: InsertData<T>): InsertStatement<T> {
        |    infix fun AND(v: Value$it<${times(it) { "out T$it" }}>): BatchRepeat$it<T, ${times(it) { "T$it" }}> = BatchRepeat$it(data.copy(values = data.values + v))
        |}
        |data class BatchRepeat$it<T, ${times(it) { "T$it" }}>(override val data: InsertData<T>): BatchInsertStatement<T> {
        |    infix fun AND(v: Value$it<${times(it) { "out T$it" }}>): BatchRepeat$it<T, ${times(it) { "T$it" }}> = BatchRepeat$it(data.copy(values = data.values + v))
        |}
        |
    """.trimMargin()

    fun methodPart(it: Int) = """
        |    operator fun <T, ${times(it) { "T$it" }}> Table<T, Entity<T>>.invoke(${times(it) { "c$it: Column<T$it>" }}): Field$it<T, ${times(it) { "T$it" }}> = Field$it(this, Column$it(${times(it) { "c$it" }}))
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
