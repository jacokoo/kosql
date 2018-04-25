package com.github.jacokoo.kosql.generator

import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.mapping.Database
import com.github.jacokoo.kosql.mapping.Entity
import com.github.jacokoo.kosql.statements.Columns

data class TableDefinition(
    val name: String,
    val primaryKey: String,
    val columns: List<ColumnDefinition>
)

data class FieldInfo(
    val name: String,
    val type: String,
    val value: String
)

data class EntityInfo(
    val name: String,
    val imports: Imports,
    val fields: List<FieldInfo>
)

data class TableInfo(
    val tableName: String,
    val primaryKey: ColumnInfo,
    val objectName: String,
    val imports: Imports,
    val columns: List<ColumnInfo>,
    val entity: EntityInfo,
    val def: TableDefinition
)

interface TableGenerator {
    fun generate(table: TableDefinition, config: KoSQLGeneratorConfig): TableInfo
}

class DefaultTableGenerator: TableGenerator {
    override fun generate(table: TableDefinition, config: KoSQLGeneratorConfig): TableInfo {
        var imports = Imports()
            .add(Table::class, Database::class)
            .add(
                if (table.columns.size > 22) Columns::class.qualifiedName!!
                else "com.github.jacokoo.kosql.statements.Column${table.columns.size}"
            )
        var entityImports = Imports()
                .add(Entity::class)


        val columns = table.columns.map { generateColumn(table.name, it, config) }
        columns.forEach { imports = imports.add(it.typeClass).add(it.type) }

        val pk = table.columns.indexOf(table.columns.find { it.name == table.primaryKey }!!)
        val fields = columns.map {
            entityImports = entityImports.add(it.typeClass)
            val type = if (it.def.nullable) it.typeClass.simpleName + "?" else it.typeClass.simpleName
            FieldInfo(config.namingStrategy.entityFieldName(it.def.name), type!!, it.defaultValue)
        }

        val entityName = config.namingStrategy.entityClassName(table.name)
        val tableName = config.namingStrategy.tableClassName(table.name)
        val objectName = config.namingStrategy.tableObjectName(table.name)

        entityImports = entityImports
            .add("${config.outputPackage}.kosql.table.$tableName")
            .add("${config.outputPackage}.kosql.table.$objectName")

        return TableInfo(tableName, columns[pk], objectName, imports, columns, EntityInfo(entityName, entityImports, fields), table)
    }

    fun generateColumn(name: String, col: ColumnDefinition, config: KoSQLGeneratorConfig): ColumnInfo {
        return config.columnGenerators.find { it.support(name, col) }?.generete(name, col, config) ?:
            throw RuntimeException("column ${col.name} in table $name is not supported")
    }
}