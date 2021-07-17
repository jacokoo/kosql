dependencies {
    implementation(project(":kosql-build"))
    implementation(project(":kosql-compose"))
    implementation(project(":kosql-execute-async"))
    implementation(project(":kosql-execute-async-vertx"))
    implementation(project(":kosql-generate"))
    implementation(project(":mysql:kosql-mysql-vertx"))
    implementation(project(":mysql::kosql-mysql-type-vertx"))
    implementation("io.vertx:vertx-mysql-client")
    implementation("org.springframework:spring-jdbc:5.0.6.RELEASE")
    implementation("mysql:mysql-connector-java:8.0.16")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}
