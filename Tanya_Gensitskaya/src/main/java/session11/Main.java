package session11;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session9.Region;

import java.util.Locale;

/**
 * Created by ZaR on 14.02.15.
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

        Session session = null;
// delete and update
        long id = 130;
        try {
            session = factory.openSession();
//  save
            Company c = new Company();
            c.setName("Sumsung");
//            session.beginTransaction();
//  save
//            session.save(c);

//  delete and update
//            Region r = (Region)session.get(Region.class, id);
//            session.delete(r);
//  update
//            r.setName("Australiya");
//            session.update(r);
//            session.getTransaction().commit();

//            Client client = (Client)session.get(Client.class, 1);
                Company comp = (Company) session.get(Company.class, 1L);
            Employee empl1 = new Employee("Stas", comp);
            Employee empl2 = new Employee("Taras", comp);
            comp.getEmployee().add(empl1);
            comp.getEmployee().add(empl2);
//            session.beginTransaction();
//            session.update(comp);
//            session.getTransaction().commit();

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
//        session.get();
        log.info(session);
    }
}
