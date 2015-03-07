package session11;

/**
 * Created by stan on 15.02.15.
 */

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 21.09.14
 */
public class Main {
    public static void main(String[] args) throws IOException {
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session9.HiberConnect;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Main {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        Session session = factory.openSession();

        Company company1 = new Company("Roga");
        Company company2 = new Company("Kopyta");

        Employee emp1 = new Employee("Ostap Bender");
        Employee emp2 = new Employee("Robot Bender");
        Employee emp3 = new Employee("Lila Bender");
        Employee emp4 = new Employee("Shura Balaganov");
        Employee emp5 = new Employee("Mikael Samuilovich Panikovskiy");

        company1.getEmps().add(emp1);
        company1.getEmps().add(emp2);
        company1.getEmps().add(emp3);

        company2.getEmps().add(emp4);
        company2.getEmps().add(emp5);

/*        session.beginTransaction();
        session.save(company1);
        session.save(company2);
        session.save(emp1);
        session.save(emp2);
        session.save(emp3);
        session.save(emp4);
        session.save(emp5);
        session.getTransaction().commit();*/
        ReadableByteChannel in = Channels.newChannel(System.in);
        ByteBuffer buffer = ByteBuffer.allocate(40);
        CharBuffer buffer1 = CharBuffer.allocate(3);
        int readed = in.read(buffer);
//        int id = Integer.parseInt(new String(buffer.array(), 0, readed - 1));
        String name = new String(buffer.array(), 0, readed - 1);

        Company cmp = (Company) session.get(Company.class, name);

        session.close();

        System.out.println(cmp.getEmps());

        factory.close();
        log.info("Reference to SessionFactory " + factory);

        Session session = null;


        Company company1 = new Company();
        company1.setName("samsung");
        company1.setFond(156);

        Company company2 = new Company();
        company2.setName("Philips");
        company2.setFond(157);

        Employee e1 = new Employee();
        e1.setFirstName("John");
        e1.setLastName("Doe");
        e1.setCompany(company1);

        Employee e2 = new Employee();
        e2.setFirstName("John");
        e2.setLastName("Smith");
        e2.setCompany(company1);

        Employee e3 = new Employee();
        e3.setFirstName("John");
        e3.setLastName("Conor");
        e3.setCompany(company1);

        Employee e4 = new Employee();
        e4.setFirstName("John");
        e4.setLastName("A");
        e4.setCompany(company2);

        Employee e5 = new Employee();
        e5.setFirstName("John");
        e5.setLastName("B");
        e5.setCompany(company2);

        Employee e6 = new Employee();
        e6.setFirstName("John");
        e6.setLastName("C");
        e6.setCompany(company2);

        Set<Employee> set1 = new HashSet<>();
        set1.add(e1);
        set1.add(e2);
        set1.add(e3);

        Set<Employee> set2 = new HashSet<>();
        set2.add(e4);
        set2.add(e5);
        set2.add(e6);

        company1.setEmployees(set1);
        company2.setEmployees(set2);

        CompanyDao companyDao = new CompanyHibernateDAOImpl(factory);

        companyDao.create(company1);
        companyDao.create(company2);

//        EmployeeDao emplDao = new EmployeeHibernateDAOImpl(factory);
//        emplDao.create(e1);
//        emplDao.create(e2);
//        emplDao.create(e3);
//        emplDao.create(e4);
//        emplDao.create(e5);
//        emplDao.create(e6);
//        session.close();
        factory.close();

    }
}
