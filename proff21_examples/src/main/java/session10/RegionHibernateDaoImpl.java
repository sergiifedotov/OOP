package session10;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
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
            return (Region) session.get(Region.class, id);
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

    }

    @Override
    public void delete(Region region) {

    }

    public List<Region> getPortion(int firstResult, int maxResults) {
        Session session = factory.openSession();
        try {
            return session.createCriteria(Region.class)
                    .setMaxResults(maxResults)
                    .setFirstResult(firstResult)
                    .list();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public Long rowsCount() {
        Session session = factory.openSession();
        try {
            return (Long)session.createCriteria(Region.class)
                    .setProjection(Projections.rowCount())
                    .uniqueResult();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Region> findAll() {
        Session session = factory.openSession();
        try {
            return session.createCriteria(Region.class)
                    .add(Restrictions.eq("id", 3))
                    .add(Restrictions.like("name", "%e%"))
                    .list();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }
}
