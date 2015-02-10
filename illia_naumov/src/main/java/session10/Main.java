package session10;

import session9.HiberConnect;
import session9.Region;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by user on 08.02.2015.
 */
public class Main {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        SessionFactory factory;
        {
            Locale.setDefault(Locale.ENGLISH);
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            factory = cfg.buildSessionFactory(standardServiceRegistry);
            log.info("Reference to SessionFactory " + factory);
        }

        RegionHibernateDaoImpl dao = new RegionHibernateDaoImpl(factory);
        for (Region i : dao.findAllRegionsWithName()) {
            System.out.println(i.getRegion_name());
        }

    }
}
