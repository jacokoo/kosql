package com.github.jacokoo.kosql.generator

import com.github.jacokoo.kosql.compose.Database
import com.github.jacokoo.kosql.compose.IntEnumType
import com.github.jacokoo.kosql.compose.StringEnumType
import com.github.jacokoo.kosql.generator.columns.*
import org.springframework.jdbc.core.JdbcTemplate
import java.io.File
import java.sql.Connection
import java.sql.DatabaseMetaData
import kotlin.reflect.KClass

data class UseEnum<T: Enum<*>>(
        val tableName: String,
        val columnName: String,
        val enumType: Class<out T>,
        val dbType: KClass<*>,
        val defaultValue: T
) {
    companion object {
        fun <T: Enum<*>> int(table: String, column: String, enumType: Class<T>, defaultValue: T) =
                UseEnum(table, column, enumType, Int::class, defaultValue)

        fun <T: Enum<*>> str(table: String, column: String, enumType: Class<T>, defaultValue: T) =
                UseEnum(table, column, enumType, String::class, defaultValue)
    }
}

data class KoSQLGeneratorConfig(
        val outputDirectory: String,
        val outputPackage: String,
        val namingStrategy: NamingStrategy = DefaultNamingStrategy(),
        val columnGenerators: List<ColumnGenerator> = listOf(
                BooleanColumnGenerator(),
                DateColumnGenerator(), DateTimeColumnGenerator(), DateTimeLongColumnGenerator(),
                StringColumnGenerator(), ByteArrayColumnGenerator(),
                IntColumnGenerator(), LongColumnGenerator(), FloatColumnGenerator(),
                DoubleColumnGenerator(), DecimalColumnGenerator()
        ),
        val tableGenerator: TableGenerator = DefaultTableGenerator(),
        val entityWriterFactory: ClassWriterFactory = EntityWriterFactory(),
        val entitySubWriterFactory: EntitySubWriterFactory = EntitySubWriterFactory(),
        val tableWriterFactory: TableWriterFactory = TableWriterFactory(),
        val useEnums: List<UseEnum<*>> = listOf(),
        val needEntitySubClass: Boolean = false
) {
    fun root() = File(outputDirectory, outputPackage.replace(".", "/"))
    fun dir() = File(root(), "kosql")
}

open class KoSQLGenerator(cfg: KoSQLGeneratorConfig, val jdbc: JdbcTemplate) {
    private val config = cfg.copy(columnGenerators = cfg.useEnums.map { EnumColumnGenerator(it) } + cfg.columnGenerators)

    fun doGenerate() {
        val (name, list) = jdbc.execute { conn: Connection ->
            val meta = conn.metaData
            conn.catalog!! to tableNames(meta).associate { it to primaryKey(it, meta) }.map { (k, v) ->
                if (v == null) throw RuntimeException("table $k have no primary key")
                TableDefinition(k, v, columns(k, meta))
            }.map { config.tableGenerator.generate(it, config) }
        }!!

        config.dir().also {
            if (it.exists()) it.deleteRecursively()
            it.mkdirs()
        }
        writeDatabase(config.namingStrategy.databaseClassName(name), list)
        writeFiles(list)
    }

    fun writeDatabase(name: String, ts: List<TableInfo>) {
        var imports = Imports().add(Database::class)
        ts.forEach {
            it.entitySub?.let {
                imports.add("${config.outputPackage}.entity.${it.name}")
            }
        }
        File(config.dir(), "$name.kt").also {
            if (it.exists()) it.delete()
            it.createNewFile()

            it.writer().use {
                it.write("""
                    |package ${config.outputPackage}.kosql
                    |
                    |${imports.map { "import $it" }.joinToString("\n")}
                    |
                    |object $name: Database {
                    |    init {
                    |${ts.map { "        Database.register(${it.objectName}, ${it.entitySub?.let { it.name } ?: it.entity.name}::class)" }.joinToString("\n")}
                    |    }
                    |}
                """.trimMargin())
            }
        }
    }

    fun writeFiles(ts: List<TableInfo>) {
        val dir = config.dir()

        ts.forEach { table ->
            File(dir, "${table.tableName}.kt").also {
                if (it.exists()) it.delete()
                it.createNewFile()
            }.writer().use { writer ->
                val enums = config.useEnums.filter { it.tableName == table.def.name && table.columns.any { col -> col.def.name == it.columnName } }
                val imports = table.imports
                enums.forEach { imports.add(if (it.dbType == Int::class) IntEnumType::class else StringEnumType::class) }

                val pkg = "${config.outputPackage}.kosql"
                writer.appendln("package $pkg")
                writer.appendln()
                imports.forEach {
                    if (it.substring(0, it.lastIndexOf(".")) != pkg) writer.appendln("import ${it}")
                }

                enums.forEach {
                    EnumWriter().write(writer, it, config.namingStrategy)
                }

                config.entityWriterFactory.create(writer, config, table).doWrite()
                config.tableWriterFactory.create(writer, config, table).doWrite()
            }

            table.entitySub?.also { info -> writeEntitySub(table, info)}
        }
    }

    fun writeEntitySub(table: TableInfo, info: EntitySubInfo) {
        val dir = File(config.root(), "entity").also {
            if (!it.exists()) it.mkdirs()
        }

        File(dir, "${config.namingStrategy.entitySubClassName(info.name)}.kt").also {
            if (!it.exists()) {
                it.createNewFile()
                it.writer().use { writer ->
                    config.entitySubWriterFactory.create(writer, config, table).doWrite()
                }
            }
        }

    }


    fun primaryKey(name: String, meta: DatabaseMetaData): String? {
        val rs = meta.getPrimaryKeys(null, null, name)
        if (!rs.next()) {
            rs.close()
            return null
        }

        return rs.getString("COLUMN_NAME")
    }

    fun columns(name: String, meta: DatabaseMetaData): List<ColumnDefinition> {
        var list = mutableListOf<ColumnDefinition>()
        val rs = meta.getColumns(null, null, name, null)
        while (rs.next()) list.add(ColumnDefinition.fromResultSet(rs))
        rs.close()
        return list
    }

    fun tableNames(meta: DatabaseMetaData): List<String> {
        var list = mutableListOf<String>()
        val rs = meta.getTables(null, null, null, arrayOf("TABLE"))
        while (rs.next()) {
            list.add(rs.getString("TABLE_NAME"))
        }
        rs.close()
        return list
    }
}
