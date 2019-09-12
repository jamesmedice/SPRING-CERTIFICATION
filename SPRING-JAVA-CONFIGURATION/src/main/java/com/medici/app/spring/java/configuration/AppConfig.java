package com.medici.app.spring.java.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.medici.app.spring.resource", "com.medici.app.spring.prototype", "com.medici.app.spring.java.spel" }, excludeFilters = { @ComponentScan.Filter(Configuration.class) })
public class AppConfig {

}
