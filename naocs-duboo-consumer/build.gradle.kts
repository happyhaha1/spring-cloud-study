dependencies {
    implementation(Libs.SpringBootWeb)
    implementation(Libs.SpringBootDubbo)
    implementation(Libs.NettyAll)
    implementation(Libs.NacosDubboRegistry)
    implementation(Libs.NacosClient)
    implementation(project(":nacos-dubbo-facde"))
}