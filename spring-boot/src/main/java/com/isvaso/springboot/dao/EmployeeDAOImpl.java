package com.isvaso.springboot.dao;

import com.isvaso.springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        String hql = "SELECT E FROM Employee AS E";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee tempEmployee = entityManager.merge(employee);
        employee.setId(tempEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        String hql = "DELETE FROM Employee AS E WHERE E.id =:id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
