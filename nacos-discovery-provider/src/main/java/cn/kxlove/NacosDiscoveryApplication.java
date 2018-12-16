package cn.kxlove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
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
public class NacosDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryApplication.class, args);
    }

    @RestController
    class EchoController {
        @Autowired
        Environment environment;;

        @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) {
            System.out.println("调用了"+environment.getProperty("local.server.port"));
            return string;
        }
    }
}
