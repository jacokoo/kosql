description = "Build Postgres sql statement"

dependencies {
    api(project(":kosql-build"))
    compileOnly(project(":kosql-type"))
}
