package session11.company.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import session11.company.dao.CompanyDaoImpl;

import java.util.Locale;

/**
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static Logger log = Logger.getLogger(CompanyDaoImpl.class);

    private static SessionFactory buildSessionFactory() {

        try {
            Locale.setDefault(Locale.ENGLISH);
            return new Configuration().configure("session11/hibernate.cfg.xml").buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
