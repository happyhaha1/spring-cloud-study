plugins {
    id("org.jetbrains.kotlin.plugin.spring") version Versions.kotlin
    id("org.jetbrains.kotlin.plugin.jpa") version Versions.kotlin
}

dependencies {
    implementation(Libs.KotlinReflect)
    implementation(Libs.SpringBootWeb)
    implementation(Libs.SpringBootActuator)
    implementation(Libs.SpringBootJpa)
    runtimeOnly(Libs.H2DataBase)
    testImplementation(Libs.JunitJupiterApi)
    testRuntimeOnly(Libs.JunitJupiterEngine)
}
