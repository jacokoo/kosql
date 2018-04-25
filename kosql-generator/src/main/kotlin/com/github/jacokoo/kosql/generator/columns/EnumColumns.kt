package com.github.jacokoo.kosql.generator.columns

import com.github.jacokoo.kosql.generator.*

class EnumColumnGenerator(private val useEnum: UseEnum<*>): ColumnGenerator {
    override fun support(tableName: String, def: ColumnDefinition): Boolean =
            useEnum.tableName == tableName && def.name == useEnum.columnName

    override fun generete(tableName: String, def: ColumnDefinition, config: KoSQLGeneratorConfig): ColumnInfo {
        val ns = config.namingStrategy
        val name = ns.tableFieldName(def.name)
        val type = "${ns.tableClassName(tableName)}${ns.entityFieldName(def.name).capitalize()}EnumType"
        val typeClass = useEnum.enumType.kotlin
        val defaultValue = "${useEnum.enumType.simpleName}.${useEnum.defaultValue.toString()}"
        val define = "createColumn(\"${def.name}\", $type, false, $defaultValue)"
        return ColumnInfo(name, "${config.outputPackage}.kosql.$type", typeClass, defaultValue, define, def)
    }
}
