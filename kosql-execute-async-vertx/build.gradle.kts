description = """
    | Async executor use vertx reactive SQL client
""".trimMargin()

dependencies {
    api(project(":kosql-execute-async"))
    api(project(":kosql-build"))
    api("io.vertx:vertx-sql-client")

    compileOnly(project(":kosql-type"))
    compileOnly("org.slf4j:slf4j-api:1.7.25")
}
