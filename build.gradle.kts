import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    `maven-publish`
    java
}

allprojects {
    group = "com.github.jacokoo.kosql"
    version = "0.3.6"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
    }
}

configure(subprojects.filter { it.name.contains("vertx") }) {
    dependencies {
        implementation(platform("io.vertx:vertx-stack-depchain:4.3.1"))
        implementation("io.vertx:vertx-lang-kotlin")
        implementation("io.vertx:vertx-lang-kotlin-coroutines")
    }
}

configure(subprojects.filter {
    !it.path.contains("demo") &&
    it.name != "mysql" &&
    it.name != "postgres"
}) {
    apply(plugin = "maven-publish")
    apply(plugin = "java")

    java {
        withSourcesJar()
    }

    publishing {
        repositories {
            mavenLocal()
        }

        publications {
            create<MavenPublication>("mavenJava") {
                from(components["java"])
                artifactId = tasks.jar.get().archiveBaseName.get()
            }
        }
    }
}


val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "11"
