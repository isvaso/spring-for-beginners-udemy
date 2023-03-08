package com.isvaso.hibernate.onetomany.bi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testEquals() {
        Employee employee1 = new Employee("Ivan", "Ivanov", 1000);
        Employee employee2 = new Employee("Ivan", "Ivanov", 1000);
        assertTrue(employee1.equals(employee2));
    }
}