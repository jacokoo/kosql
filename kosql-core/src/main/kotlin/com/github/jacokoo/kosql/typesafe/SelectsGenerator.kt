package com.github.jacokoo.kosql.typesafe

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
        |data class SelectStatement$it<${times(it) { "T$it" }}>(val c: Column$it<${times(it) { "T$it" }}>, override val data: QueryData): QueryPart
        |class QueryResultMapper$it<${times(it) { "T$it" }}>(private val c: Column$it<${times(it) { "T$it" }}>): ResultSetMapper<Value$it<${times(it) { "T$it" }}>> {
        |    override fun map(rs: ResultSetRow) = Value$it(${times(it) { "rs[${it - 1}, c.c$it]" }})
        |}
        |data class QueryResult$it<${times(it) { "T$it" }}>(private val c: Column$it<${times(it) { "T$it" }}>, override val values: List<Value$it<${times(it) { "T$it" }}>>): QueryResult<Value$it<${times(it) { "T$it" }}>> {
        |    override val columns = c
        |    constructor(c: Column$it<${times(it) { "T$it" }}>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper$it(c)))
        |}
        |
    """.trimMargin()

    fun methodPart(it: Int) = """
        |
        |    operator fun <${times(it) { "T$it" }}> Select.SELECT.invoke(${times(it) { "c$it: Column<T$it>" }}, block: SelectCreator) =  SelectStatement$it(Column$it(${times(it) { "c$it" }}), SelectFromPart(${times(it) { "c$it" }}).block().data)
        |    operator fun <${times(it) { "T$it" }}> Select.SELECT.invoke(c: Column$it<${times(it) { "T$it" }}>, block: SelectCreator) =  SelectStatement$it(c, SelectFromPart(c).block().data)
        |    fun <${times(it) { "T$it" }}> SelectStatement$it<${times(it) { "T$it" }}>.fetch(): QueryResult$it<${times(it) { "T$it" }}> = QueryResult$it(c, this, this@Selects)
        |    fun <${times(it) { "T$it" }}> SelectStatement$it<${times(it) { "T$it" }}>.fetchOne() = fetch().values.firstOrNull()
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