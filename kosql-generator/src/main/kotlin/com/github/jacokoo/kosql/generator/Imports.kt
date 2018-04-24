package com.github.jacokoo.kosql.generator

import kotlin.reflect.KClass

data class Imports(private val imports: Set<String>) {
    constructor(): this(setOf())

    fun add(vararg kc: KClass<*>) = Imports(imports + kc.map { it.qualifiedName!! })
    fun add(vararg c: Class<*>) = Imports(imports + c.map { it.name!! })
    fun add(vararg s: String) = Imports(imports + s)

    fun forEach(block: (String) -> Unit) {
        filter().forEach(block)
    }

    fun map(block: (String) -> String): List<String> = filter().map(block)

    private fun filter() = imports
            .filter { !it.startsWith("java.lang") }
            .filter { it.substring(0, it.lastIndexOf(".")) != "kotlin" }.sorted()
}