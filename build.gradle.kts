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
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.1.2.build.+")

    implementation("dev.rollczi:litecommands-bukkit:3.11.0")

    implementation("com.google.inject:guice:7.0.0")

    implementation("com.github.xKrisSx.aaapi:core:1.0.1")
    implementation("com.github.xKrisSx.aaapi:guice:1.0.1")
}

kotlin {
    jvmToolchain(25)
}