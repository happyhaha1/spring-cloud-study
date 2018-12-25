/**
 *
 * <p>Dependencies</p>
 *
 * @author zhengkaixin
 * @since 2018-12-14 17:33
 */
object ProjectConstant {
    val group = "cn.kxlove"
    val version = "1.0-SNAPSHOT"
    val javaVerion = "1.8"
}
object Versions {
    val kotlin = "1.3.10"
    val springManagement = "1.0.6.RELEASE"
    val springBoot = "2.0.3.RELEASE"
    val springCloud = "Finchley.SR2"
    val springCloudAliBaba = "0.2.0.RELEASE"
    val aliBaBaSpringBootDubbo = "0.2.0"
    val nacosClient = "0.7.0"
    val nacosDubboRegistry = "0.0.2"
    val nettyAll = "4.1.24.Final"
    val kotlinTest = "3.1.11"
}

object Libs {
    val KotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val KotlinStdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val KotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    val springCloudBom = "org.springframework.cloud:spring-cloud-dependencies:${Versions.springCloud}"
    val springCloudAliBabaBom = "org.springframework.cloud:spring-cloud-alibaba-dependencies:${Versions.springCloudAliBaba}"
    val NacosDiscovery = "org.springframework.cloud:spring-cloud-starter-alibaba-nacos-discovery"
    val NacosConfig = "org.springframework.cloud:spring-cloud-starter-alibaba-nacos-config"
    val SpringBootWeb = "org.springframework.boot:spring-boot-starter-web"
    val SpringTestStart = "org.springframework.boot:spring-boot-starter-test"
    val SpringBootDubbo = "com.alibaba.boot:dubbo-spring-boot-starter:${Versions.aliBaBaSpringBootDubbo}"
    val SpringBootJpa = "org.springframework.boot:spring-boot-starter-data-jpa"
    val H2DataBase = "com.h2database:h2"
    val NacosClient = "com.alibaba.nacos:nacos-client:${Versions.nacosClient}"
    val NacosDubboRegistry = "com.alibaba:dubbo-registry-nacos:${Versions.nacosDubboRegistry}"
    val NettyAll = "io.netty:netty-all:${Versions.nettyAll}"
    val KotlinTest = "io.kotlintest:kotlintest-runner-junit5:${Versions.kotlinTest}"
    val JunitJupiterApi = "org.junit.jupiter:junit-jupiter-api"
    val JunitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine"

}