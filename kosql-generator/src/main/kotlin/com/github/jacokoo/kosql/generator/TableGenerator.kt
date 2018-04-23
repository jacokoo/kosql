package com.github.jacokoo.kosql.generator

data class TableDefinition(
    val name: String,
    val primaryKey: String,
    val columns: List<ColumnDefinition>
)

data class FieldInfo(
    val name: String
)

data class TableInfo(
    val tableName: String,
    val objectName: String,
    val tableImports: List<String>,
    val entityName: String,
    val entityImports: List<String>
)

interface TableGenerator {

    fun generate()

}