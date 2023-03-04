package com.isvaso.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class EmployeeDatabase {

    public static boolean saveEmployee(Employee employee) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            sessionFactory.close();
        }
        return true;
    }

    public static Employee getEmployeeById(int id) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();

        sessionFactory.close();

        return employee;
    }

    public static List<Employee> getEmployeesByName(String name) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        String hql = "FROM Employee AS E WHERE E.name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        List<Employee> employees = query.getResultList();

        session.getTransaction().commit();
        sessionFactory.close();

        return employees;
    }

    public static List<Employee> getEmployeesByDepartment(String department) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        String hql = "FROM Employee AS E WHERE E.department = :department";
        Query query = session.createQuery(hql);
        query.setParameter("department", department);
        List<Employee> employees = query.getResultList();

        session.getTransaction().commit();
        sessionFactory.close();

        return employees;
    }
}
