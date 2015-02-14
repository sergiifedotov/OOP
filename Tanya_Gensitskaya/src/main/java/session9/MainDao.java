package session9;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by ZaR on 08.02.15.
 */
public class MainDao {
    private static Logger log = Logger.getLogger(HiberConnect.class);
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
       // log.info("Reference to SessionFactory " + factory);

         Session session = null;



        try {
            session = factory.openSession();
            RegionHibernateDaoImpl rd = new RegionHibernateDaoImpl(factory);
            Region reg = rd.read(3L);
            System.out.println(reg);
            List<Region> list = rd.findAllRegion();
            for(Region i: list){
                System.out.println(i+" ");
            }
//            Client client = (Client)session.get(Client.class, 1);
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
        log.info(session);
       /* RegionDao rd = new RegionHibernateDaoImpl(session);
        rd.read()*/
    }
}
