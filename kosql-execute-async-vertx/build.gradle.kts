description = """
    | Async executor use vertx reactive SQL client
""".trimMargin()

dependencies {
    implementation(project(":kosql-execute-async"))
    implementation(project(":kosql-build"))
    implementation(project(":kosql-compose"))
    implementation("io.vertx:vertx-sql-client")

    compileOnly(project(":kosql-type"))
    compileOnly("org.slf4j:slf4j-api:1.7.25")
}
