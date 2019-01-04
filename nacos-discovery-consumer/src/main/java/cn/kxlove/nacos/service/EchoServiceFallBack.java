package cn.kxlove.nacos.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>EchoServiceFallBack</p>
 *
 * @author zhengkaixin
 * @since 2019-01-04 13:55
 */
public class EchoServiceFallBack implements EchoService {
    @Override
    public String echo(@PathVariable("str") String str) {
        return "echo fallback";
    }
}
