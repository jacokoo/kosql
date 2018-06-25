package com.github.jacokoo.kosql.generator

import java.io.Writer

class TableWriterFactory: ClassWriterFactory {
    override fun create(writer: Writer, config: KoSQLGeneratorConfig, table: TableInfo): ClassWriter {
        return TableWriter(writer, config, table)
    }
}

open class TableWriter(writer: Writer, val config: KoSQLGeneratorConfig, val table: TableInfo): AbstractClassWriter(writer) {
    override fun writePackage() {
    }

    override fun writeImports() {
    }

    override fun writeSignature() {
        val pk = table.primaryKey
        val name = table.entitySub?.let { table.entitySub.name } ?: table.entity.name
        writer.write("open class ${table.tableName} protected constructor(alias: String = \"\"):" +
                " Table<${pk.typeClass.simpleName}, $name>(\"${table.def.name}\", alias, \"\")")
    }

    override fun writeFields() {
        table.columns.forEach {
            writer.write("    val ${it.name} = ${it.define}\n")
        }
    }

    override fun writeMethods() {
        writer.write("    override fun AS(alias: String) = ${table.tableName}(alias)\n")
        writer.write("    override fun primaryKey() = ${table.primaryKey.name}\n")
        writer.write("    operator fun unaryMinus() = Column")
        writer.write(if (table.columns.size > 22) "s" else "${table.columns.size}(")
        writer.write(table.columns.map { it.name }.joinToString())
        writer.write(")\n")
    }

    override fun writeTail() {
        writer.write("\nobject ${table.objectName}: ${table.tableName}()\n")
    }
}
