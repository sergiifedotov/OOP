package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Chuvychin on 20.02.2015.
 */
public class SalesDaoImpl implements SalesDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public SalesDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public SalesDaoImpl() {
    }

    @Override
    public Long create(Sales sales) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(sales);
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
    public Sales read(Long ig) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (Sales)session.get(Sales.class, ig);

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
    }

    @Override
    public boolean update(Sales sales) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return false;
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return false;
    }

    @Override
    public List<Sales> findAll() {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Sales>)session.createCriteria(Sales.class).list();


        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
    }
}
