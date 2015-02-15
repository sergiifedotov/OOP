package hw6.notes.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by vladimir on 11.02.2015.
 */
public class HibernateUtil {
    private static Logger logger = Logger.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            registryBuilder.applySettings(configuration.getProperties());
            StandardServiceRegistry serviceRegistry = registryBuilder.build();
            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable e) {
            logger.error("Initial SessionFactory creation failed.", e);
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
