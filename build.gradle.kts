val JAVA_PROJECTS = arrayOf()
val JAVA_SPRING_PROJECTS = arrayOf("nacos-discovery-provider", "nacos-discovery-consumer")

plugins {
    id("org.springframework.boot") version Versions.springBoot apply false
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
            from("$rootDir/publishing.gradle")
        }

        configure<JavaPluginConvention> {
            setSourceCompatibility(ProjectConstant.javaVerion)
            setTargetCompatibility(ProjectConstant.javaVerion)
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
    println("项目版本：${project.buildDir}")
}