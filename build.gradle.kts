import groovy.xml.dom.DOMCategory.attributes
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.*

val JAVA_PROJECTS = subprojects.filter {
    file("${it.projectDir}/src/main/java").exists() ||
            file("${it.projectDir}/src/main/kotlin").exists()
}

val JAVA_SPRING_PROJECTS = subprojects.filter {
    file("${it.projectDir}/src/main/resources/application.properties").exists() ||
            file("${it.projectDir}/src/main/resources/bootstrap.properties").exists()
}

val Kotlin_PROJECTS = subprojects.filter {
    file("${it.projectDir}/src/main/kotlin").exists()
}

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

configure(JAVA_PROJECTS) {
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
        from(tasks["javadoc"])
        classifier = "javadoc"
    }
    artifacts.add("archives", sourcesJar)
    artifacts.add("archives", javadocJar)
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

configure(JAVA_SPRING_PROJECTS) {
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
        val profile: String? = project.findProperty("Env") as String?
        doLast {
            Profile.change(profile)
        }
    }
}

configure(Kotlin_PROJECTS) {
    apply {
        plugin("kotlin")
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = ProjectConstant.javaVerion
        destinationDir = file("$buildDir/classes/main")
    }
}


