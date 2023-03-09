package com.isvaso.hibernate.onetomany.uni;

import com.isvaso.hibernate.onetomany.uni.entity.Department;
import com.isvaso.hibernate.onetomany.uni.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class EmployeeDatabaseTest {

    @Test
    void saveDepartmentWithEmployees() {
        List<Employee> employeeList = new ArrayList<>(10);
        employeeList.add(new Employee(
                "Gleb",
                "Ivanov",
                200));
        employeeList.add(new Employee(
                "Anna",
                "Dubova",
                900));

        Department department = new Department(
                "HR",
                300,
                1000);

        EmployeeDatabase.saveDepartmentWithEmployees(employeeList, department);
    }

    @Test
    void getEmployeesByDepartment() {
        List<Employee> employeeList =
                EmployeeDatabase.getEmployeesByDepartmentId(51);
        assert (employeeList != null);
        employeeList.forEach(System.out::println);
    }
}