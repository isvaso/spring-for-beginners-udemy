package com.isvaso.configuration.byannotationswaytwo;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void personTest() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigurationClass.class);

        Person person = context.getBean("personBean", Person.class);
        person.work();

        context.close();
    }
}