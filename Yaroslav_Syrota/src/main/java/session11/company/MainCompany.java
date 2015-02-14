package session11.company;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session9.HiberConnect;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by @CAT_Caterpiller on 14.02.2015.
 */

/*
task1 - создать класс компания, в которой работает класс сотрудник. один сотрудник может работать в одной компании.
        создать 2 компании и 5 сотрудников. трудоустроить сотрудников равномерно в компании
*/

public class MainCompany {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Company comp1 = new Company("Sony");
        Company comp2 = new Company("Toshiba");
        Set<Employee> compSet1 = new HashSet<Employee>();
        compSet1.add(new Employee("Vasya", comp1));
        compSet1.add(new Employee("Tolya", comp1));
        compSet1.add(new Employee("Kolya", comp1));
        Set<Employee> compSet2 = new HashSet<Employee>();
        compSet2.add(new Employee("Grisha", comp2));
        compSet2.add(new Employee("Misha", comp2));
        comp1.setEmployeeSet(compSet1);
        comp2.setEmployeeSet(compSet2);


        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(comp1);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        log.info(session);

        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(comp2);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        log.info(session);


    }
}
