package com.github.jacokoo.kosql.generator

import com.github.jacokoo.kosql.generator.columns.*
import com.github.jacokoo.kosql.mapping.Database
import org.springframework.jdbc.core.JdbcTemplate
import java.io.File
import java.sql.Connection
import java.sql.DatabaseMetaData

data class KoSQLGeneratorConfig(
        val outputDirectory: String,
        val outputPackage: String,
        val namingStrategy: NamingStrategy = DefaultNamingStrategy(),
        val columnGenerators: List<ColumnGenerator> = listOf(
                BooleanColumnGenerator(),
                DateColumnGenerator(), DateTimeColumnGenerator(), DateTimeLongColumnGenerator(),
                StringColumnGenerator(),
                IntColumnGenerator(), LongColumnGenerator(), FloatColumnGenerator(),
                DoubleColumnGenerator(), DecimalColumnGenerator()
        ),
        val tableGenerator: TableGenerator = DefaultTableGenerator(),
        val entityWriterFactory: ClassWriterFactory = EntityWriterFactory(),
        val tableWriterFactory: TableWriterFactory = TableWriterFactory()
)


open class KoSQLGenerator(val config: KoSQLGeneratorConfig, val jdbc: JdbcTemplate) {

    companion object {

    }

    fun doGenerate() {
        val (name, list) = jdbc.execute { conn: Connection ->
            val meta = conn.metaData
            conn.catalog!! to tableNames(meta).associate { it to primaryKey(it, meta) }.map { (k, v) ->
                if (v == null) throw RuntimeException("table $k have no primary key")
                TableDefinition(k, v, columns(k, meta))
            }.map { config.tableGenerator.generate(it, config) }
        }!!
        writeFiles(list)
        writeDatabase(config.namingStrategy.databaseClassName(name), list)
    }

    fun writeDatabase(name: String, ts: List<TableInfo>) {
        var imports = Imports().add(Database::class)
        ts.forEach {
            imports = imports
                .add("${config.outputPackage}.kosql.entity.${it.entity.name}")
                .add("${config.outputPackage}.kosql.table.${it.objectName}")
        }
        File(config.outputDirectory, "${config.outputPackage.replace(".", "/")}/$name.kt").also {
            if (it.exists()) it.delete()
            it.createNewFile()

            it.writer().use {
                it.write("""
                    |package ${config.outputPackage}
                    |
                    |${imports.map { "import $it" }.joinToString("\n")}
                    |
                    |object $name: Database {
                    |    init {
                    |${ts.map { "        Database.register(${it.objectName}, ${it.entity.name}::class)" }.joinToString("\n")}
                    |    }
                    |}
                """.trimMargin())
            }
        }
    }

    fun writeFiles(ts: List<TableInfo>) {
        val dir = File(config.outputDirectory, config.outputPackage.replace(".", "/")).also {
            if (!it.exists()) it.mkdirs()
        }
        val tableDir = File(dir, "table").also { if (!it.exists()) it.mkdir() }
        val entityDir = File(dir, "entity").also { if (!it.exists()) it.mkdir() }

        ts.forEach {
            File(tableDir, "${it.tableName}.kt").also {
                if (it.exists()) it.delete()
                it.createNewFile()
            }.writer().use { writer ->
                config.tableWriterFactory.create(writer, config, it).doWrite()
            }

            File(entityDir, "${it.entity.name}.kt").also {
                if (it.exists()) it.delete()
                it.createNewFile()
            }.writer().use { writer ->
                config.entityWriterFactory.create(writer, config, it).doWrite()
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