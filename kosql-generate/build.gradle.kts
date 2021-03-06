description = """
    | Generate entities and tables
""".trimMargin()

dependencies {
    api(project(":kosql-compose"))
    implementation(kotlin("reflect"))
    compileOnly(project(":kosql-type"))
    compileOnly("org.springframework:spring-jdbc:5.0.6.RELEASE")
}
