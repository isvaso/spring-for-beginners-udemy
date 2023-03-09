package com.isvaso.configuration.sourcecode;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    void personTest() {
        Person person = new Person(
                "Jacob", "Jameson", new JobDoctor());

        person.work();
    }
}