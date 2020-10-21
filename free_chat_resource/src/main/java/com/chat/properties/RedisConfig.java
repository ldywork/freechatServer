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
@PropertySource("classpath:redis.properties")
@ConfigurationProperties(prefix = "redis", ignoreUnknownFields = true)
public class RedisConfig {
    @Value("${redis.ip}")
    private String ip;
    @Value("${redis.port}")
    private Integer port;
    @Value("${es.net.id}")
    private String esNetId;
    @Value("${redis.pass}")
    private String pass;
    @Value("${redis.database}")
    private Integer dataBase;
    @Value("${redis.timeout}")
    private String timeout;
    @Value("${redis.use.pool}")
    private boolean usePool;
    @Value("${redis.maxTotal}")
    private Integer maxTotal;
    @Value("${redis.maxIdle}")
    private Integer maxIdle;
    @Value("${redis.minIdle}")
    private String minIdle;
    @Value("${redis.maxWaitMillis}")
    private Long maxWaitMillis;
    @Value("${redis.whenExhaustedAction}")
    private String whenExhaustedAction;
    @Value("${redis.testOnCreate}")
    private String testOnCreate;
    @Value("${redis.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${redis.testOnReturn}")
    private String testOnReturn;
    @Value("${redis.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${redis.timeBetweenEvictionRunsMillis}")
    private Long timeBetweenEvictionRunsMillis;
    @Value("${redis.numTestsPerEvictionRun}")
    private Integer numTestsPerEvictionRun;
    @Value("${redis.minEvictableIdleTimeMillis}")
    private Long minEvictableIdleTimeMillis;
    @Value("${redis.softMinEvictableIdleTimeMillis}")
    private String softMinEvictableIdleTimeMillis;


}
