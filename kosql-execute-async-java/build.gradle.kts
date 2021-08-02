dependencies {
    api(project(":kosql-compose"))
    api(project(":kosql-build"))
    compileOnly(project(":kosql-type"))
    compileOnly("io.vertx:vertx-core:4.1.1")
    compileOnly("io.vertx:vertx-sql-client:4.1.1")
    compileOnly("org.slf4j:slf4j-api:1.7.25")
}
