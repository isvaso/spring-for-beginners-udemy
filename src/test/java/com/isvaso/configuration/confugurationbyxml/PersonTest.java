package com.isvaso.configuration.confugurationbyxml;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class PersonTest {

    @Test
    void personTest() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "configbyxml/applicationContext.xml");

        Person person = context.getBean("personBean", Person.class);
        person.work();

        context.close();
    }

}