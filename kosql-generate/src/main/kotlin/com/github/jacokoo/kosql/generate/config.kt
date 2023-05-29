package com.github.jacokoo.kosql.generate

import com.github.jacokoo.kosql.compose.EnumType
import com.github.jacokoo.kosql.generate.writer.*
import java.io.File

data class EnumDef(val name: String, val values: List<String>)
data class UseEnum(val tableName: String, val columnName: String, val ref: String, val default: String, val type: EnumType)

data class KoSQLGeneratorConfig(
    val driverClass: String,
    val connectionUri: String,
    val outputDirectory: String,
    val outputPackage: String,
    val namingStrategy: NamingStrategy = DefaultNamingStrategy(),
    val tableGenerator: TableGenerator = DefaultTableGenerator(),
    val entityWriterFactory: ClassWriterFactory = EntityWriterFactory(),
    val entitySubWriterFactory: EntitySubWriterFactory = EntitySubWriterFactory(),
    val tableWriterFactory: TableWriterFactory = TableWriterFactory(),
    val innerTableWriterFactory: InnerTableWriterFactory = InnerTableWriterFactory(),
    val enums: Map<String, EnumDef> = mapOf(),
    val useEnums: Map<String, UseEnum> = mapOf()
) {
    fun basePackage() = "$outputPackage.kosql"
    fun entityPackage() = "$outputPackage.entity"

    fun baseDir() = File(outputDirectory, basePackage().replace(".", "/"))
    fun entityDir() = File(outputDirectory, entityPackage().replace(".", "/"))

    fun typeName(it: UseEnum, entityName: String) =
        "$entityName${namingStrategy.entityFieldName(it.columnName).toCap()}EnumType"

    fun useEnum(tableName: String, columnName: String) = useEnums["$tableName-$columnName"]
}
