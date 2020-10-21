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
@ConfigurationProperties(prefix = "netsource", ignoreUnknownFields = false)
@PropertySource("classpath:netsource.properties")
public class NetSource {
    @Value("${baidu.baike}")
    private String baiDuBaiKe;
}
