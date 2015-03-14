package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import hw7.springnotes.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vladimir on 17.02.2015.
 */
public class VendorDaoImpl implements VendorDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Logger logger = Logger.getLogger(NotebookDaoImpl.class);

    public VendorDaoImpl() {
    }

    public VendorDaoImpl(SessionFactory sessionFactory) {
        this();
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(vendor);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            logger.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Vendor read(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            return (Vendor) session.get(Vendor.class, id);
        } catch (HibernateException e) {
            logger.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<Vendor> findAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Vendor.class);
            return criteria.list();
        } catch (HibernateException e) {
            logger.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }
}
