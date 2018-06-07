package com.github.jacokoo.kosql.compose.typesafe

fun main(args: Array<String>) {
    val count = 22

    val title = """
        |package com.github.jacokoo.kosql.compose.typesafe
        |
        |interface ValueList {
        |    val values: List<Any?>
        |    operator fun get(idx: Int): Any? = values[idx]
        |}
        |
        |data class Values(override val values: List<Any?>): ValueList
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
