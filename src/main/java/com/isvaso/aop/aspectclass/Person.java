package com.isvaso.aop.aspectclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("personBean")
@Scope("prototype")
public class Person {

    private final Logger logger = LogManager.getLogger(Person.class.getName());
    private String name;
    private String surname;
    private Job job;

    @Autowired
    public Person(@Value("${person.name}") String name,
                  @Value("${person.surname}") String surname,
                  @Qualifier("jobBuilderBean") Job job) {

        this.name = name;
        this.surname = surname;
        this.job = job;
    }

    @PostConstruct
    public void init() {
        logger.debug("Initialization");
    }
    @PreDestroy
    public void destroy() {
        logger.debug("Destroyed");
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
