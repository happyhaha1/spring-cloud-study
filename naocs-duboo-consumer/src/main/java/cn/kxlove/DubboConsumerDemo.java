package cn.kxlove;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.annotation.PostConstruct;

/**
 * <p>DubboProviderDemo</p>
 *
 * @author zhengkaixin
 * @since 2018-12-18 17:41
 */
@SpringBootApplication
public class DubboConsumerDemo {

    @Reference(version = "1.0.0")
    private IHelloService demoService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboConsumerDemo.class)
                .run(args);
    }

    @PostConstruct
    public void init() {
        for (int i = 0; i < 20; i++) {
            String sayHello = demoService.sayHello("world");
            System.err.println(sayHello);
        }
    }
}
