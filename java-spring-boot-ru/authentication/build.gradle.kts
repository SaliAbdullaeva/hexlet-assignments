import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.github.ben-manes.versions") version "0.50.0" //проверяет наличие обновлений
    id("io.freefair.lombok") version "8.11"
}

group = "exercise"

version = "1.0-SNAPSHOT"

application {
    mainClass.set("exercise.Application")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
    runtimeOnly("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("net.datafaker:datafaker:2.4.2")
    implementation("org.instancio:instancio-junit:5.2.1")
    implementation("org.openapitools:jackson-databind-nullable:0.2.6")

    // BEGIN
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt:0.12.6") // Библиотека для работы с JWT
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    testImplementation("org.springframework.security:spring-security-test")
    // END

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    testImplementation("net.javacrumbs.json-unit:json-unit-assertj:4.1.0")

}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
}
