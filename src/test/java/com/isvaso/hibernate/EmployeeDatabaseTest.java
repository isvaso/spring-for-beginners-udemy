package com.isvaso.hibernate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDatabaseTest {

    @Test
    void saveEmployee() {
        Employee employee =
                new Employee(
                        "Ury",
                        "Dud",
                        "HR",
                        1080);

        assertTrue(EmployeeDatabase.saveEmployee(employee));
    }

    @Test
    void getEmployeeById() {
        Employee employee =
                new Employee(
                        "Phillip",
                        "Morris",
                        "IT",
                        1000);

        EmployeeDatabase.saveEmployee(employee);
        assertEquals(employee, EmployeeDatabase.getEmployeeById(employee.getId()));
    }
}