dependencies {
    compile(project(":kosql-compose"))
    compile(kotlin("reflect"))
    compile("org.springframework:spring-jdbc:${ext["spring-version"]}")
}
