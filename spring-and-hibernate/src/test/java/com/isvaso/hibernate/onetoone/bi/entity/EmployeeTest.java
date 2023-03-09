package com.isvaso.hibernate.onetoone.bi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testEquals() {
        Detail employeeDetail = new Detail(
                "Moscow",
                "+7(495)456-12-14",
                "ivivan97@list.ru");

        Employee employee1 = new Employee(
                "Ivan",
                "Ivanov",
                "HR",
                1000,
                employeeDetail);

        Employee employee2 = new Employee(
                "Ivan",
                "Ivanov",
                "HR",
                1000,
                employeeDetail);

        assertTrue(employee1.equals(employee2));
    }
}