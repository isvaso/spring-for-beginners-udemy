package com.isvaso.configuration.byannotationswayone;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("jobBuilderBean")
class JobBuilder implements Job {

    private final String name = "Builder";

    @PostConstruct
    public void init() {
        System.out.println(this.getClass().getName() + ": initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(this.getClass().getName() + ": destroyed");
    }

    public String getJobName() {
        return name;
    }

    @Override
    public String work() {
        return "builds a building";
    }
}
