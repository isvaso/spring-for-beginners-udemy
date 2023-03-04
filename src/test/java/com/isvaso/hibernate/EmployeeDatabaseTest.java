package com.isvaso.hibernate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDatabaseTest {

    @Test
    void saveEmployee() {
        Employee employee =
                new Employee(
                "Jacob",
                "Coller",
                "SoundMusic",
                1000);

        assertTrue(EmployeeDatabase.saveEmployee(employee));
    }
}