package com.github.jacokoo.kosql.generator

import java.io.Writer

class EntityWriterFactory: ClassWriterFactory {
    override fun create(writer: Writer, config: KoSQLGeneratorConfig, table: TableInfo): ClassWriter {
        return EntityWriter(writer, config, table)
    }
}

open class EntityWriter(writer: Writer, val config: KoSQLGeneratorConfig, val table: TableInfo): AbstractClassWriter(writer) {
    override fun writePackage() {
        writer.write("package ${config.outputPackage}.kosql.entity\n")
    }

    override fun writeImports() {
        table.entity.imports.forEach { writer.write("import $it\n") }
    }

    override fun writeSignature() {
        val pk = table.primaryKey
        writer.write("open class ${table.entity.name}: Entity<${pk.typeClass.simpleName}, ${table.tableName}>")
    }

    override fun writeFields() {
        table.entity.fields.forEach {
            writer.write("    var ${it.name}: ${it.type} = ${it.value}\n")
        }
    }

    override fun writeMethods() {
        writer.write("    override fun get(name: String): Any? = when(name) {\n")
        (0 until table.columns.size).forEach {
            writer.write("        ${table.objectName}.${table.columns[it].name}.name -> this.${table.entity.fields[it].name}\n")
        }
        writer.write("        else -> null\n    }\n\n")

        writer.write("    override fun set(name: String, value: Any?) {\n")
        writer.write("        when (name) {\n")
        (0 until table.columns.size).forEach {
            writer.write("            ${table.objectName}.${table.columns[it].name}.name -> ")
            writer.write("this.${table.entity.fields[it].name} = value as ${table.columns[it].typeClass.simpleName}\n")
        }
        writer.write("        }\n")
        writer.write("    }\n\n")
    }
}