import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import java.util.*

val JAVA_PROJECTS = arrayOf("kotlin-test")
val JAVA_SPRING_PROJECTS = arrayOf("nacos-discovery-provider", "nacos-discovery-consumer")

plugins {
    kotlin("jvm") version Versions.kotlin apply false
    id("org.springframework.boot") version Versions.springBoot apply false
    idea
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

        val sourcesJar by tasks.creating(Jar::class) {
            val sourceSets: SourceSetContainer by project

            from(sourceSets["main"].allJava)
            classifier = "sources"
        }
        val javadocJar by tasks.creating(Jar::class) {
            from(tasks.get("javadoc"))
            classifier = "javadoc"
        }
        artifacts.add("archives",sourcesJar)
        artifacts.add("archives",javadocJar)
        configure<JavaPluginConvention> {
            setSourceCompatibility(ProjectConstant.javaVerion)
            setTargetCompatibility(ProjectConstant.javaVerion)
        }

        configure<SourceSetContainer> {
            named("main") {
                java.outputDir = file("$buildDir/classes/main")
                output.setResourcesDir(file("$buildDir/classes/main"))
            }
            named("test") {
                java.outputDir = file("$buildDir/classes/test")
                output.setResourcesDir(file("$buildDir/classes/test"))
            }
        }
        configure<PublishingExtension> {
            publications {
                create<MavenPublication>(project.name) {
                    from(components["java"])
                    groupId = project.group.toString()
                    artifactId = project.name
                    version = project.version.toString()

                    artifact(sourcesJar)
                    artifact(javadocJar)
                }
            }
        }
    }

    if (JAVA_SPRING_PROJECTS.contains(project.name)) {
        apply(plugin = "org.springframework.boot")
        apply(plugin = "io.spring.dependency-management")
        configure<DependencyManagementExtension> {
            imports {
                mavenBom(Libs.springCloudBom)
                mavenBom(Libs.springCloudAliBabaBom)
            }
        }
        tasks.named("processResources") {
            description = "Some meaningful words"
            var profile: String? = project.findProperty("Env") as String?
            doLast {
                if (profile == null) {
                    profile = "company"
                }
                val properties = Properties()

                val ymlFile = file("src/main/resources/application.properties")
                properties.load(ymlFile.inputStream())
                properties["spring.profiles.active"] = profile
                properties.store(file("build/classes/main/application.properties").outputStream(),
                    "Change active profile to $profile")
            }
        }
    }
}

//
//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "1.8"
//}

