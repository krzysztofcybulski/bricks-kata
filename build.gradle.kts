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
    source("https://github.com/krzysztofcybulski/bricks.git::game::0bdb31469576228ecdff5ca7e2362d36297d8224##e4b1196876b511c7321f054d8c6aba066d028ed8815adc3940c926c6981ca93a")
    source("https://github.com/krzysztofcybulski/bricks.git::client::0bdb31469576228ecdff5ca7e2362d36297d8224##11729b86ae6d9eb6549486c11fe94367b964bcfd72693d549aebed443c2d0aec")
    source("https://github.com/krzysztofcybulski/bricks.git::test::0bdb31469576228ecdff5ca7e2362d36297d8224##feb76cc2ea60ca5ed00912e7122a77af146291296c1fa055bc10189fa26c4fa8")
    source("https://github.com/krzysztofcybulski/bricks.git::shared-web::0bdb31469576228ecdff5ca7e2362d36297d8224##6eeff2082c07c41f098417a8287e460d781a51a6deb04134bc228b21c882717c")
    source("https://github.com/krzysztofcybulski/bricks.git::events::0bdb31469576228ecdff5ca7e2362d36297d8224##09478e4238358a53664aac9308a130ec0470ec04bbc9c7ff66e22b36255aed6a")
}
