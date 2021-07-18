description = """
    | Synchronously execute the typesafe sql
""".trimMargin()

dependencies {
    api(project(":kosql-compose"))
    compileOnly(project(":kosql-type"))
}
