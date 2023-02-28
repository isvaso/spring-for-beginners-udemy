package com.isvaso.configuration.confugurationbyxml;

public class JobDoctor implements Job {

    private final String name = "Doctor";

    public void init() {
        System.out.println(this.getClass().getName() + ": initialized");
    }

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
