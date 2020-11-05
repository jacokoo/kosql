package com.github.jacokoo.kosql.generate.writer

import com.github.jacokoo.kosql.generate.KoSQLGeneratorConfig
import com.github.jacokoo.kosql.generate.TableInfo
import java.io.Writer

class TableWriterFactory: ClassWriterFactory {
    override fun create(writer: Writer, config: KoSQLGeneratorConfig, table: TableInfo): ClassWriter {
        return TableWriter(writer, config, table)
    }
}

class InnerTableWriterFactory: ClassWriterFactory {
    override fun create(writer: Writer, config: KoSQLGeneratorConfig, table: TableInfo): ClassWriter {
        return InnerTableWriter(writer, config, table)
    }
}

open class TableWriter(writer: Writer, val config: KoSQLGeneratorConfig, val table: TableInfo): AbstractClassWriter(writer) {
    private val tableName = config.namingStrategy.tableClassName(table.def.name)
    private val objectName = config.namingStrategy.tableObjectName(table.def.name)
    private val entityName = config.namingStrategy.entitySubClassName(table.def.name)
    private val pkType = table.primaryKey.dataClass.simpleName!!

    override fun writeSignature() {
        writer.write("open class $tableName protected constructor(override val inner: ${config.namingStrategy.innerTableClassName(table.def.name)}): Table<$pkType, $entityName>")
    }

    override fun writeFields() {
        table.columns.forEach {
            writer.write("    val ${config.namingStrategy.tableFieldName(it.def.name)} = inner.${config.namingStrategy.tableFieldName(it.def.name)}\n")
        }
    }

    override fun writeMethods() {
        writer.write("    val columns get() = Column")
        writer.write(if (table.columns.size > 10) "s(" else "${table.columns.size}(")
        writer.write(table.columns.map { config.namingStrategy.tableFieldName(it.def.name) }.joinToString())
        writer.write(")\n\n")
        writer.write("    override fun AS(alias: String) = $tableName(inner.AS(alias))\n")
        writer.write("    override fun primaryKey() = ${config.namingStrategy.tableFieldName(table.primaryKey.def.name)}\n")
        writer.write("    override fun createEntity(): $entityName = $entityName()")
    }

    override fun writeTail() {
        writer.write("\nobject $objectName: $tableName(${config.namingStrategy.innerTableObjectName(table.def.name)})\n")
    }
}

open class InnerTableWriter(writer: Writer, val config: KoSQLGeneratorConfig, val table: TableInfo): AbstractClassWriter(writer) {
    private val name = config.namingStrategy.innerTableClassName(table.def.name)
    private val entity = config.namingStrategy.entitySubClassName(table.def.name)

    override fun writeSignature() {
        writer.write("open class $name(alias: String = \"\"): " +
                "InnerTable<${table.primaryKey.dataClass.simpleName}, $entity>(\"${table.def.name}\", alias)")
    }

    override fun writeFields() {
        table.columns.forEach {
            writer.write("    val ${config.namingStrategy.tableFieldName(it.def.name)} = ${it.define}\n")
        }
    }

    override fun writeMethods() {
        writer.write("    override fun AS(alias: String) = $name(alias)\n")
    }

    override fun writeTail() {
        writer.write("private object ${config.namingStrategy.innerTableObjectName(table.def.name)}: $name()")
    }
}
