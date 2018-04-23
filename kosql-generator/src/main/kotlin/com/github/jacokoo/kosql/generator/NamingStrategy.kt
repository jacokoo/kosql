package com.github.jacokoo.kosql.generator

interface NamingStrategy {

    fun tableClassName(tableName: String): String
    fun tableObjectName(tableName: String): String
    fun tableFieldName(columnName: String): String

    fun entityClassName(tableName: String): String
    fun entityFieldName(columnName: String): String

}

open class DefaultNamingStrategy: NamingStrategy {

    override fun tableClassName(tableName: String) = normal(tableName).capitalize() + "Table"
    override fun tableObjectName(tableName: String) = normal(tableName).toUpperCase()
    override fun tableFieldName(columnName: String) = normal(columnName).toUpperCase()
    override fun entityClassName(tableName: String) = normal(tableName).capitalize()
    override fun entityFieldName(columnName: String) = normal(columnName)

    fun removePrefix(name: String) =
            if (name.startsWith("f_", true) || name.startsWith("t_", true)) {
                name.slice(2..name.length)
            } else name

    fun removeUnderscore(name: String) = name.split("_").reduce{acc, i -> acc + i.capitalize()}

    fun normal(name: String) = removeUnderscore(removePrefix(name))

}