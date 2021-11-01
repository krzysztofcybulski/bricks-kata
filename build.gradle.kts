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
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("io.kotest:kotest-runner-junit5-jvm:5.0.0.M3")
    implementation("io.kotest:kotest-assertions-core-jvm:5.0.0.M3")
    implementation("io.ktor:ktor-client-websockets:1.6.4")
    implementation("io.ktor:ktor-client-core:1.6.4")
    implementation("io.ktor:ktor-client-cio:1.6.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("com.github.javafaker:javafaker:1.0.2")
    implementation("io.github.microutils:kotlin-logging:1.12.5")
    implementation("org.slf4j:slf4j-simple:2.0.0-alpha5")
}

tasks.withType<Test> {
    useJUnitPlatform()
}


sourceDependencies {
    source("https://github.com/krzysztofcybulski/bricks.git::game::299baea14c042f2ec8fe2a76ce967127a7f4c199##974bdf37d73431074dc23ccd865568a5b8ffd51c2e0b69781918c5c6666dda25")
    source("https://github.com/krzysztofcybulski/bricks.git::client::299baea14c042f2ec8fe2a76ce967127a7f4c199##97551528560d060e95bdc095b792e15fb06d09007b14154eaafeedb1a9062875")
    source("https://github.com/krzysztofcybulski/bricks.git::test::299baea14c042f2ec8fe2a76ce967127a7f4c199##feb76cc2ea60ca5ed00912e7122a77af146291296c1fa055bc10189fa26c4fa8")
    source("https://github.com/krzysztofcybulski/bricks.git::shared-web::299baea14c042f2ec8fe2a76ce967127a7f4c199##1d631b65cd145699d701dcad9437e1a244d3e60a3cbffc347cf691cf8ef84261")
    source("https://github.com/krzysztofcybulski/bricks.git::events::299baea14c042f2ec8fe2a76ce967127a7f4c199##09478e4238358a53664aac9308a130ec0470ec04bbc9c7ff66e22b36255aed6a")
}
