package com.isvaso.hibernate;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDatabaseTest {

    @Test
    void saveEmployee() {
        Employee employee =
                new Employee(
                        "Phillip",
                        "Morris",
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
        List<Employee> employees = EmployeeDatabase.getEmployeesByName("Phillip");
        employees.forEach(n -> System.out.println(n));
    }

    @Test
    void getEmployeesByDepartment() {
        List<Employee> employees = EmployeeDatabase.getEmployeesByDepartment("IT");
        assert (employees != null);
        employees.forEach(System.out::println);
    }

    @Test
    void setEmployeeSalaryById() {
        EmployeeDatabase.setEmployeeSalaryById(2, 1000);
        assertEquals(1000,
                Objects.requireNonNull(
                        EmployeeDatabase.getEmployeeById(2)).getSalary());
    }

    @Test
    void setEmployeeSalaryByName() {
        EmployeeDatabase.setEmployeesSalaryByName("Vasya", 666);
        assertEquals(666,
                Objects.requireNonNull(
                        EmployeeDatabase.getEmployeeById(0)).getSalary());
    }

    @Test
    void deleteEmployeeById() {
        Employee employee = EmployeeDatabase.getEmployeeById(14);
        assert (employee != null);
        assertEquals(employee, EmployeeDatabase.deleteEmployeeById(employee.getId()));

    }

    @Test
    void deleteEmployeesByName() {
        List<Employee> assertList =
                EmployeeDatabase.getEmployeesByName("Phillip");
        List<Employee> deletedEmployees =
                EmployeeDatabase.deleteEmployeesByName("Phillip");
        assertEquals(assertList, deletedEmployees);
    }
}