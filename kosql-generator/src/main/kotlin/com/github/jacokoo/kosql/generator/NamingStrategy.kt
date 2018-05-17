package com.github.jacokoo.kosql.generator

interface NamingStrategy {

    fun databaseClassName(name: String): String

    fun tableClassName(tableName: String): String
    fun tableObjectName(tableName: String): String
    fun tableFieldName(columnName: String): String

    fun entityClassName(tableName: String, needSubClass: Boolean): String
    fun entityFieldName(columnName: String): String

    fun entitySubClassName(tableName: String): String
}

open class DefaultNamingStrategy: NamingStrategy {

    override fun databaseClassName(name: String) = removeUnderscore(name).capitalize() + "Database"

    override fun tableClassName(tableName: String) = normal(tableName).capitalize() + "Table"
    override fun tableObjectName(tableName: String) = removePrefix(tableName).toUpperCase()
    override fun tableFieldName(columnName: String) = removePrefix(columnName).toUpperCase()
    override fun entityClassName(tableName: String, needSubClass: Boolean) = entitySubClassName(tableName).let {
        if (needSubClass) it + "Base" else it
    }
    override fun entityFieldName(columnName: String) = normal(columnName)
    override fun entitySubClassName(tableName: String) = normal(tableName).capitalize()
    fun removePrefix(name: String) =
            if (name.startsWith("f_", true) || name.startsWith("t_", true)) {
                name.slice(2..(name.length-1))
            } else name

    fun removeUnderscore(name: String) = name.split("_").reduce{acc, i -> acc + i.capitalize()}

    fun normal(name: String) = removeUnderscore(removePrefix(name))
}
