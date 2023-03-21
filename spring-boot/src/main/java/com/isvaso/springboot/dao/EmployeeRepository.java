package com.isvaso.springboot.dao;

import com.isvaso.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public void deleteByName(String name);

    public List<Employee> findAllByName(String name);
}
