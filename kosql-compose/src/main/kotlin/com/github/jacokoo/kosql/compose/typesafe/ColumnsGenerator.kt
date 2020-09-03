package com.github.jacokoo.kosql.compose.typesafe

fun main(args: Array<String>) {
    val count = 10

    val title = """
        |package com.github.jacokoo.kosql.compose.typesafe
        |
        |import com.github.jacokoo.kosql.compose.Column
        |import com.github.jacokoo.kosql.compose.Entity
        |import com.github.jacokoo.kosql.compose.Table
        |
        |interface ColumnList {
        |    val columns: List<Column<*>>
        |
        |    operator fun minus(cl: ColumnList) = Columns(columns - cl.columns)
        |    operator fun minus(c: Column<*>) = Columns(columns - c)
        |
        |    operator fun plus(cs: Columns) = Columns(columns + cs.columns)
        |}
        |
        |data class Columns(override val columns: List<Column<*>>): ColumnList {
        |    constructor(vararg cs: Column<*>): this(cs.toList())
        |    operator fun plus(table: Table<*, Entity<*>>) = Columns(columns + table.columns)
        |    operator fun plus(cl: ColumnList) = Columns(columns + cl.columns)
        |    operator fun plus(c: Column<*>) = Columns(columns + c)
        |}
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
