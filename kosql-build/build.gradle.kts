description = """
    | Base project for build SQL statement
""".trimMargin()

dependencies {
    implementation(project(":kosql-compose"))
    compileOnly(project(":kosql-type"))
}
