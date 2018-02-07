package com.tang.bugger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = { "classpath:remote-db.properties", "classpath:remote-dubbo.properties"})//在这里加入redis配置读取
@ImportResource({ "classpath:dubbo/*.xml" })
public class PropertiesConfig {
}