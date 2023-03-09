package com.isvaso.aop.aspectclass;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void text() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigurationClass.class);

        Person person = context.getBean("personBean", Person.class);
        person.setJob(new JobDoctor());
        person.work();

        context.close();
    }
}