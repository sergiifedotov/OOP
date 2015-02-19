package hw7.notes.dao;

import hw7.notes.domain.Sales;
import hw7.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 *
 */
public class SalesDaoImpl implements SalesDao {
    private static Logger log = Logger.getLogger(SalesDaoImpl.class);


    public static void main(String[] args) {

        SalesDaoImpl salesDaoImpl = new SalesDaoImpl();

        System.out.println(salesDaoImpl.findAll().toString());

    }

    public SalesDaoImpl() {

    }

    @Override
    public Long create(Sales sales) {
        Session session = HibernateUtil.getSession();
        try {
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
    public Sales read(Long id) {

        Session session = HibernateUtil.getSession();
        try {
            return (Sales) session.get(Sales.class,id);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Sales sales) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(sales);
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
        }
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(sales);
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
        }
    }

    @Override
    public List<Sales> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return (List) session.createCriteria(Sales.class).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;

    }

}