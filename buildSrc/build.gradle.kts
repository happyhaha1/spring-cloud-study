plugins {
    `kotlin-dsl`
    idea
}

repositories {
    // The org.jetbrains.kotlin.jvm plugin requires a repository
    // where to download the Kotlin compiler dependencies from.
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    compile("org.jetbrains.exposed:exposed:0.11.2")
    compile("mysql:mysql-connector-java:8.0.13")
}
idea.module {
    outputDir = file("build/classes/main")
    testOutputDir = file("build/classes/test")
}