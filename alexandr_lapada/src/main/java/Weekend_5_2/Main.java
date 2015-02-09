package Weekend_5_2;

import Weekend_5_1.HiberConnect;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by sanya on 08.02.2015.
 */
public class Main {
    private static Logger log = Logger.getLogger(HiberConnect.class);
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        RegionHibernateDaoImpl regionDao = new RegionHibernateDaoImpl(factory);
        Region region = new Region();
        region.setId((long) 10);

        factory.close();



    }
}
