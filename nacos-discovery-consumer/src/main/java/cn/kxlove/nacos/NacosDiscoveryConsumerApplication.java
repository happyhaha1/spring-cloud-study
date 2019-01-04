package cn.kxlove.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>NacosDiscoveryApplicaiton</p>
 *
 * @author zhengkaixin
 * @since 2018-12-14 16:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosDiscoveryConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryConsumerApplication.class, args);
    }


}
