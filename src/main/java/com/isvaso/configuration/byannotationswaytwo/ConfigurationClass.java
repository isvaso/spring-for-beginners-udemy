package com.isvaso.configuration.byannotationswaytwo;

import org.springframework.context.annotation.*;

@Configuration
public class ConfigurationClass {

    @Bean
    public JobBuilder jobBuilderBean() {
        return new JobBuilder();
    }

    @Bean
    public JobDoctor jobDoctorBean() {
        return new JobDoctor();
    }

    @Bean
    @Scope("prototype")
    public Person personBean() {
        return new Person("Jacob", "Jameson", jobDoctorBean());
    }
}
