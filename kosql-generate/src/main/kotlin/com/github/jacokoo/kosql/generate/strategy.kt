package com.github.jacokoo.kosql.generate

interface NamingStrategy {
    fun innerTableClassName(tableName: String): String
    fun innerTableObjectName(tableName: String): String
    fun tableClassName(tableName: String): String
    fun tableObjectName(tableName: String): String
    fun tableFieldName(columnName: String): String

    fun entityClassName(tableName: String): String
    fun entityFieldName(columnName: String): String

    fun entitySubClassName(tableName: String): String

    fun tableFileName(tableName: String): String
    fun entityFileName(tableName: String): String
    fun enumFileName(): String
}

open class DefaultNamingStrategy: NamingStrategy {
    override fun innerTableClassName(tableName: String) = normal(tableName).toCap() + "InnerTable"
    override fun innerTableObjectName(tableName: String) = "INNER_" + removePrefix(tableName).uppercase()
    override fun tableClassName(tableName: String) = normal(tableName).toCap() + "Table"
    override fun tableObjectName(tableName: String) = removePrefix(tableName).uppercase()
    override fun tableFieldName(columnName: String) = removePrefix(columnName).uppercase()
    override fun entityClassName(tableName: String) = "${normal(tableName).toCap()}Base"
    override fun entityFieldName(columnName: String) = normal(columnName)
    override fun entitySubClassName(tableName: String) = normal(tableName).toCap()
    override fun tableFileName(tableName: String) = tableClassName(tableName)
    override fun entityFileName(tableName: String) = entitySubClassName(tableName)
    override fun enumFileName() = "Enums"

    fun removePrefix(name: String) =
        if (name.startsWith("f_", true) || name.startsWith("t_", true)) {
            name.slice(2 until name.length)
        } else name

    fun removeUnderscore(name: String) = name.split("_").reduce { acc, i -> acc + i.toCap() }
    fun normal(name: String) = removeUnderscore(removePrefix(name))
}

open class LowercaseFileNameStrategy: DefaultNamingStrategy() {
    override fun tableFileName(tableName: String) = toHyper(removePrefix(tableName))
    override fun entityFileName(tableName: String) = toHyper(removePrefix(tableName))
    override fun enumFileName() = "enum"

    private fun toHyper(name: String) = name.split("_").reduce { acc, i -> "$acc-$i"}
}

internal fun String.toCap() = replaceFirstChar { it.uppercaseChar() }
