package main.java.hw6.notes.dao;

import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

/**
 * Created by illia_naumov
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(ntb);
            session.getTransaction().commit();
            return (Long) (ntb.getId());
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public Notebook read(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Notebook ntb = (Notebook) session.get(Notebook.class, id);
            session.getTransaction().commit();
            return ntb;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(ntb);
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
    public boolean delete(Notebook ntb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Notebook note = read(ntb.getId());
            session.delete(note);
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
    public List<Notebook> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Notebook> query = session.createCriteria(Notebook.class).list();
        return query;
    }

    @Override
    public List<Notebook> findByModel(String model) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createCriteria(Notebook.class)
                    .add(Restrictions.eq("model", model))
                    .list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }


    @Override
    public List<Notebook> findByVendor(String vendor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createCriteria(Notebook.class)
                    .add(Restrictions.eq("vendor", vendor))
                    .list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createCriteria(Notebook.class)
                    .add(Restrictions.eq("PRICE", price))
                    .add(Restrictions.eq("MANUFACTURE_DATE", date))
                    .list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, /**Date date,*/ String vendor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createCriteria(Notebook.class)
                    .add(Restrictions.between("price", priceFrom, priceTo))
                    //.add(Restrictions.eq("manufacture_date", date))
                    .add(Restrictions.eq("vendor", vendor))
                    .list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
                session.close();
        }
        return null;
    }
}
