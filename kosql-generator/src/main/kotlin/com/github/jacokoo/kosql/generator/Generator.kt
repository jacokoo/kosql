package com.github.jacokoo.kosql.generator

import com.github.jacokoo.kosql.generator.columns.*
import org.springframework.jdbc.core.JdbcTemplate
import java.sql.DatabaseMetaData

data class KoSQLGeneratorConfig(
        val outputDirectory: String,
        val outputPackage: String,
        val namingStrategy: NamingStrategy = DefaultNamingStrategy(),
        val columnGenerators: List<ColumnGenerator> = listOf(
                IntColumnGenerator(), LongColumnGenerator(), FloatColumnGenerator(),
                DoubleColumnGenerator(), DecimalColumnGenerator()
        ),
        val tableGenerator: TableGenerator? = null
)


open class Generator(val config: KoSQLGeneratorConfig, val jdbc: JdbcTemplate) {

    fun doGenerate() {

    }

    fun columns(name: String, meta: DatabaseMetaData): List<ColumnDefinition> {
        var list = mutableListOf<ColumnDefinition>()
        val rs = meta.getColumns(null, null, name, null)
        while (rs.next()) list.add(ColumnDefinition.fromResultSet(rs))
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