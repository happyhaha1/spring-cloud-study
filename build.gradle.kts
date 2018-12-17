val JAVA_PROJECTS = arrayOf()
val JAVA_SPRING_PROJECTS = arrayOf("nacos-discovery-provider", "nacos-discovery-consumer")

plugins {
    java
    id("org.springframework.boot") version Versions.springBoot apply false
    `maven-publish`
    idea
    id("io.spring.dependency-management") version Versions.springManagement
}

allprojects {
    apply(plugin = "idea")
    group = ProjectConstant.group
    version = ProjectConstant.version

    repositories {
        mavenLocal()
        mavenCentral()
    }
    idea.module {
        outputDir = file("build/classes/main")
        testOutputDir = file("build/classes/test")
    }
}

subprojects {
    if (JAVA_PROJECTS.contains(project.name) || JAVA_SPRING_PROJECTS.contains(project.name)) {
        apply {
            plugin("maven-publish")
            plugin("java")
        }

        configure<JavaPluginConvention> {
            setSourceCompatibility(ProjectConstant.javaVerion)
            setTargetCompatibility(ProjectConstant.javaVerion)
        }
        val sourceJar = task("sourceJar", Jar::class) {
            dependsOn(tasks["classes"])
            classifier = "sources"
            from(sourceSets.main.get().allSource)
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

    if (JAVA_SPRING_PROJECTS.contains(project.name)) {
        apply(plugin = "org.springframework.boot")
        apply(plugin = "io.spring.dependency-management")

        dependencyManagement {
            imports {
                mavenBom(Libs.springCloudBom)
                mavenBom(Libs.springCloudAliBabaBom)
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
    println("项目版本："+project.property("project_group"))
}