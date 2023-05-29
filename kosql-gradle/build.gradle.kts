plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        create("kosql") {
            id = "com.github.jacokoo.kosql"
            implementationClass = "com.github.jacokoo.kosql.gradle.KoSQLPlugin"
        }
    }
}

dependencies {
    api(project(":kosql-generate"))
    api("org.postgresql:postgresql:42.3.8")
}
