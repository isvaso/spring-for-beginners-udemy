package com.isvaso.springboot.service;

import com.isvaso.springboot.dao.EmployeeRepository;
import com.isvaso.springboot.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        } else {
            throw new NoSuchElementException("There is no employee with id = " +
                    id + " in database");
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteEmployeeByName(String name) {
        employeeRepository.deleteByName(name);
    }

    @Override
    public List<Employee> findEmployeesByName(String name) {

        return employeeRepository.findAllByName(name);
    }
}
