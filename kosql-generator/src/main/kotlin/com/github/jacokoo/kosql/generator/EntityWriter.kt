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
        val getter: (Int, ColumnInfo) -> String = {idx, it ->
            "        ${table.objectName}.${it.name}.name -> this.${table.entity.fields[idx].name}"
        }
        val setter: (Int, ColumnInfo) -> String = {idx, it ->
            "            ${table.objectName}.${it.name}.name -> this.${table.entity.fields[idx].name} = value as ${it.typeClass.simpleName}"
        }
        writer.write("""
            |    override fun get(name: String): Any? = when(name) {
            |${table.columns.mapIndexed(getter).joinToString("\n")}
            |        else -> null
            |    }
            |
            |    override fun set(name: String, value: Any?) {
            |        when (name) {
            |${table.columns.mapIndexed(setter).joinToString("\n")}
            |        }
            |    }
            |
            |    fun copy(block: (${table.entity.name}) -> Unit): ${table.entity.name} = ${table.entity.name}().also {
            |${table.entity.fields.map { "        it.${it.name} = ${it.name}" }.joinToString("\n") }
            |        block(it)
            |    }
            |
            |    override fun toString(): String = buildString {
            |        append("${table.entity.name} (")
            |        append("${table.entity.fields.map { "${it.name} = \$${it.name}" }.joinToString()}")
            |        append(")")
            |    }
        """.trimMargin())
    }
}