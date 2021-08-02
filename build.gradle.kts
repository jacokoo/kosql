import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    kotlin("jvm") version "1.5.10"
    `maven-publish`
    java
}

allprojects {
    group = "com.github.jacokoo.kosql"
    version = "0.2.0"

    repositories {
        mavenCentral()
    }
}

configure(subprojects.filter {it.name != "demo"}) {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    val compileKotlin: KotlinCompile by tasks
    compileKotlin.kotlinOptions.jvmTarget = "11"
    compileKotlin.kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=all")

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
    }
}

configure(subprojects.filter { it.name.contains("vertx") }) {
    dependencies {
        implementation(platform("io.vertx:vertx-stack-depchain:4.1.1"))
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
            maven {
                url = uri("https://monacohq.jfrog.io/artifactory/dolphin-java-local")

                credentials {
                    username = System.getenv("ARTIFACTORY_USER")
                    password = System.getenv("ARTIFACTORY_APIKEY")
                }
            }
        }

        publications {
            create<MavenPublication>("mavenJava") {
                from(components["java"])
                artifactId = tasks.jar.get().archiveBaseName.get()
            }
        }
    }
}
