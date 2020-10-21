package com.chat.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Configuration
@Component
@PropertySource("classpath:thread.properties")
@ConfigurationProperties(prefix = "thread", ignoreUnknownFields = true)
public class ThreadConfig {
    @Value("${fixed.thread.pool.num}")
    private Integer threadNum;



}
