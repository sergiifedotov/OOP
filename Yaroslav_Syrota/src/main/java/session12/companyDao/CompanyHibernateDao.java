package session12.companyDao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;
import java.util.Set;

/**
 * Created by Admin on 15.02.2015.
 */
public class CompanyHibernateDao implements CompanyDao {
    private static Logger logger = Logger.getLogger(CompanyHibernateDao.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public CompanyHibernateDao() {
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

    @Override
    public void setFond(int fond) {

    }

    @Override
    public int getFond() {
        return 0;
    }

    @Override
    public Set<Employee> returnAll() {
        return null;
    }
}
