package com.github.jacokoo.kosql.build

import com.github.jacokoo.kosql.compose.Named

interface Context {
    val builder: Builder
    fun alias(target: Named<*>): String?
    fun append(str: String)
    fun param(p: Any?)
    fun result(): BuildResult

    fun pad(str: String) {
        append(" $str ")
    }
}

open class DefaultContext(override val builder: Builder): Context {
    val sql = StringBuilder()
    val params = mutableListOf<Any?>()

    private val prefix = "a_"
    private var aliasIndex = 0
    private var aliasMap: MutableMap<Named<*>, String> = mutableMapOf()

    override fun alias(target: Named<*>): String? {
        if (target.alias.isNotBlank()) return target.alias
        if (aliasMap.contains(target)) return aliasMap[target]
        if (!target.aliasRequired) return null
        return "$prefix${aliasIndex++}".also {
            aliasMap[target] = it
        }
    }

    override fun append(str: String) {
        sql.append(str)
    }

    override fun param(p: Any?) {
        params.add(p)
    }

    override fun result(): BuildResult = BuildResult(sql.toString(), params)
}
