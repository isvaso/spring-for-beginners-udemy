package com.isvaso.configuration.byannotationswayone;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.isvaso.configuration.byannotationswayone")
@PropertySource("classpath:configurations/byannotationswayone/application.properties")
public class ConfigurationClass {
}
