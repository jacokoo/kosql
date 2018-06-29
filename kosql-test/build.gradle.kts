import org.springframework.boot.gradle.tasks.bundling.BootJar

import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile

tasks.withType<Test> {
    useJUnitPlatform()
    isScanForTestClasses = true

    kotlin {
        experimental {
            coroutines = Coroutines.ENABLE
        }
    }
}

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
    compile(kotlin("reflect"))
    compile("mysql:mysql-connector-java")
    compile("org.springframework.boot:spring-boot-starter-jdbc")
    testCompile("io.kotlintest:kotlintest-runner-junit5:3.1.6")
    testCompile("org.junit.jupiter:junit-jupiter-engine:5.2.0")
}

tasks.withType<BootJar> {
    mainClassName = "com.github.jacokoo.kosql.example.MainKt"
}
