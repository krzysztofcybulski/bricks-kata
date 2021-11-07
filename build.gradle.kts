import org.gradle.api.JavaVersion.VERSION_16

plugins {
    kotlin("jvm") version "1.6.0-RC"
}

group = "me.kcybulski.bricks.kata"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = VERSION_16
    targetCompatibility = VERSION_16
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("me.kcybulski.bricks:bricks-client:1.1")
    testImplementation("me.kcybulski.nexum:event-store:1.5.0")
    testImplementation("me.kcybulski.bricks:bricks-events:1.0")
    testImplementation("me.kcybulski.bricks:bricks-test:1.0")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.0.0.M3")
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.0.0.M3")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
