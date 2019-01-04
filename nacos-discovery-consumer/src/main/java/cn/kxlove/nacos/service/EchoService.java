package cn.kxlove.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>EchoService</p>
 *
 * @author zhengkaixin
 * @since 2018-12-28 16:57
 */
@FeignClient(name = "kxlove-nacos-provider")
public interface EchoService {
    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);
}
