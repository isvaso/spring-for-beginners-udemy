package com.isvaso.configuration.byannotationswaytwo;

import com.isvaso.configuration.byxmlandannotations.Job;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JobDoctor implements Job {

    private final String name = "Doctor";

    @PostConstruct
    public void init() {
        System.out.println(this.getClass().getName() + ": initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(this.getClass().getName() + ": destroyed");
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
