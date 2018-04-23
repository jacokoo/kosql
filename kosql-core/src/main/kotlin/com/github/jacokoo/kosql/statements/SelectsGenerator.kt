package com.github.jacokoo.kosql.statements

fun main(args: Array<String>) {
    val count = 22

    val title = """
        |package com.github.jacokoo.kosql.statements
        |
        |import com.github.jacokoo.kosql.Column
        |import com.github.jacokoo.kosql.mapping.*
        |
    """.trimMargin()

    fun classPart(it: Int) = """
        |
        |data class SelectStatement$it<${times(it) { "T$it" }}>(${times(it) { "val c$it: Column<T$it>" }}, override val data: QueryData): QueryPart
        |data class ResultRow$it<${times(it) { "T$it" }}>(${times(it) { "val v$it: T$it" }}, override val values: List<Any?> = listOf(${times(it) {"v$it"}})): ResultRow
        |data class QueryResult$it<${times(it) { "T$it" }}>(${times(it) { "private val c$it: Column<T$it>" }}, override val values: List<ResultRow$it<${times(it) { "T$it" }}>>): QueryResult<ResultRow$it<${times(it) { "T$it" }}>> {
        |    override val columns: List<Column<*>> = listOf(${times(it) {"c$it"}})
        |    constructor(${times(it) { "c$it: Column<T$it>" }}, qp: QueryPart, ko: QueryResultExtension): this(${times(it) {"c$it"}}, ko.execute(qp, Mapper(${times(it) {"c$it"}})))
        |    private class Mapper<${times(it) { "T$it" }}>(${times(it) { "private val c$it: Column<T$it>" }}): ResultSetMapper<ResultRow$it<${times(it) { "T$it" }}>> {
        |        override fun map(rs: ResultSetRow) = ResultRow$it(${times(it) {"rs[${it - 1}, c$it]"}})
        |    }
        |}
        |
    """.trimMargin()

    fun methodPart(it: Int) = """
        |
        |    operator fun <${times(it) { "T$it" }}> Select.SELECT.invoke(${times(it) { "c$it: Column<T$it>" }}, block: SelectCreator) =  SelectStatement$it(${times(it) {"c$it"}}, SelectFromPart(${times(it) {"c$it"}}).block().data)
        |    fun <${times(it) { "T$it" }}> SelectStatement$it<${times(it) { "T$it" }}>.fetch(): QueryResult$it<${times(it) { "T$it" }}> = QueryResult$it(${times(it) {"c$it"}}, this, this@Selects)
        |
    """.trimMargin()

    println(buildString {
        append(title)
        (1..count).forEach { append(classPart(it)) }
        append("interface Selects: QueryResultExtension {")
        (1..count).forEach { append(methodPart(it)) }
        append("}")
    })
}