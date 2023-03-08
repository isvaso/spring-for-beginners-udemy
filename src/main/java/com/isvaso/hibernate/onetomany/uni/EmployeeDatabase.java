package com.isvaso.hibernate.onetomany.uni;

import com.isvaso.hibernate.onetomany.uni.entity.Department;
import com.isvaso.hibernate.onetomany.uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDatabase {

    public static boolean saveDepartmentWithEmployees(
            List<Employee> employeeList, Department department) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();

            employeeList.forEach(department::addEmployee);

            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<Employee> getEmployeesByDepartmentId(int id) {
        List<Employee> employeeList;
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Department department = session.get(Department.class, id);
            employeeList = department.getEmployeeList();
            session.getTransaction().commit();
            return employeeList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
