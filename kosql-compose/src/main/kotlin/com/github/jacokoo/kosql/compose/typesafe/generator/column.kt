package com.github.jacokoo.kosql.compose.typesafe.generator

fun main() {
    val count = 10

    val title = """
        |package com.github.jacokoo.kosql.compose.typesafe
        |
        |import com.github.jacokoo.kosql.compose.Column
        |import com.github.jacokoo.kosql.compose.statement.ColumnList
        |import com.github.jacokoo.kosql.compose.statement.Columns
        |
    """.trimMargin()

    fun sign(it: Int) = """
        |
        |
        |data class Column$it<${times(it) { "T$it" }}>(${times(it) { "val c$it: Column<T$it>" }}, override val columns: List<Column<*>> = listOf(${times(it) { "c$it" }})): ColumnList {
    """.trimMargin()

    fun addOne(it: Int) = if (it < count) """
        |
        |    operator fun <R1> plus(c: Column<R1>) = Column${it + 1}(${times(it) { "c$it" }}, c)
    """.trimMargin() else """
        |
        |    operator fun <R1> plus(c: Column<R1>) = Columns(columns + c)
    """.trimMargin()

    fun body(current: Int, it: Int) = if (current + it <= count) """
        |
        |    operator fun <${times(it) { "R$it" }}> plus(c: Column$it<${times(it) { "R$it" }}>) = Column${it + current}(${times(current) { "c$it" }}, ${times(it) { "c.c$it" }})
    """.trimMargin() else """
        |
        |    operator fun <${times(it) { "R$it" }}> plus(c: Column$it<${times(it) { "R$it" }}>) = Columns(columns + c.columns)
    """.trimMargin()

    println(buildString {
        append(title)
        (1..count).forEach { c ->
            append(sign(c))
            append(addOne(c))
            (1..count).forEach { append(body(c, it)) }
            append("\n}")
        }
    })
}
