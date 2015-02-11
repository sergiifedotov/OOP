package session9;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Chuvychin on 08.02.2015.
 */
public class MainRegion {
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        RegionHibernateDaoImpl regionHibernateDao = new RegionHibernateDaoImpl(factory);


        /*Region avs = regionHibernateDao.read((long)40);
        regionHibernateDao.delete(avs);*/

        ArrayList<Region> list = (ArrayList<Region>) regionHibernateDao.findAll();
        for (int i=0; i<list.size(); i++){
            System.out.println("---------------------------------");
            System.out.println(list.get(i).getRegionName()+ "  "+list.get(i).getId());

        }

        ArrayList<Region> list2 = (ArrayList<Region>) regionHibernateDao.findAllThisName();
        for (int i=0; i<list2.size(); i++){
            System.out.println("---------------------------------");
            System.out.println(list2.get(i).getRegionName()+ "  "+list2.get(i).getId());


        }
        factory.close();

    }
}
