package com.github.jacokoo.kosql.generator

import java.io.Writer

class EntitySubWriterFactory: ClassWriterFactory {
    override fun create(writer: Writer, config: KoSQLGeneratorConfig, table: TableInfo): ClassWriter {
        return EntitySubWriter(writer, config, table)
    }
}

open class EntitySubWriter(writer: Writer, val config: KoSQLGeneratorConfig, val table: TableInfo): AbstractClassWriter(writer) {
    override fun writePackage() {
        writer.write("package ${config.outputPackage}.entity\n")
    }

    override fun writeImports() {
        writer.write("import ${config.outputPackage}.kosql.${table.entity.name}\n")
    }

    override fun writeSignature() {
        writer.write("class ${config.namingStrategy.entitySubClassName(table.def.name)}: ${table.entity.name}")
    }

    override fun writeFields() {
    }

    override fun writeMethods() {
        val name = config.namingStrategy.entitySubClassName(table.def.name)
        writer.write("""
            |    constructor(): super()
            |    constructor(other: $name): super(other)
            |
            |    fun copy(block: ($name) -> Unit): $name = $name(this).also(block)
            |
            |
        """.trimMargin())
    }
}
