package com.auth.check.json_check.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "retry")
//@PropertySource("classpath:appconfig.properties")
public class AppConfig {
    private int maxAttempts;
    private int minAttempts;
}
