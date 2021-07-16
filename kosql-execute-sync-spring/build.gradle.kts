description = """
    | Sync executor use spring jdbc
""".trimMargin()

dependencies {
    implementation(project(":kosql-execute-sync"))
    implementation(project(":kosql-build"))
    implementation(project(":kosql-compose"))

    compileOnly(project(":kosql-type"))
    compileOnly("org.slf4j:slf4j-api:1.7.25")
    compileOnly("org.springframework:spring-jdbc:5.0.6.RELEASE")
}
