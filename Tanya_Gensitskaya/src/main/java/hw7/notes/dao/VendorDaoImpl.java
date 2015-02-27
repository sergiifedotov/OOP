package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import hw7.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 19.02.2015.
 */
public class VendorDaoImpl implements VendorDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);
    private SessionFactory factory = new HibernateUtil().buildSessionFactory();

    public VendorDaoImpl() {
    }


    @Override
    public Long create(Vendor vendor) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(vendor);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Vendor read(Long ig) {
        Session session = null;
        Vendor vendor = new Vendor();
        try {
            session = factory.openSession();
            session.beginTransaction();
            vendor = (Vendor)session.get(Vendor.class, ig);
            session.getTransaction().commit();
            return vendor;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return vendor;
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
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
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
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<Vendor> findAll() {
        List<Vendor> list = new ArrayList<>();

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            list = session.createCriteria(Vendor.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }
}
