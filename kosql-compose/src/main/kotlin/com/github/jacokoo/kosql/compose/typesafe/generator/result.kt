package com.github.jacokoo.kosql.compose.typesafe.generator

fun main() {
    val count = 10

    val title = """
        |package com.github.jacokoo.kosql.compose.typesafe
        |
        |import com.github.jacokoo.kosql.compose.result.Mapper
        |import com.github.jacokoo.kosql.compose.result.Row
        |import com.github.jacokoo.kosql.compose.result.SelectResult
        |
    """.trimMargin()

    fun classPart(it: Int) = """
        |
        |class Value${it}Mapper<${times(it) { "T$it" }}>(private val c: Column$it<${times(it) { "T$it" }}>): Mapper<Value$it<${times(it) { "T$it" }}>> {
        |    override fun map(rs: Row) = Value$it(${times(it) { "rs[${it - 1}, c.c$it]" }})
        |}
        |data class Result$it<${times(it) { "T$it" }}>(private val c: Column$it<${times(it) { "T$it" }}>, override val values: List<Value$it<${times(it) { "T$it" }}>>): SelectResult<Value$it<${times(it) { "T$it" }}>> {
        |    override val columns = c
        |}
        |
    """.trimMargin()

    println(buildString {
        append(title)
        (1..count).forEach { append(classPart(it)) }
    })
}
