package com.github.jacokoo.kosql.generate

import com.github.jacokoo.kosql.compose.InnerTable
import com.github.jacokoo.kosql.compose.type.generate.ColumnDefinition
import com.github.jacokoo.kosql.generate.writer.EnumWriter
import org.springframework.jdbc.core.JdbcTemplate
import java.io.File
import java.sql.*

open class KoSQLGenerator(private val jdbc: JdbcTemplate, private val config: KoSQLGeneratorConfig) {

    open fun doGenerate() {
        jdbc.execute { conn: Connection ->
            val meta = conn.metaData
            val tables = tableNames(conn.catalog, meta).associateWith { primaryKey(conn.catalog, it, meta) }.map { (k, v) ->
                if (v == null) throw RuntimeException("table $k have no primary key")
                TableDefinition(k, v, columns(conn.catalog, k, meta))
            }.map { config.tableGenerator.generate(it, config) }

            config.baseDir().apply {
                if (exists()) deleteRecursively()
                mkdirs()
            }

            config.entityDir().apply {
                if (!exists()) mkdirs()
            }

            writeEnums()
            writeFiles(tables)
        }
    }

    fun writeFiles(ts: List<TableInfo>) {
        ts.forEach { table ->
            File(config.baseDir(), "${config.namingStrategy.tableClassName(table.def.name)}.kt").also {
                if (it.exists()) it.delete()
                it.createNewFile()
            }.writer().use { writer ->
                val imports = table.imports
                imports.add(InnerTable::class)

                val pkg = config.basePackage()
                writer.write("package $pkg\n\n")
                imports.forEach {
                    if (!it.contains('.') || it.substring(0, it.lastIndexOf(".")) != pkg) writer.write("import ${it}\n")
                }

                config.entityWriterFactory.create(writer, config, table).doWrite()
                config.innerTableWriterFactory.create(writer, config, table).doWrite()
                config.tableWriterFactory.create(writer, config, table).doWrite()
            }

            writeEntitySub(table)
        }
    }

    fun writeEntitySub(table: TableInfo) {
        File(config.entityDir(), "${config.namingStrategy.entitySubClassName(table.def.name)}.kt").also {
            if (!it.exists()) {
                it.createNewFile()
                it.writer().use { writer ->
                    config.entitySubWriterFactory.create(writer, config, table).doWrite()
                }
            }
        }
    }

    fun writeEnums() {
        File(config.baseDir(), "enum.kt").apply { createNewFile() }.writer().use {
            it.write("""
                |package ${config.basePackage()}
                |
                |import com.github.jacokoo.kosql.compose.type.DataType
                |
            """.trimMargin())
            EnumWriter().write(it, config)
        }
    }

    fun primaryKey(catalog: String, name: String, meta: DatabaseMetaData): String? {
        val rs = meta.getPrimaryKeys(catalog, null, name)
        if (!rs.next()) {
            rs.close()
            return null
        }

        return rs.getString("COLUMN_NAME")
    }

    protected fun columns(catalog: String, name: String, meta: DatabaseMetaData): List<ColumnDefinition> {
        var list = mutableListOf<ColumnDefinition>()
        val rs = meta.getColumns(catalog, null, name, null)
        while (rs.next()) list.add(columnFromResultSet(rs))
        rs.close()
        return list
    }

    protected fun tableNames(catalog: String, meta: DatabaseMetaData): List<String> {
        var list = mutableListOf<String>()
        val rs = meta.getTables(catalog, null, null, arrayOf("TABLE"))
        while (rs.next()) {
            list.add(rs.getString("TABLE_NAME"))
        }
        rs.close()
        return list
    }

    protected fun columnFromResultSet(rs: ResultSet): ColumnDefinition = ColumnDefinition(
            rs.getString("COLUMN_NAME"),
            rs.getInt("DATA_TYPE"),
            rs.getString("TYPE_NAME"),
            rs.getInt("COLUMN_SIZE"),
            rs.getInt("DECIMAL_DIGITS"),
            rs.getInt("NUM_PREC_RADIX"),
            rs.getString("IS_NULLABLE").let { it == "YES" },
            rs.getString("COLUMN_DEF"),
            rs.getString("REMARKS") ?: "",
            rs.getInt("ORDINAL_POSITION"),
            rs.getString("IS_AUTOINCREMENT").let { it == "YES" },
            rs.getString("IS_GENERATEDCOLUMN").let { it == "YES" }
    )
}
