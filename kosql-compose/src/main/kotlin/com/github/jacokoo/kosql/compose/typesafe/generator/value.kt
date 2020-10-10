package com.github.jacokoo.kosql.compose.typesafe.generator

internal fun times(n: Int, b: (Int) -> String): String = (1..n).joinToString { b(it) }

fun main() {
    val count = 10

    val title = """
        |package com.github.jacokoo.kosql.compose.typesafe
        |
        |import com.github.jacokoo.kosql.compose.statement.ValueList
        |import com.github.jacokoo.kosql.compose.statement.Values
        |
        |
    """.trimMargin()

    fun classPart(it: Int) = """
        |data class Value$it<${times(it) { "T$it" }}>(${times(it) { "val v$it: T$it" }}, override val values: List<Any?> = listOf(${times(it) { "v$it" }})): ValueList
        |
    """.trimMargin()

    fun bodyPart(it: Int) = """
        |    fun <${times(it) { "T$it" }}> V(${times(it) { "v$it: T$it" }}) = Value$it(${times(it) { "v$it" }})
        |
    """.trimMargin()

    println(buildString {
        append(title)
        (1..count).forEach { append(classPart(it)) }
        append("\ninterface ValueSupport {\n")
        append("    fun V(list: List<Any?>) = Values(list)\n")
        (1..count).forEach { append(bodyPart(it)) }
        append("}")
    })
}
