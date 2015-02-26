package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Sales;
import hw7.notes.domain.Store;
import hw7.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
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
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
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
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
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
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
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
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
        return null;

    }

    @Override
    public Map<Notebook, Integer> getSalesByDays() {
        Session session = HibernateUtil.getSession();
        try {
            Map<Notebook, Integer> map = new HashMap<>();
            List list = session.createCriteria(Sales.class)
                    .addOrder(Order.asc("date")).list();

            if (list != null) {
                Iterator<Sales> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Sales sales = iterator.next();
                    Integer amount = sales.getAmount();
                    Store store = sales.getStore();
                    Notebook notebook = store.getNotebook();
                    map.put(notebook, amount);
                }
            }
            return map;
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