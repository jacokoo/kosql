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
    "kosql-execute-async-java",

    ":mysql:kosql-mysql-type",
    ":mysql:kosql-mysql-type-vertx",
    ":mysql:kosql-mysql-build",
    ":mysql:kosql-mysql-vertx",
    ":mysql:kosql-mysql-spring",

    ":postgres:kosql-pg-build",
    ":postgres:kosql-pg-type-vertx",
    ":postgres:kosql-pg-vertx",
    ":postgres:kosql-pg-vertx-java",

    ":demo:vertx",
    ":demo:pg-vertx-java"
)
