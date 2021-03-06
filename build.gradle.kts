val JAVA_PROJECTS = arrayOf("nacos-discovery")
plugins {
    java
    kotlin("jvm") version Versions.kotlin
    `maven-publish`
}
allprojects {
    group = "cn.kxlove"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("maven-publish")
        plugin("java")
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    if (JAVA_PROJECTS.contains(project.name)) {
        val sourceJar = task("sourceJar", Jar::class) {
            dependsOn(tasks["classes"])
            classifier = "sources"
            from(sourceSets.main.get().allSource)
        }

        dependencies {
            implementation(Libs.rxjava)
        }

        publishing {
            publications {
                create<MavenPublication>("maven") {
                    groupId = project.group.toString()
                    artifactId = project.name
                    version = project.version.toString()
                    from(components["java"])
                    artifact(sourceJar)
                }
            }
        }
    }
}

//
//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "1.8"
//}
task("testGroup") {
//    logger.info("项目group:{}",project.group.toString())
    println("项目版本："+project.group.toString())
}