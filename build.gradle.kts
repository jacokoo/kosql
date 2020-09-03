import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `build-scan`
    `maven-publish`
    java
    kotlin("jvm") version "1.2.50" apply false
}

allprojects {
    group = "com.github.jacokoo"
    version = "0.0.3"

    ext {
        this["spring-version"] = "5.0.6.RELEASE"
        this["slf4j-version"] = "1.7.25"
    }

    repositories {
        maven {
            url = uri("http://m2.sparktimes.cn/repository/maven-public/")
        }
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    task("source", Jar::class) {
        from(java.sourceSets["main"].allSource)
        classifier = "sources"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    dependencies {
        compile(kotlin("stdlib-jdk8"))
    }

    if (name != "kosql-test") {
        apply(plugin = "maven-publish")

        publishing {
            repositories {
                maven { url = uri("${rootProject.buildDir}/repo") }
                maven { url = uri("${System.getProperty("user.home")}/.m2/repository") }
            }
            (publications) {
                "java"(MavenPublication::class) {
                    from(components["java"])
                    artifact(tasks["source"])
                }
            }
        }
    }
}

tasks.withType<Wrapper> {
    version = "4.8"
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
}
