package com.isvaso.configuration.sourcecode;

public class JobBuilder implements Job {

    private final String name = "Builder";

    public String getJobName() {
        return name;
    }

    @Override
    public String work() {
        return "builds a building";
    }
}
