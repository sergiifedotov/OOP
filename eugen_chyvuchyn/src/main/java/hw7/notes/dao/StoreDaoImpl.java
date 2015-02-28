package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Chuvychin on 20.02.2015.
 */
public class StoreDaoImpl implements StoreDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public StoreDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public StoreDaoImpl() {
    }

    @Override
    public Long create(Store store) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(store);
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
    public Store read(Long ig) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (Store)session.get(Store.class, ig);

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
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

        }
        return false;
    }

    @Override
    public List<Store> findAll() {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Store>)session.createCriteria(Store.class).list();


        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
    }


}
