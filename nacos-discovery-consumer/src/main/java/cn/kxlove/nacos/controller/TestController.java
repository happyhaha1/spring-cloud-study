package cn.kxlove.nacos.controller;

import cn.kxlove.nacos.service.EchoService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>TestController</p>
 *
 * @author zhengkaixin
 * @since 2019-01-04 13:54
 */
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
    @SentinelResource("hello")
    public String echo(@PathVariable String str) {
//            return restTemplate.getForObject("http://kxlove-nacos-provider/echo/" + str, String.class)+useLocalCache;
        return echoService.echo(str);
    }
}
