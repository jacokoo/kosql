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
}

open class DefaultNamingStrategy: NamingStrategy {
    override fun innerTableClassName(tableName: String) = normal(tableName).capitalize() + "InnerTable"
    override fun innerTableObjectName(tableName: String) = "INNER_" + removePrefix(tableName).toUpperCase()
    override fun tableClassName(tableName: String) = normal(tableName).capitalize() + "Table"
    override fun tableObjectName(tableName: String) = removePrefix(tableName).toUpperCase()
    override fun tableFieldName(columnName: String) = removePrefix(columnName).toUpperCase()
    override fun entityClassName(tableName: String) = "${normal(tableName).capitalize()}Base"
    override fun entityFieldName(columnName: String) = normal(columnName)
    override fun entitySubClassName(tableName: String) = normal(tableName).capitalize()

    open fun removePrefix(name: String) =
        if (name.startsWith("f_", true) || name.startsWith("t_", true)) {
            name.slice(2 until name.length)
        } else name

    open fun removeUnderscore(name: String) = name.split("_").reduce{acc, i -> acc + i.capitalize()}
    open fun normal(name: String) = removeUnderscore(removePrefix(name))
}
