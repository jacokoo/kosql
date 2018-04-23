package com.github.jacokoo.kosql.example

import org.springframework.jdbc.core.JdbcTemplate
import java.sql.Connection
import java.sql.DatabaseMetaData
import javax.annotation.PostConstruct

class Demo2(private val jdbc: JdbcTemplate) {

    @PostConstruct fun demo() {
        jdbc.execute {conn: Connection ->
            val rs = conn.createStatement().executeQuery("select * from t_order where f_id = 1")
            while (rs.next()) {
                val d = rs.getObject(2)
                println(d)
            }
        }

        jdbc.execute { conn: Connection ->
            val meta = conn.metaData
            val ts = meta.getTables(null, null, null, arrayOf("TABLE"))
            while (ts.next()) {
                tableInfo(meta, ts.getString("TABLE_NAME"))
            }
        }
    }

    fun tableInfo(meta: DatabaseMetaData, name: String) {
        println("------  $name  ------")

        val rs = meta.getColumns(null, null, name, null)
        val names = """
            |COLUMN_NAME, DATA_TYPE, TYPE_NAME,
            |COLUMN_SIZE, DECIMAL_DIGITS, NUM_PREC_RADIX,
            |NULLABLE, REMARKS, COLUMN_DEF, SQL_DATA_TYPE, SQL_DATETIME_SUB, CHAR_OCTET_LENGTH,
            |ORDINAL_POSITION, IS_NULLABLE, IS_AUTOINCREMENT, IS_GENERATEDCOLUMN
        """.trimMargin().replace("\n", "").split(",").map { it.trim() }.also { println(it.joinToString()) }
        while (rs.next()) {
            names.forEach { println("$it: ${rs.getObject(it)}") }
            println("-----------")
        }

    }
}