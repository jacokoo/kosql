package com.github.jacokoo.kosql.generator

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Columns

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
    val fields: List<FieldInfo>
)

data class EntitySubInfo(
    val name: String
)

data class TableInfo(
    val tableName: String,
    val primaryKey: ColumnInfo,
    val objectName: String,
    val imports: Imports,
    val columns: List<ColumnInfo>,
    val entity: EntityInfo,
    val entitySub: EntitySubInfo?,
    val def: TableDefinition
)

interface TableGenerator {
    fun generate(table: TableDefinition, config: KoSQLGeneratorConfig): TableInfo
}

class DefaultTableGenerator: TableGenerator {
    override fun generate(table: TableDefinition, config: KoSQLGeneratorConfig): TableInfo {
        val imports = Imports()
            .add(Table::class, Entity::class)
            .add(
                if (table.columns.size > 10) Columns::class.java.name
                else "com.github.jacokoo.kosql.compose.typesafe.Column${table.columns.size}"
            )

        val columns = table.columns.map { generateColumn(table.name, it, config) }
        columns.forEach { imports.add(it.typeClass).add(it.type) }

        val pk = table.columns.indexOf(table.columns.find { it.name == table.primaryKey }!!)
        val fields = columns.map {
            imports.add(it.typeClass)
            val type = if (it.def.nullable) it.typeClass.simpleName + "?" else it.typeClass.simpleName
            FieldInfo(config.namingStrategy.entityFieldName(it.def.name), type!!, it.defaultValue)
        }

        val entityName = config.namingStrategy.entityClassName(table.name, config.needEntitySubClass)
        val tableName = config.namingStrategy.tableClassName(table.name)
        val objectName = config.namingStrategy.tableObjectName(table.name)

        var entitySub: EntitySubInfo? = null;
        if (config.needEntitySubClass) {
            entitySub = EntitySubInfo(config.namingStrategy.entitySubClassName(table.name))
            imports.add("${config.outputPackage}.entity.${entitySub.name}")
        }
        return TableInfo(tableName, columns[pk], objectName, imports, columns, EntityInfo(entityName, fields), entitySub, table)
    }

    fun generateColumn(name: String, col: ColumnDefinition, config: KoSQLGeneratorConfig): ColumnInfo {
        return config.columnGenerators.find { it.support(name, col) }?.generete(name, col, config) ?:
            throw RuntimeException("column ${col.name} in table $name is not supported, $col")
    }
}
