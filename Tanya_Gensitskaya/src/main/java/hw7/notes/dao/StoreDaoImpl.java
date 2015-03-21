package hw7.notes.dao;

import hw7.notes.domain.Store;
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
public class StoreDaoImpl implements  StoreDao {




    private static Logger log = Logger.getLogger(StoreDaoImpl.class);
    private SessionFactory factory = new HibernateUtil().buildSessionFactory();

    public StoreDaoImpl(){

    }

    @Override
    public Long create(Store store) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(store);
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
    public Store read(Long ig) {
        Session session = null;
        Store store = new Store();
        try {
            session = factory.openSession();
            session.beginTransaction();
            store = (Store)session.get(Store.class, ig);
            session.getTransaction().commit();
            return store;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return store;
    }

    @Override
    public boolean update(Store store) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(store);
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
    public boolean delete(Store store) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(store);
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
    public List<Store> findAll() {
        List<Store> list = new ArrayList<>();

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            list = session.createCriteria(Store.class).list();
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
