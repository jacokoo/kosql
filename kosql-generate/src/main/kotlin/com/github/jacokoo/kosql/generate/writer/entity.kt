package com.github.jacokoo.kosql.generate.writer


import com.github.jacokoo.kosql.generate.ColumnInfo
import com.github.jacokoo.kosql.generate.KoSQLGeneratorConfig
import com.github.jacokoo.kosql.generate.TableInfo
import java.io.Writer

class EntityWriterFactory: ClassWriterFactory {
    override fun create(writer: Writer, config: KoSQLGeneratorConfig, table: TableInfo): ClassWriter {
        return EntityWriter(writer, config, table)
    }
}

open class EntityWriter(writer: Writer, val config: KoSQLGeneratorConfig, val table: TableInfo): AbstractClassWriter(writer) {
    private val tableName = config.namingStrategy.tableClassName(table.def.name)
    private val objectName = config.namingStrategy.tableObjectName(table.def.name)
    private val entityName = config.namingStrategy.entityClassName(table.def.name)
    private val pkType = table.primaryKey.dataClass.simpleName!!

    private fun ename(name: String) = config.namingStrategy.entityFieldName(name)
    private fun tname(name: String) = config.namingStrategy.tableFieldName(name)

    override fun writeSignature() {
        writer.write("open class $entityName(): Entity<$pkType>")
    }

    override fun writeFields() {
        table.entity.fields.forEach {
            writer.write("    var ${ename(it.columnName)}: ${it.type} = ${it.value}\n")
        }
    }

    override fun writeMethods() {
        val getter: (Int, ColumnInfo) -> String = {idx, it ->
            "        $objectName.${tname(it.def.name)}.name -> this.${ename(table.entity.fields[idx].columnName)}"
        }
        val setter: (Int, ColumnInfo) -> String = {idx, it ->
            "            $objectName.${tname(it.def.name)}.name -> this.${ename(table.entity.fields[idx].columnName)} = value as ${it.dataClass.simpleName}"
        }
        writer.write("""
            |    constructor(other: $entityName): this() {
            |${table.entity.fields.map { "        this.${ename(it.columnName)} = other.${ename(it.columnName)}" }.joinToString("\n") }
            |    }
            |
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
            |    override fun toString(): String = buildString {
            |        append("$entityName (")
            |        append("${table.entity.fields.map { "${ename(it.columnName)} = \$${ename(it.columnName)}" }.joinToString()}")
            |        append(")")
            |    }
            |
            |    override fun innerTable(): InnerTable<$pkType, Entity<$pkType>> = ${config.namingStrategy.innerTableObjectName(table.def.name)}
            |
        """.trimMargin())
    }
}

class EntitySubWriterFactory: ClassWriterFactory {
    override fun create(writer: Writer, config: KoSQLGeneratorConfig, table: TableInfo): ClassWriter {
        return EntitySubWriter(writer, config, table)
    }
}

open class EntitySubWriter(writer: Writer, val config: KoSQLGeneratorConfig, val table: TableInfo): AbstractClassWriter(writer) {
    private val entityName = config.namingStrategy.entityClassName(table.def.name)
    override fun writePackage() {
        writer.write("package ${config.outputPackage}.entity\n")
    }

    override fun writeImports() {
        writer.write("import ${config.outputPackage}.kosql.$entityName\n")
    }

    override fun writeSignature() {
        writer.write("class ${config.namingStrategy.entitySubClassName(table.def.name)}: $entityName")
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
