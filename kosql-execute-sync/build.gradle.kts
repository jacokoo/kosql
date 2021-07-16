description = """
    | Synchronously execute the typesafe sql
""".trimMargin()

dependencies {
    implementation(project(":kosql-compose"))
    compileOnly(project(":kosql-type"))
}
