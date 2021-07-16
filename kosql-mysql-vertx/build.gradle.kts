description = "MySQL async executor use Vert.x"

dependencies {
    implementation(project(":kosql-execute-async-vertx"))
    implementation(project(":kosql-mysql-build"))
    implementation(project(":kosql-mysql-type-vertx"))
    implementation("io.vertx:vertx-mysql-client")
    implementation(project(":kosql-build"))
    implementation(project(":kosql-compose"))

    compileOnly("org.slf4j:slf4j-api:1.7.25")
}
