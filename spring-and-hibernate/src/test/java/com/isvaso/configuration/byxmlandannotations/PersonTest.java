package com.isvaso.configuration.byxmlandannotations;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void personTest() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "configurations/byxmlandannotations/applicationContext.xml");

        Person person = context.getBean("personBean", Person.class);
        person.work();

        context.close();
    }

}