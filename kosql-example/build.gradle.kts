import org.springframework.boot.gradle.tasks.bundling.BootJar

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.2.RELEASE")
    }
}

apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")

dependencies {
    compile(project(":kosql-spring-jdbc"))
    compile(project(":kosql-generator"))
    compile("mysql:mysql-connector-java")
    compile("org.springframework.boot:spring-boot-starter-jdbc")
}

tasks.withType<BootJar> {
    mainClassName = "com.github.jacokoo.kosql.example.MainKt"
}