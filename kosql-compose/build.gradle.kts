import org.jetbrains.kotlin.gradle.dsl.Coroutines

tasks.withType<Test> {
    useJUnitPlatform()

    kotlin {
        experimental {
            coroutines = Coroutines.ENABLE
        }
    }
}

dependencies {
    compile("org.slf4j:slf4j-api:${ext["slf4j-version"]}")
    testCompile("io.kotlintest:kotlintest-runner-junit5:3.1.6")
}
