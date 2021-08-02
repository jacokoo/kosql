dependencies {
    api(project(":kosql-execute-async-java"))
    api(project(":postgres:kosql-pg-build"))
    api(project(":postgres:kosql-pg-type-vertx"))
    api("io.vertx:vertx-pg-client")

    compileOnly("org.slf4j:slf4j-api:1.7.25")
}
