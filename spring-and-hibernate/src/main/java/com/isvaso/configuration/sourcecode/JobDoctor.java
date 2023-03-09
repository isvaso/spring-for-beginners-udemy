package com.isvaso.configuration.sourcecode;

public class JobDoctor implements Job {

    private final String name = "Doctor";

    @Override
    public String getJobName() {
        return "Doctor";
    }

    @Override
    public String work() {
        return "treats a patient";
    }
}
