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
    testCompile("io.kotlintest:kotlintest-runner-junit5:3.1.6")
}
