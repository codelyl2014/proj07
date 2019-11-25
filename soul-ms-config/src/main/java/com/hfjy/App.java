package com.hfjy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author hsx
 * 配置中心
 *
 */
@SpringBootApplication(exclude = RabbitAutoConfiguration.class)
@EnableConfigServer
@RestController
public class App 
{
    private static final Logger LOG= LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) {
        SpringApplication.run(App.class);
    }

    /**
     * 获取通用日志模板
     * @return
     */
    @GetMapping("/common-log")
    public String getCommonLog(){
        return readFile("com/hfjy/log/common-log.xml");
    }

    private String readFile(String file){
        StringBuilder result=new StringBuilder();
        try(InputStream is=this.getClass().getClassLoader().getResourceAsStream(file);
            InputStreamReader isr=new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader=new BufferedReader(isr);
        ){
            String line=reader.readLine();
            while(line!=null){
                result.append(line);
                line=reader.readLine();
            }
            return result.toString();
        }catch(Exception e){
            LOG.error("--获取通用日志信息{}异常",file,e);
            return null;
        }
    }
}
