package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Chuvychin on 20.02.2015.
 */
public class VendorDaoImpl implements VendorDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public VendorDaoImpl() {
    }

    public VendorDaoImpl(SessionFactory factory){
        this.factory = factory;
    }
    @Override
    public Long create(Vendor vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(vendor);
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
    public Vendor read(Long ig) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (Vendor)session.get(Vendor.class, ig);

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return false;
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return false;
    }

    @Override
    public List<Vendor> findAll() {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Vendor>)session.createCriteria(Vendor.class).list();


        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
    }
}
