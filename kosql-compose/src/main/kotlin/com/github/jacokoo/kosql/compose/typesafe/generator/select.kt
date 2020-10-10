package com.github.jacokoo.kosql.compose.typesafe.generator

fun main() {
    val count = 10

    val title = """
        |package com.github.jacokoo.kosql.compose.typesafe
        |
        |import com.github.jacokoo.kosql.compose.Column
        |import com.github.jacokoo.kosql.compose.statement.Select
        |import com.github.jacokoo.kosql.compose.statement.SelectData
        |import com.github.jacokoo.kosql.compose.statement.SelectFromOperate
        |
    """.trimMargin()

    fun classPart(it: Int) = """
        |
        |data class SelectStatement$it<${times(it) { "T$it" }}>(override val data: SelectData<Column$it<${times(it) { "T$it" }}>>): SelectFromOperate<Column$it<${times(it) { "T$it" }}>>
    """.trimMargin()

    fun methodPart(it: Int) = """
        |
        |    fun <${times(it) { "T$it" }}> SELECT(${times(it) { "c$it: Column<T$it>" }}) =  SELECT(Column$it(${times(it) { "c$it" }}))
        |    fun <${times(it) { "T$it" }}> SELECT(c: Column$it<${times(it) { "T$it" }}>) =  SelectStatement$it(SelectData(c))
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
