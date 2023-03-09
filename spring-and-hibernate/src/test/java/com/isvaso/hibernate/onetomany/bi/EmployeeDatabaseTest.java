package com.isvaso.hibernate.onetomany.bi;

import com.isvaso.hibernate.onetomany.bi.entity.Department;
import com.isvaso.hibernate.onetomany.bi.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class EmployeeDatabaseTest {

    @Test
    void saveDepartmentWithEmployees() {
        List<Employee> employeeList = new ArrayList<>(10);
        employeeList.add(new Employee(
                "Elena",
                "Smirnova",
                100));
        employeeList.add(new Employee(
                "Igor",
                "Zverev",
                1200));
        employeeList.add(new Employee(
                "Mike",
                "Sverdlov",
                800));

        Department department = new Department(
                "IT",
                300,
                1200);

        EmployeeDatabase.saveDepartmentWithEmployees(employeeList, department);
    }

    @Test
    void getEmployeesByDepartment() {
        List<Employee> employeeList =
                EmployeeDatabase.getEmployeesByDepartmentId(47);
        employeeList.forEach(n -> System.out.println(n));
    }
}