package com.isvaso.springboot.service;

import com.isvaso.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    public void deleteEmployeeByName(String name);

    public List<Employee> findEmployeesByName(String name);
}
