package cn.kxlove.nacos;

import cn.kxlove.nacos.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RestController
    @RefreshScope
    public class TestController {

        private final EchoService echoService;

        @Value("${useLocalCache:false}")
        private boolean useLocalCache;

        @Autowired
        public TestController(EchoService echoService) {
            this.echoService = echoService;
        }

        @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
        public String echo(@PathVariable String str) {
//            return restTemplate.getForObject("http://kxlove-nacos-provider/echo/" + str, String.class)+useLocalCache;
            return "happyhaha"+useLocalCache;
        }
    }
}
