package hw7.springnotes.notes.dao;

import hw7.springnotes.notes.domain.Sales;
import hw7.springnotes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public class SalesDaoImpl implements SalesDao{
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);

    public SalesDaoImpl() {
    }

    @Override
    public Long create(Sales store) {
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
    public Sales read(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Sales memory = (Sales) session.get(Sales.class, id);
            session.getTransaction().commit();
            return memory;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public boolean update(Sales store) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Sales> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            return session.createCriteria(Sales.class).list();
        }catch(HibernateException e){
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally{
            if(session != null){
                session.close();
            }
        }
        return null;
    }
}
