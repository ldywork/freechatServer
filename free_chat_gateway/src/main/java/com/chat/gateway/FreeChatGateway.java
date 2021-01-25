package com.chat.gateway;

import com.chat.search.common.redis.PersonalRedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class FreeChatGateway {
    public static void main(String[] args) {
        SpringApplication.run(FreeChatGateway.class,args);
    }
    @Bean
    public PersonalRedisUtil personalRedisUtil(){
        return new PersonalRedisUtil();
    }
}
