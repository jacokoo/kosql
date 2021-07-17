description = "MySQL sync executor use Spring"

dependencies {
    implementation(project(":kosql-execute-sync"))
    implementation(project(":kosql-execute-sync-spring"))
    implementation(project(":kosql-compose"))
    implementation(project(":kosql-build"))

    implementation(project(":mysql:kosql-mysql-build"))
    implementation(project(":mysql:kosql-mysql-type"))

    compileOnly("org.slf4j:slf4j-api:1.7.25")
    compileOnly("org.springframework:spring-jdbc:5.0.6.RELEASE")
}
