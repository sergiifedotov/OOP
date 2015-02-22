package hw7.notes.dao;

import hw7.notes.domain.Store;
import hw7.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by user on 20.02.2015.
 */
public class StoreDaoImpl implements  StoreDao {
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);
    SessionFactory factory;
    @Override
    public Long create(Store store) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(store);
            session.getTransaction().commit();
            return (Long) store.getId();
        }catch (HibernateException e){
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Store read(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Store store = (Store) session.get(Store.class, id);
            session.getTransaction().commit();
            return store;
        }catch (HibernateException e){
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Store store) {
        return false;
    }

    @Override
    public boolean delete(Store store) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Store> findAll() {
        return null;
    }
}
