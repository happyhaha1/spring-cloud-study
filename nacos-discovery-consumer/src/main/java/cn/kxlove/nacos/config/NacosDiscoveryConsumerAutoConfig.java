package cn.kxlove.nacos.config;

import cn.kxlove.nacos.TestFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>NacosDiscoveryConsumerAutoConfig</p>
 *
 * @author zhengkaixin
 * @since 2019-01-04 11:06
 */
@Configuration
public class NacosDiscoveryConsumerAutoConfig {


    @Bean
    @ConditionalOnProperty(value = "comm.env",havingValue = "test")
    public TestFilter testFilter() {
        return new TestFilter();
    }
}
