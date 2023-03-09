package com.isvaso.aop.aspectclass;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.isvaso.aop.aspectclass")
@PropertySource("classpath:configurations/byannotationswayone/application.properties")
@EnableAspectJAutoProxy
public class ConfigurationClass {
}
