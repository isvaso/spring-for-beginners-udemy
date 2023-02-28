package com.isvaso.configuration.sourcecode;

import com.isvaso.configuration.byxml.JobDoctor;
import com.isvaso.configuration.byxml.Person;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void personTest() {
        Person person = new Person(
                "Jacob", "Jameson", new JobDoctor());

        person.work();
    }
}