package com.github.jacokoo.kosql.demo.vertx

import com.github.jacokoo.kosql.generate.KoSQLGenerator
import com.github.jacokoo.kosql.generate.KoSQLGeneratorConfig
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SimpleDriverDataSource

fun main() {
    KoSQLGenerator(JdbcTemplate(SimpleDriverDataSource().apply {
        url = "jdbc:mysql://127.0.0.1:13306/demo"
        username = "root"
        password = "root"
        setDriverClass(com.mysql.jdbc.Driver::class.java)
    }), KoSQLGeneratorConfig(
        "/Users/guyong/ws/kotlin/kosql/demo/vertx/src/main/kotlin",
        "com.github.jacokoo.kosql.demo.vertx"
    )).doGenerate()
}
