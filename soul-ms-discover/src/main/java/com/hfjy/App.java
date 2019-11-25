package com.hfjy;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心启动类
 * eureka 控制台访问: http://localhost:port即可 /eureka/apps显示注册的服务列表
 * @author  hsx
 */
@SpringBootApplication
@EnableEurekaServer
public class App
{
    public static void main( String[] args )
    {
        SpringApplication application=new SpringApplication(App.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
