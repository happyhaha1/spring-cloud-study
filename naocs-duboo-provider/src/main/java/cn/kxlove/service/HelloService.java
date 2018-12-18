package cn.kxlove.service;

import cn.kxlove.IHelloService;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.Date;

/**
 * <p>HelloService</p>
 *
 * @author zhengkaixin
 * @since 2018-12-18 17:56
 */
@Service(version = "1.0.0")
public class HelloService implements IHelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("调用了");
        return "Hello, " + name + ", " + new Date();
    }
}
