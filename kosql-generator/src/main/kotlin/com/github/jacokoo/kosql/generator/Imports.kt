package com.github.jacokoo.kosql.generator

import kotlin.reflect.KClass

class Imports(private val imports: MutableSet<String> = mutableSetOf()) {

    fun add(vararg kc: KClass<*>) = this.also { it.imports.addAll(kc.map { it.qualifiedName!! }) }
    fun add(vararg c: Class<*>) = this.also { it.imports.addAll(c.map { it.name!! }) }
    fun add(vararg s: String) = this.also { it.imports.addAll(s) }

    fun forEach(block: (String) -> Unit) {
        filter().forEach(block)
    }

    fun map(block: (String) -> String): List<String> = filter().map(block)

    private fun filter() = imports
        .filter { !it.startsWith("java.lang") }
        .filter { it.substring(0, it.lastIndexOf(".")) != "kotlin" }.sorted()
}
