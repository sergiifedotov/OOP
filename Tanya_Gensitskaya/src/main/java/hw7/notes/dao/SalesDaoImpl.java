package hw7.notes.dao;

import hw7.notes.domain.Sales;
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
public class SalesDaoImpl implements SalesDao {

    private static Logger log = Logger.getLogger(SalesDaoImpl.class);
    private SessionFactory factory = new HibernateUtil().buildSessionFactory();

    public SalesDaoImpl(){

    }

    @Override
    public Long create(Sales store) {
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
    public Sales read(Long ig) {
        Session session = null;
        Sales sales = new Sales();
        try {
            session = factory.openSession();
            session.beginTransaction();
            sales = (Sales)session.get(Sales.class, ig);
            session.getTransaction().commit();
            return sales;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return sales;
    }

    @Override
    public boolean update(Sales store) {
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
    public boolean delete(Sales store) {
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
    public List<Sales> findAll() {
        List<Sales> list = new ArrayList<>();

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            list = session.createCriteria(Sales.class).list();
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
