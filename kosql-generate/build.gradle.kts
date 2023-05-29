description = """
    | Generate entities and tables
""".trimMargin()

dependencies {
    api(project(":kosql-compose"))
    implementation(kotlin("reflect"))
    compileOnly(project(":kosql-type"))
}
