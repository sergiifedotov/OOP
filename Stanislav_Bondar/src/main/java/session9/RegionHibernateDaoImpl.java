package session9;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Locale;

/**
* Created by stan on 08.02.15.
*/
public class RegionHibernateDaoImpl implements RegionDao {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
        RegionHibernateDaoImpl regionHibernateDao = new RegionHibernateDaoImpl(factory);

        List<Region> regionList;
        regionList = regionHibernateDao.findAll();
        for (Region region:regionList){
            System.out.println(region.toString());
        }

//
//        Region Arctic = new Region();
//        Arctic.setName("Arctic");
//        regionHibernateDao.create(Arctic);
//        factory.close();
    }
    private static Logger log = Logger.getLogger(RegionHibernateDaoImpl.class);
    private static SessionFactory factory;

    public RegionHibernateDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Region region) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(region);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Region read(Long id){
        Session session=null;
        try{
            session=factory.openSession();
            return (Region)session.get(Region.class,id);
        }
        finally {

        }
    }

    @Override
    public void update(Region region) {
        Session session=null;
        try {
            session=factory.openSession();
            session.update(region);
        }
        finally {
            if (session!=null){
                session.close();
            }
        }

    }

    @Override
    public void delete(Region region) {
        Session session = null;
        try{
            session=factory.openSession();
            session.beginTransaction();
            session.delete(region);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }

    }

    @Override
    public List<Region> findAll() {
       Session session = factory.openSession();
        try{
            return (List<Region>)session.createCriteria(Region.class).list();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

}