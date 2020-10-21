package com.chat.registry;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
/**
 * 描述:注册中心启动类
 *
 * @Author: Ldy
 * @Date 2019/10/30 11:26
 **/
public class FreeChatRegistry {
    public static void main(String[] args) {
        SpringApplication.run(FreeChatRegistry.class);

    }

}
