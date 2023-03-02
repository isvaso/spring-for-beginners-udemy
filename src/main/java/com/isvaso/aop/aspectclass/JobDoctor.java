package com.isvaso.aop.aspectclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("jobDoctorBean")
public class JobDoctor implements Job {

    private final Logger logger = LogManager.getLogger(JobDoctor.class.getName());
    private final String name = "Doctor";

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
        return "Doctor";
    }

    @Override
    public String work() {
        return "treats a patient";
    }
}
