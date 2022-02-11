package com.ktalpha.redisjson_boot_example.Repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperty extends RedisCommonProperty {
}
