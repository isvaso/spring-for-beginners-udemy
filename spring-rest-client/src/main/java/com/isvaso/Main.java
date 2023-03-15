package com.isvaso;

import com.isvaso.configuration.MyConfig;
import com.isvaso.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean(
                "communication", Communication.class);

        Employee employee = new Employee(
                "Sveta",
                "Belkina",
                "HR",
                900);

        communication.saveEmployee(employee);

        List<Employee> employeeList = communication.getAllEmployees();
        System.out.println(employeeList);

        System.out.println(communication.getEmployee(13));

        employee.setId(13);
        employee.setDepartment("HR");
        employee.setSalary(900);
        communication.saveEmployee(employee);

        System.out.println(communication.getEmployee(13));

        communication.deleteEmployee(13);

    }
}
