package com.isvaso.configuration.sourcecode;

import com.isvaso.configuration.confugurationbyxml.JobDoctor;
import com.isvaso.configuration.confugurationbyxml.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void personTest() {
        com.isvaso.configuration.confugurationbyxml.Person person = new Person(
                "Jacob", "Jameson", new JobDoctor());

        person.work();
    }
}