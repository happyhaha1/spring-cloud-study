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
}

object Libs {
    val springCloudBom = "org.springframework.cloud:spring-cloud-dependencies:${Versions.springCloud}"
    val springCloudAliBabaBom = "org.springframework.cloud:spring-cloud-alibaba-dependencies:${Versions.springCloudAliBaba}"
    val NacosDiscovery = "org.springframework.cloud:spring-cloud-starter-alibaba-nacos-discovery"
    val NacosConfig = "org.springframework.cloud:spring-cloud-starter-alibaba-nacos-config"
    val SpringBootWeb = "org.springframework.boot:spring-boot-starter-web"
}