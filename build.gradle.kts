plugins {
    kotlin("jvm") version "2.3.21"
}

group = "dev.p2tch"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.1.2.build.+")

    implementation("com.google.inject:guice:7.0.0")
}

kotlin {
    jvmToolchain(25)
}