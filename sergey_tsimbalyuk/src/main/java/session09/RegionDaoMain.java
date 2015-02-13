package session09;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by tsv on 08.02.15.
 */
public class RegionDaoMain {
    private static Logger log = Logger.getLogger(RegionHibernateDaoImpl.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
//
//        RegionHibernateDaoImpl regionHibernateDao = new RegionHibernateDaoImpl(factory);
//
//        Region Arctic = new Region();
//        Arctic.setName("Arctic");
//        regionHibernateDao.create(Arctic);
//        factory.close();
//    }

    RegionHibernateDaoImpl regionHibernateDao = new RegionHibernateDaoImpl(factory);
    List<Region> regionList;
    regionList = regionHibernateDao.findAll();
    for (Region region:regionList){
        System.out.println(region.toString());
    }
}
}
