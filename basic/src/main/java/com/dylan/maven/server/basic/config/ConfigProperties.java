package com.dylan.maven.server.basic.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Dylan
 * @Date 2023/8/26
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "base.config")
public class ConfigProperties {
    private String name;
    private String port;
    private String applicationName;
    private String active;
}
