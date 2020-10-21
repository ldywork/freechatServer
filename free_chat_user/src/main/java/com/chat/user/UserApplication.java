package com.chat.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@MapperScan("com.chat.user.dao")
@EntityScan("com.chat.model.entity")
/**
 * 描述:
 *
 * @Author: Ldy
 * @Date 2019/11/7 9:38
 **/
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
