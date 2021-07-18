description = """
    | Base project for build SQL statement
""".trimMargin()

dependencies {
    api(project(":kosql-compose"))
    compileOnly(project(":kosql-type"))
}
