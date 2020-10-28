package com.pluralsight.springcourse.swagger.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.pluralsight.springcourse"})
@PropertySource(value = "classpath:properties/swagger.properties", encoding = "UTF-8")
public class AppConfig {
    public AppConfig() {
    }
}
