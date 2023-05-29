package com.github.jacokoo.kosql.demo.vertx

import com.github.jacokoo.kosql.generate.KoSQLGenerator
import com.github.jacokoo.kosql.generate.KoSQLGeneratorConfig

fun main() {
    KoSQLGenerator(KoSQLGeneratorConfig(
        driverClass = "com.mysql.jdbc.Driver",
        connectionUri = "jdbc:mysql://localhost/demo?user=root&password=root",
        "/Users/guyong/ws/kotlin/kosql/demo/vertx/src/main/kotlin",
        "com.github.jacokoo.kosql.demo.vertx"
    )).doGenerate()
}
