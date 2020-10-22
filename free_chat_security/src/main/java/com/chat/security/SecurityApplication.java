package com.chat.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: Parent
 * @Package: com.chat.security
 * @ClassName: SecurityApplication
 * @Description: java类作用描述
 * @Author: ldy
 * @CreateDate: 2020/10/22 21:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/22 21:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
