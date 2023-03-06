package com.isvaso.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDatabase {

    public static boolean saveEmployee(Employee employee) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Employee getEmployeeById(int id) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, id);
            session.getTransaction().commit();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Employee> getEmployeesByName(String name) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            String hql = "FROM Employee AS E WHERE E.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            List<Employee> employees = query.getResultList();

            session.getTransaction().commit();
            return employees;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Employee> getEmployeesByDepartment(String department) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            String hql = "FROM Employee AS E WHERE E.department = :department";
            Query query = session.createQuery(hql);
            query.setParameter("department", department);
            List<Employee> employees = query.getResultList();

            session.getTransaction().commit();
            return employees;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setEmployeeSalaryById(int id, int salary) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, id);
            employee.setSalary(salary);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setEmployeesSalaryByName(String name, int salary) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            String hql = "UPDATE Employee SET salary = :salary WHERE name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            query.setParameter("salary", salary);
            query.executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Employee deleteEmployeeById(int id) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, id);
            assert (employee != null);
            session.delete(employee);

            session.getTransaction().commit();

            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Employee> deleteEmployeesByName(String name) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            String hqlSelect = "FROM Employee WHERE name = :name";
            Query querySelect = session.createQuery(hqlSelect);
            querySelect.setParameter("name", name);
            List<Employee> employees = querySelect.getResultList();
            //assert (!employees.isEmpty());

            String hqlDelete = "DELETE Employee WHERE name = :name";
            Query queryDelete = session.createQuery(hqlDelete);
            queryDelete.setParameter("name", name);
            queryDelete.executeUpdate();

            session.getTransaction().commit();

            return employees;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
