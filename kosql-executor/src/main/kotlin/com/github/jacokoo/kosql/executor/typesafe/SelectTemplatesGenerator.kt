package com.github.jacokoo.kosql.executor.typesafe

fun main(args: Array<String>) {
    val count = 10

    val title = """
        |package com.github.jacokoo.kosql.executor.typesafe
        |
        |import com.github.jacokoo.kosql.compose.ParameterHolder
        |import com.github.jacokoo.kosql.compose.statements.SelectStatement
        |import com.github.jacokoo.kosql.compose.typesafe.*
        |import com.github.jacokoo.kosql.executor.SelectTemplate
        |import com.github.jacokoo.kosql.executor.SelectTemplateSupport
        |import com.github.jacokoo.kosql.executor.TemplateValue
        |
    """.trimMargin()

    fun classPart(it: Int) = """
        |
        |data class SelectTemplate$it<${times(it) { "T$it" }}>(override val statement: SelectStatement<Column$it<${times(it) { "T$it" }}>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column$it<${times(it) { "T$it" }}>>
    """.trimMargin()

    fun methodPart(it: Int) = """
        |
        |    fun <${times(it) { "T$it" }}> SelectStatement<Column$it<${times(it) { "T$it" }}>>.template() = builder.build(this).let { SelectTemplate$it(this, it.sql, it.params) }
        |    fun <${times(it) { "T$it" }}> SelectTemplate<Column$it<${times(it) { "T$it" }}>>.fetch(vararg values: TemplateValue) = SelectResult$it(statement.data.columns, fetch(SelectResultMapper$it(statement.data.columns), *values))
        |
    """.trimMargin()

    println(buildString {
        append(title)
        (1..count).forEach { append(classPart(it)) }
        append("\n\ninterface SelectTemplateSupports: SelectTemplateSupport {")
        (1..count).forEach { append(methodPart(it)) }
        append("\n}")
    })
}
