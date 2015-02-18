package session10;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import session9.Region;

import java.util.List;

/**
 *
 */
public class RegionHibernateDaoImpl implements RegionDao {
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
            return (Region) session.get(Region.class,id);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
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
        Session session = null;
        try {
            session = factory.openSession();
            return (List) session.createCriteria(Region.class).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;

    }

    @Override
    public List<Region> FindAllRegionsWithName(){
        Session session = null;
        try {
            session = factory.openSession();
            return (List) session.createCriteria(Region.class)
                    //.add(Restrictions.isNotEmpty("regionName"))
                    .add(Restrictions.isNotNull("regionName")).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;

    }


}
