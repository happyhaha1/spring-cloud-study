package cn.kxlove.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "test-endpoint")
public class CustomHealthEndpoint {


    @ReadOperation
    public String getCustom() {
        return "success";
    }
}
