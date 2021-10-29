import java.net.URI

plugins {
    kotlin("jvm") version "1.6.0-RC"
    id("com.soywiz.korlibs.kotlin-source-dependency-gradle-plugin") version "0.1.1"
}

group = "me.kcybulski.bricks.kata"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.arrow-kt:arrow-core:1.0.0")
    implementation("com.github.javafaker:javafaker:1.0.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("io.kotest:kotest-runner-junit5-jvm:5.0.0.M3")
    implementation("io.kotest:kotest-assertions-core-jvm:5.0.0.M3")
}

tasks.withType<Test> {
    useJUnitPlatform()
}


sourceDependencies {
    source("https://github.com/krzysztofcybulski/bricks.git::game::eb16827a4aaf0c691590db77abfe2e49984fc904##00c60e76a5435855eae7aa0826608ac4e234083fc996eeb7360340c8cb18ed20")
    source("https://github.com/krzysztofcybulski/bricks.git::test::eb16827a4aaf0c691590db77abfe2e49984fc904##c61b815775336f79530f135c632811be9543cd3180bc93e8fcef8270a33fa601")
}
