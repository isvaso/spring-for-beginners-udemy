package com.isvaso.configuration.byxml;

public class JobBuilder implements Job {

    private final String name = "Builder";

    public void init() {
        System.out.println(this.getClass().getName() + ": initialized");
    }

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
