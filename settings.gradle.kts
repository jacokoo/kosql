rootProject.name = "kosql"

include(
    "kosql-type",
    "kosql-compose",
    "kosql-build",
    "kosql-generate",
    "kosql-execute-async",
    "kosql-execute-sync",
    "kosql-execute-async-vertx",
    "kosql-execute-sync-spring",
    "kosql-mysql-type",
    "kosql-mysql-type-vertx",
    "kosql-mysql-build",
    "kosql-mysql-vertx",
    "kosql-mysql-spring",
    ":demo:vertx",
)
