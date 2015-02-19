package hw6.notes.dao;


import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

/**
 * Created by Chuvychin on 09.02.2015.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(ntb);
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
    public Notebook read(Long ig) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (Notebook)session.get(Notebook.class, ig);

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return  true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return  true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = null;
            try {
                session = factory.openSession();
                session.beginTransaction();
                return (List<Notebook>)session.createCriteria(Notebook.class).list();
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
    public List<Notebook> findByModel(String model) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Notebook>)session.createCriteria(Notebook.class).add(Restrictions.eq("model", model)).list();
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
    public List<Notebook> findByVendor(String vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Notebook>)session.createCriteria(Notebook.class).add(Restrictions.eq("vendor",vendor)).list();
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
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = null;
        try {
            session = factory.openSession();

            session.beginTransaction();

            return (List<Notebook>)session.createCriteria(Notebook.class).add(Restrictions.eq("price", price)).add(Restrictions.eq("MANUFACTURE_DATE",date)).list();
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

    @Override //- Получить ноутбуки по цене в указанном диапазоне, меньше указанной даты выпуска и указанного производителя

    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Notebook>)session.createCriteria(Notebook.class).add(Restrictions.between("price", priceFrom, priceTo)).add(Restrictions.lt("MANUFACTURE_DATE",date)).add(Restrictions.eq("vendor",vendor)).list();
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
}
