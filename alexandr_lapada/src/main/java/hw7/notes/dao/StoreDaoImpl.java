package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by sanya on 17.02.2015.
 */
public class StoreDaoImpl implements StoreDao {

    private Logger log = Logger.getLogger(StoreDaoImpl.class);
    private SessionFactory factory;

    public StoreDaoImpl(){

    }

    public StoreDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Store store) {
        Session session = null;
        Long id = null;
        try{
            session = factory.openSession();
            session.beginTransaction();
            id = (long)session.save(store);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error(e);
            session.getTransaction().rollback();
        } finally{
            if (session != null){
                session.close();
            }
        }
        return id;
    }

    @Override
    public Store read(Long id) {
        Session session = null;
        Store store = null;
        try{
            session = factory.openSession();
            store = (Store)session.get(Store.class,id);
        } catch (HibernateException e){
            log.error(e);
        } finally{
            if (session != null){
                session.close();
            }
        }
        return store;
    }

    @Override
    public boolean update(Store store) {
        Session session = null;
        boolean rez = false;
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
            rez = true;
        } catch (HibernateException e){
            log.error(e);
            session.getTransaction().rollback();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return rez;
    }

    @Override
    public boolean delete(Store store) {
        Session session = null;
        boolean rez = false;
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
            rez = true;
        } catch (HibernateException e){
            log.error(e);
            session.getTransaction().rollback();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return rez;
    }

    @Override
    public List<Store> findAll() {
        Session session = null;
        List<Store> list = null;
        try{
            session = factory.openSession();
            list = session.createCriteria(Store.class).list();
        } catch(HibernateException e){
            log.error(e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return list;
    }
}
