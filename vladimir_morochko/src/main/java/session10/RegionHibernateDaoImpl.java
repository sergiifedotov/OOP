package session10;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
 */
public class RegionHibernateDaoImpl implements RegionDao {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        RegionHibernateDaoImpl rhd = new RegionHibernateDaoImpl(factory);
        Region region = new Region("Australia");
        Long id = rhd.create(region);
        region = rhd.read(id);
        region.setName("Antarctic");
        rhd.update(region);
        rhd.delete(region);

        factory.close();
    }

    private static Logger log = Logger.getLogger(RegionHibernateDaoImpl.class);
    private SessionFactory factory;

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
    public Region read(Long id) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (Region) session.get(Region.class, id);
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
    public void update(Region region) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(region);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Region region) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(region);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Region> findAll() {
        // NO implementation
        return null;
    }


}
