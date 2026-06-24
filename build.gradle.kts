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
    maven { url = uri("https://repo.panda-lang.org/releases") }
    maven("https://jitpack.io")
    maven("https://repo.okaeri.cloud/releases")
    maven("https://repo.eternalcode.pl/releases")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.1.2.build.+")

    implementation("dev.rollczi:litecommands-bukkit:3.11.0")

    implementation("com.google.inject:guice:7.0.0")

    implementation("com.github.xKrisSx.aaapi:core:1.0.1")
    implementation("com.github.xKrisSx.aaapi:guice:1.0.1")

    implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:6.1.0-beta.4")

    implementation("com.eternalcode:multification-paper:1.2.4")
}

kotlin {
    jvmToolchain(25)
}