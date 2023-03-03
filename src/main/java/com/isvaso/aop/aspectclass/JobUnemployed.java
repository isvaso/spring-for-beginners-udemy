package com.isvaso.aop.aspectclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("jobUnemployedBean")
public class JobUnemployed implements Job {

    private final Logger logger = LogManager.getLogger(JobBuilder.class.getName());

    private final String name = "Unemployed";

    @PostConstruct
    public void init() {
        logger.debug("Initialization");
    }

    @PreDestroy
    public void destroy() {
        logger.debug("Destroyed");
    }

    @Override
    public String getJobName() {
        return name;
    }

    @Override
    public String work() {
        return "can't work";
    }
}
