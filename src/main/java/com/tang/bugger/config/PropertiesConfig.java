package com.tang.bugger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = { "classpath:remote-db.properties"})
public class PropertiesConfig {
}