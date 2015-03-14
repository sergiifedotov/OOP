package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import hw7.springnotes.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 *
 */
public class VendorDaoImpl implements VendorDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);


    public static void main(String[] args) {

        VendorDaoImpl vendorDaoImpl = new VendorDaoImpl();

        System.out.println(vendorDaoImpl.findAll().toString());

    }

    public VendorDaoImpl() {

    }

    @Override
    public Long create(Vendor vendor) {
        Session session = HibernateUtil.getSession();
        try {
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
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
        return null;
    }

    @Override
    public Vendor read(Long id) {

        Session session = HibernateUtil.getSession();
        try {
            return (Vendor) session.get(Vendor.class,id);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if(session != null) {
                session.close();
            }
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
            return false;
        } finally {
            if(session != null) {
                session.close();
            }
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
            return false;
        } finally {
            if(session != null) {
                session.close();
            }
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    @Override
    public List<Vendor> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return (List) session.createCriteria(Vendor.class).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
        return null;

    }

}