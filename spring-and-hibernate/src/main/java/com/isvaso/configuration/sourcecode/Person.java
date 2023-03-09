package com.isvaso.configuration.sourcecode;

public class Person {

    private String name;
    private String surname;
    private Job job;

    public Person(String name, String surname, Job job) {
        this.name = name;
        this.surname = surname;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void work() {
        System.out.format("%s %s %s as a(an) %s.\n",
                name, surname, job.work(), job.getJobName());
    }
}
