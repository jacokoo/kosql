import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `build-scan`
    `maven-publish`
    java
    kotlin("jvm") version "1.2.41" apply false
}

allprojects {
    group = "com.github.jacokoo"
    version = "0.0.1-SNAPSHOT"

    ext {
        this["spring-version"] = "5.0.6.RELEASE"
        this["slf4j-version"] = "1.7.25"
    }

    repositories { jcenter() }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    dependencies {
        compile(kotlin("stdlib-jdk8"))
    }

    apply(plugin = "maven-publish")
    publishing {
        repositories { maven { url = uri("${rootProject.buildDir}/repo") } }
        (publications) {
            "java"(MavenPublication::class) {
                from(components["java"])
            }
        }
    }
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
}
