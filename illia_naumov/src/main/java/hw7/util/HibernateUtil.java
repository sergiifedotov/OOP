package hw7.util;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by illia_naumov
 */
public class HibernateUtil {
    private static Logger log = Logger.getLogger(HibernateUtil.class);
    private static  SessionFactory sessionFactory;

    public HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                Locale.setDefault(Locale.ENGLISH);
                Configuration cfg = new Configuration().configure("hw7/hibernate.cfg.xml");
                StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
                sb.applySettings(cfg.getProperties());
                StandardServiceRegistry standardServiceRegistry = sb.build();
                sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
                return sessionFactory;
            } catch (Throwable e) {
                log.error("Initial SessionFactory creation failed.", e);
                throw new ExceptionInInitializerError(e);
            }
        } else {
            return sessionFactory;
        }
    }

    public static void closeFactory() {
        if (sessionFactory != null) {
            try {
                sessionFactory.close();
            } catch (HibernateException ignored) {
                log.error("Couldn't close SessionFactory", ignored);
            }
        }
    }




}
