package com.chat.backcontroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chat.backcontroll.mapper")
/**
 * 描述:后台启动类
 *
 * @Author: Ldy
 * @Date 2019/10/30 13:42
 **/
public class BackControllApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackControllApplication.class);
    }
}
