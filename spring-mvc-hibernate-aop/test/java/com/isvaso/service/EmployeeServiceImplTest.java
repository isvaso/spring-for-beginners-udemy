package com.isvaso.service;

import com.isvaso.dao.EmployeeDAO;
import com.isvaso.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * EmployeeServiceTest contains the unit tests for EmployeeService.
 */
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeDAO employeeDAO;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    /**
     * Sets up the test environment by initializing the mock objects and
     * creating a new instance of the EmployeeServiceImpl class with the mock
     * EmployeeDAO.
     */
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests that getAllEmployees() returns the expected list of employees.
     * Uses a mock EmployeeDAO that returns a predefined list, then compares
     * the result to the expected list and verifies that getAllEmployees()
     * was called exactly once.
     */
    @Test
    public void testGetAllEmployees() {
        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(new Employee("John", "Doe", "HR", 1111));

        when(employeeDAO.getAllEmployees()).thenReturn(expectedEmployees);

        List<Employee> actualEmployees = employeeService.getAllEmployees();

        assertEquals(expectedEmployees.size(), actualEmployees.size());
        assertEquals(expectedEmployees.get(0).getName(), actualEmployees.get(0).getName());
        assertEquals(expectedEmployees.get(0).getSurname(), actualEmployees.get(0).getSurname());
        assertEquals(expectedEmployees.get(0).getDepartment(), actualEmployees.get(0).getDepartment());

        verify(employeeDAO, times(1)).getAllEmployees();
    }

    /**
     * Tests that saveEmployee() saves an employee using a mock EmployeeDAO.
     * Verifies that saveEmployee() was called exactly once.
     */
    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee("John", "Doe", "HR", 1111);

        employeeService.saveEmployee(employee);

        verify(employeeDAO, times(1)).saveEmployee(employee);
    }

    /**
     * Tests that getEmployee() returns the expected employee.
     * Uses a mock EmployeeDAO that returns a predefined employee, then compares
     * the result to the expected employee and verifies that getEmployee()
     * was called exactly once.
     */
    @Test
    public void testGetEmployee() {
        int id = 1;
        Employee expectedEmployee = new Employee("John", "Doe", "HR", 1111);

        when(employeeDAO.getEmployee(id)).thenReturn(expectedEmployee);

        Employee actualEmployee = employeeService.getEmployee(id);

        assertEquals(expectedEmployee.getName(), actualEmployee.getName());
        assertEquals(expectedEmployee.getSurname(), actualEmployee.getSurname());
        assertEquals(expectedEmployee.getDepartment(), actualEmployee.getDepartment());

        verify(employeeDAO, times(1)).getEmployee(id);
    }

    /**
     * Tests that deleteEmployee() deletes an employee using a mock EmployeeDAO.
     * Verifies that deleteEmployee() was called exactly once.
     */
    @Test
    public void testDeleteEmployee() {
        int id = 1;

        employeeService.deleteEmployee(id);

        verify(employeeDAO, times(1)).deleteEmployee(id);
    }
}