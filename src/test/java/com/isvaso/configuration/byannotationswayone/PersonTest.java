package com.isvaso.configuration.byannotationswayone;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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