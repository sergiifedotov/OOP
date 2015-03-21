package session09;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
 */
public class RegionHibernateDaoImpl implements RegionDao {

    public RegionHibernateDaoImpl(SessionFactory factory) {

    }

    @Override
    public Long create(Region region) {
        return null;
    }

    @Override
    public Region read(Long id) {
        return null;
    }

    @Override
    public void update(Region region) {

    }

    @Override
    public void delete(Region region) {

    }

    @Override
    public List<Region> findAll() {
        return null;
    }
}
/*
public class RegionHibernateDaoImpl implements RegionDao {
    private static Logger log = Logger.getLogger(RegionHibernateDaoImpl.class);
    private static SessionFactory factory;
    private List<Region> regionList = new ArrayList<Region>();
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
        try {
            return (List<Region>)session.createCriteria(Region.class).list();
//                    session.createCriteria(Region.class)
//                    .add(Restrictions.isNotNull("name"))
//                    .list();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }
}
*/
