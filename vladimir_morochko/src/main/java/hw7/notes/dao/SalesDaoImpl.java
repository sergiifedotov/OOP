package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Sales;
import hw7.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 17.02.2015.
 */
public class SalesDaoImpl implements SalesDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Logger logger = Logger.getLogger(NotebookDaoImpl.class);

    public SalesDaoImpl() {
    }

    public SalesDaoImpl(SessionFactory sessionFactory) {
        this();
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Sales sales) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(sales);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            logger.error("Open session failed", e);
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
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            return (Sales) session.get(Sales.class, id);
        } catch (HibernateException e) {
            logger.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Sales sales) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<Sales> findAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Sales.class);
            return criteria.list();
        } catch (HibernateException e) {
            logger.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Map<Notebook, Integer> getSalesByDays() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Map<Notebook, Integer> map = new HashMap<>();
            List<Date> list = session.createCriteria(Sales.class)
                    .setProjection(Projections.property("date")).list();
            for (Date date : list) {
                Notebook notebook = (Notebook)
                        session.createCriteria(Sales.class)
                        .add(Restrictions.eq("date", date))
                        .setProjection(Projections.property("store"))
                        .setProjection(Projections.property("notebook"))
                        .uniqueResult();
                Integer amount = (Integer) session.createCriteria(Sales.class)
                        .add(Restrictions.gt("date", date))
                        .setProjection(Projections.sum("amount"))
                        .uniqueResult();
                map.put(notebook, amount);
            }
            return map;
        } catch (HibernateException e) {
            logger.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }
}
