package session10;

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
 *
 */
public class HiberConnect {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        RegionHibernateDaoImpl regionHibernateDao = new RegionHibernateDaoImpl(factory);

        //regionHibernateDao.update(new Region(5L,"Antarctica"));

        regionHibernateDao.delete(new Region(5L,"Antarctica"));

        if (factory != null) {
            factory.close();
        }
    }
}

