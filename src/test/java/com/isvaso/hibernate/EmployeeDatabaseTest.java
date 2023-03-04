package com.isvaso.hibernate;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void getEmployeesByName() {
        List<Employee> employees = EmployeeDatabase.getEmployeesByName("Gosha");
        employees.forEach(n -> System.out.println(n));
    }

    @Test
    void getEmployeesByDepartment() {
        List<Employee> employees = EmployeeDatabase.getEmployeesByDepartment("HR");
        employees.forEach(n -> System.out.println(n));
    }
}