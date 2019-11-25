package com.hfjy.schooling;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 教学系统启动类
 * @author hsx
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.hfjy")
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }
}

