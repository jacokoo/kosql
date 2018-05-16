package com.github.jacokoo.kosql.executor.typesafe

fun times(n: Int, b: (Int) -> String): String = (1..n).map { b(it) }.joinToString()

fun main(args: Array<String>) {
    val count = 22

    val title = """
        |package com.github.jacokoo.kosql.executor.typesafe
        |
        |import com.github.jacokoo.kosql.compose.statements.SelectStatement
        |import com.github.jacokoo.kosql.compose.typesafe.*
        |import com.github.jacokoo.kosql.executor.Query
        |import com.github.jacokoo.kosql.executor.ResultSetMapper
        |import com.github.jacokoo.kosql.executor.ResultSetRow
        |import com.github.jacokoo.kosql.executor.SelectResult
        |
    """.trimMargin()

    fun classPart(it: Int) = """
        |
        |class SelectResultMapper$it<${times(it) { "T$it" }}>(private val c: Column$it<${times(it) { "T$it" }}>): ResultSetMapper<Value$it<${times(it) { "T$it" }}>> {
        |    override fun map(rs: ResultSetRow) = Value$it(${times(it) { "rs[${it - 1}, c.c$it]" }})
        |}
        |data class SelectResult$it<${times(it) { "T$it" }}>(private val c: Column$it<${times(it) { "T$it" }}>, override val values: List<Value$it<${times(it) { "T$it" }}>>): SelectResult<Value$it<${times(it) { "T$it" }}>> {
        |    override val columns = c
        |    constructor(c: Column$it<${times(it) { "T$it" }}>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper$it(c)))
        |}
    """.trimMargin()

    fun methodPart(it: Int) = """
        |
        |    fun <${times(it) { "T$it" }}> SelectStatement$it<${times(it) { "T$it" }}>.fetch() = SelectResult$it(c, this, this@Queries)
    """.trimMargin()

    println(buildString {
        append(title)
        (1..count).forEach { append(classPart(it)) }
        append("\n\ninterface Queries: Query {")
        (1..count).forEach { append(methodPart(it)) }
        append("\n}")
    })
}
