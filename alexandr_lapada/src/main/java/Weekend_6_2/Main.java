package Weekend_6_2;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by sanya on 14.02.2015.
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        /*
        Employee employee1 = new Employee("Sasha", "La", 23, (long) 1);
        Employee employee2 = new Employee("Al", "Der", 28, (long) 2);
        Employee employee3 = new Employee("Eg", "GG", 13, (long) 3);
        Employee employee4 = new Employee("Ro", "Ftu", 24, (long) 4);
        Employee employee5 = new Employee("Pit", "Add", 33, (long) 5);

        Company company1 = new Company("ItCentre", (long) 1);
        Company company2 = new Company("W&H", (long) 2);

        company1.addEmployee(employee1);
        employee1.setCompany(company1);
        company1.addEmployee(employee2);
        employee2.setCompany(company1);
        company1.addEmployee(employee3);
        employee3.setCompany(company1);

        company2.addEmployee(employee4);
        employee4.setCompany(company2);
        company2.addEmployee(employee5);
        employee5.setCompany(company2);

        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(company1);
            session.save(company2);
            session.save(employee1);
            session.save(employee3);
            session.save(employee4);
            session.save(employee5);
            session.save(employee2);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.err.println("Conn BE");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();

            }
        }
        log.info(session);
*/
        Session session = null;
        Long id;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter id company");
        id = scan.nextLong();

        List<Notebook> list = null;
        Company company = null;
        try {
            session = factory.openSession();
            company = (Company)session.get(Company.class,id);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();

            }
        }
        Iterator<Employee> iter = company.getEmployees().iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().getName());
        }
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(company);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
                factory.close();
            }
        }

    }

}
