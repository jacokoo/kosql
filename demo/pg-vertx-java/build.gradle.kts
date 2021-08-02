dependencies {
    implementation(project(":kosql-generate"))
    implementation(project(":postgres:kosql-pg-vertx-java"))
    implementation("org.springframework:spring-jdbc:5.0.6.RELEASE")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}
