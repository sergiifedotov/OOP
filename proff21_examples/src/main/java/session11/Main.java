package session11;

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
    }
}
