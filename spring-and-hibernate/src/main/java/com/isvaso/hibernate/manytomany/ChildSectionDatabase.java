package com.isvaso.hibernate.manytomany;

import com.isvaso.hibernate.manytomany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ChildSectionDatabase {

    public static void addChildListToSection(List<Child> childList, Section section) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            childList.forEach(section::addChild);
            session.persist(section);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Child> getChildrenBySectionId(int id) {
        List<Child> childList;

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Section section = session.get(Section.class, id);
            childList = section.getChildList();

            session.getTransaction().commit();

            return childList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Section> getSectionsByChildrenId(int id) {
        List<Section> sectionList;

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Child section = session.get(Child.class, id);
            sectionList = section.getSectionList();

            session.getTransaction().commit();

            return sectionList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteSectionById(int id) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Section section = session.get(Section.class, id);
            session.delete(section);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
