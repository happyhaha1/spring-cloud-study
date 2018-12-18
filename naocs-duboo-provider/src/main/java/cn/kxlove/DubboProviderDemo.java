package cn.kxlove;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <p>DubboProviderDemo</p>
 *
 * @author zhengkaixin
 * @since 2018-12-18 17:41
 */
@SpringBootApplication
public class DubboProviderDemo {

    public static void main(String[] args) {

        new SpringApplicationBuilder(DubboProviderDemo.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
