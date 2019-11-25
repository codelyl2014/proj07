package com.hfjy.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

/**
 * 网关出错的降级请求(hystrix command)
 * @author hsx
 * create at 2019-01-25
 */
@Slf4j
@RestController
public class ErrorHandleController {

    @GetMapping("/handle/error")
    public String handleError(ServerWebExchange serverWebExchange,Throwable ex){
        log.error("异常信息:",ex);
        return "{\"code\":500,\"message\":\"服务异常\"}";
    }

}
