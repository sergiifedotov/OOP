package session12.companyDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session11.company.Company;
import session11.company.Employee;

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
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        Session session = factory.openSession();

        session11.company.Company comp1 = new session11.company.Company("Sony");
        session11.company.Company comp2 = new Company("Toshiba");
        Set<Employee> compSet1 = new HashSet<Employee>();
        compSet1.add(new Employee("Vasya", comp1));
        compSet1.add(new Employee("Tolya", comp1));
        compSet1.add(new Employee("Kolya", comp1));
        Set<Employee> compSet2 = new HashSet<Employee>();
        compSet2.add(new Employee("Grisha", comp2));
        compSet2.add(new Employee("Misha", comp2));
        comp1.setEmployeeSet(compSet1);
        comp2.setEmployeeSet(compSet2);

        session.beginTransaction();
        session.save(comp1);
        session.save(comp2);
        for(Employee x : comp1.getEmployeeSet()) {
            session.save(x);
        }
        for(Employee x : comp2.getEmployeeSet()) {
            session.save(x);
        }

        session.getTransaction().commit();


    }
}
