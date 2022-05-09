import org.gradle.api.JavaVersion.VERSION_17

plugins {
    kotlin("jvm") version "1.6.0-RC"
}

group = "me.kcybulski.bricks.kata"
version = "1.0"

java {
    sourceCompatibility = VERSION_17
    targetCompatibility = VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("me.kcybulski.bricks:bricks-client:2.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    testImplementation("me.kcybulski.bricks:bricks-test:2.2")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.0.0.M3")
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.0.0.M3")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
