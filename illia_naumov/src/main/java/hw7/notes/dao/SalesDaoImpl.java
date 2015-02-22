package hw7.notes.dao;

import hw7.notes.domain.Sales;
import hw7.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public class SalesDaoImpl implements SalesDao{
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);
    SessionFactory factory;
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
    public Sales read(Long ig) {
        return null;
    }

    @Override
    public boolean update(Sales store) {
        return false;
    }

    @Override
    public boolean delete(Sales store) {
        return false;
    }

    @Override
    public List<Sales> findAll() {
        return null;
    }
}
