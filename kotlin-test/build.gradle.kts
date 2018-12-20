//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//
//plugins {
//    application
//    kotlin("jvm")
//}
//
//
//application {
//    mainClassName = "cn.kxlove.Main"
//}
//
dependencies {
    compile(kotlin("stdlib"))
    testImplementation(Libs.KotlinTest)
    constraints {
        testImplementation(Libs.KotlinStdlib)
        testImplementation(Libs.KotlinStdlibJdk7)
        testImplementation(Libs.KotlinReflect)
    }
}
//
tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "cn.kxlove.Main"
        )
    }
    val sourceSets: SourceSetContainer by project
    val sourceMain = sourceSets["main"]
    from(sourceMain.output)
    configurations.runtimeClasspath.get().filter {
        it.name.endsWith(".jar")
    }.forEach { jar ->
        from(zipTree(jar))
    }
}
tasks.withType<Test> {
    useJUnitPlatform()
}
//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "1.8"
//    destinationDir = file("$buildDir/classes/main")
//}

