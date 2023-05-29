package com.github.jacokoo.kosql.generate

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.statement.Columns
import com.github.jacokoo.kosql.compose.type.DataType
import com.github.jacokoo.kosql.compose.type.generate.ColumnDefinition
import com.github.jacokoo.kosql.compose.type.generate.ColumnFactory
import com.github.jacokoo.kosql.compose.type.generate.ColumnType
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

data class TableDefinition(
    val name: String,
    val primaryKey: String,
    val columns: List<ColumnDefinition>
)

data class FieldInfo(
    val columnName: String,
    val type: String,
    val value: String
)

data class EntityInfo(
    val fields: List<FieldInfo>
)

data class TableInfo(
    val primaryKey: ColumnInfo,
    val imports: Imports,
    val columns: List<ColumnInfo>,
    val entity: EntityInfo,
    val def: TableDefinition
)

data class ColumnInfo(
    val typeClass: KClass<*>,  // IntType
    val typeSimpleName: String, // Int
    val importClass: KClass<*>?, // kotlin.Int
    val defaultValue: String,
    val define: String,
    val def: ColumnDefinition
)

private class KClassWrap<T: Any>(
        private val full: String,
        private val simple: String,
        private val inner: KClass<T>
): KClass<T> by inner {
    override val simpleName: String?
        get() = simple

    override val qualifiedName: String?
        get() = full
}

class Imports(private val imports: MutableSet<String> = mutableSetOf()) {

    fun add(vararg kc: KClass<*>) = this.also { it.imports.addAll(kc.map { it.qualifiedName!! }) }
    fun add(vararg s: String) = this.also { it.imports.addAll(s) }

    fun forEach(block: (String) -> Unit) {
        filter().forEach(block)
    }

    fun map(block: (String) -> String): List<String> = filter().map(block)

    private fun filter() = imports
        .filter { !it.startsWith("java.lang") }
        .filter { it.isNotBlank() }
        .filter { !it.contains('.') || it.substring(0, it.lastIndexOf(".")) != "kotlin" }.sorted()
}

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

        val entityName = config.namingStrategy.entitySubClassName(table.name)

        val columns = table.columns.map { generateColumn(table.name, table.primaryKey, entityName, it, config, imports) }
        columns.forEach { imports.add(it.typeClass) }

        val pk = table.columns.indexOf(table.columns.find { it.name == table.primaryKey }!!)
        val fields = columns.map {
            imports.add(it.typeClass)
            if (it.importClass != null) imports.add(it.importClass)
            val type = it.typeSimpleName
            FieldInfo(it.def.name, type!!, it.defaultValue)
        }

        imports.add("${config.outputPackage}.entity.${config.namingStrategy.entitySubClassName(table.name)}")

        return TableInfo(columns[pk], imports, columns, EntityInfo(fields), table)
    }

    fun generateColumn(name: String, pk: String, entityName: String, col: ColumnDefinition, config: KoSQLGeneratorConfig, imports: Imports): ColumnInfo =
        config.useEnum(name, col.name)?.let {
            val type = config.typeName(it, config.namingStrategy.entitySubClassName(name))
            val defaultValue = "${it.ref}.${it.default}"
            val t = KClassWrap("${config.basePackage()}.$type", type, Any::class)
            ColumnInfo(
                t, it.ref, null, defaultValue,
                "createColumn(\"${col.name}\", $type(), false, $defaultValue)", col
            )
        } ?: getColumnInfo(ColumnFactory().generate(name, col).also {
            imports.add(*it.extraImports())
        }, col, pk == col.name, config)


    private fun getColumnInfo(type: ColumnType, col: ColumnDefinition, isPrimaryKey: Boolean, config: KoSQLGeneratorConfig): ColumnInfo {
        val dv = type.parseDefaultValue(col.defaultValue)
        val def = when(isPrimaryKey) {
            true -> """createPrimaryKey("${col.name}", ${type.type.simpleName}(), ${col.isAutoIncrement})"""
            false -> """createColumn("${col.name}", ${type.type.simpleName}(), ${col.nullable}, $dv, ${col.isAutoIncrement})"""
        }
        return ColumnInfo(type.type, type.dataType.simpleName!!, type.dataType, dv, def, col)
    }
}
