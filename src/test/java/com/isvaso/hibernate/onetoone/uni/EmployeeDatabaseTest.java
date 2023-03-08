package com.isvaso.hibernate.onetoone.uni;

import com.isvaso.hibernate.onetoone.uni.entity.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDatabaseTest {

    @Test
    void saveEmployee() {
        Detail employeeDetail = new Detail(
                "Moscow",
                "+7(495)456-12-14",
                "ivivan97@list.ru");

        Employee employee =
                new Employee(
                        "Vasya",
                        "Pupkin",
                        "ADS",
                        500,
                        employeeDetail);

        assertTrue(EmployeeDatabase.saveEmployee(employee));
    }

    @Test
    void getEmployeeById() {
        Employee employee = EmployeeDatabase.getEmployeeById(35);
        System.out.println(employee + " " + employee.getEmployeeDetail());
    }

    @Test
    void getEmployeesByName() {
        List<Employee> employees = EmployeeDatabase.getEmployeesByName("Phillip");
        employees.forEach(n -> System.out.println(n + " " + n.getEmployeeDetail()));
    }

    @Test
    void getEmployeesByDepartment() {
        List<Employee> employees = EmployeeDatabase.getEmployeesByDepartment("IT");
        assert (employees != null);
        employees.forEach(n -> System.out.println(n + " " + n.getEmployeeDetail()));
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
        Employee employee = EmployeeDatabase.getEmployeeById(37);
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