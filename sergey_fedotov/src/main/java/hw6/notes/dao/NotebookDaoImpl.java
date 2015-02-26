package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

/**
 *Создать DAO для таблицы ноутбуки
 Таблица ноутбуки имеет следующую структуру
 (id, serial, vendor, model, manufacture date, price)
 domain
 hw6.notes.domain.Notebook
 dao
 hw6.notes.dao.NotebookDao
 Long create(Notebook ntb)
 Notebook read(Long ig)
 boolean update(Notebook ntb)
 boolean delete(Notebook ntb)
 List<Notebook> findAll()
 hw6.notes.dao.NotebookDaoImpl
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public static void main(String[] args) {
        /*Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernateNotebooks.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);*/

        NotebookDaoImpl notebookDaoImpl = new NotebookDaoImpl();

        //Notebook notebook = new Notebook("11111111111","Sumsung","R538", new GregorianCalendar(2011, Calendar.JANUARY, 15), 4000.00);

        //notebookDaoImpl.create(notebook);

        System.out.println(notebookDaoImpl.findAll().toString());

        /*if (factory != null) {
            factory.close();
        }*/
    }

    public NotebookDaoImpl() {

    }

    @Override
    public Long create(Notebook notebook) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(notebook);
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
    public Notebook read(Long id) {

        Session session = HibernateUtil.getSession();
        try {
            return (Notebook) session.get(Notebook.class,id);
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
    public boolean update(Notebook notebook) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(notebook);
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
    public boolean delete(Notebook notebook) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(notebook);
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
    public List<Notebook> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return (List) session.createCriteria(Notebook.class).list();
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
    public List<Notebook> findByModel(String model) {
        Session session = HibernateUtil.getSession();
        try {
            return  session.createCriteria(Notebook.class).add(Restrictions.eq("model", model)).list();
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
    public List<Notebook> findByVendor(String vendor) {
        Session session = HibernateUtil.getSession();
        try {
            return  session.createCriteria(Notebook.class).add(Restrictions.eq("vendor",vendor)).list();
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
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = HibernateUtil.getSession();
        try {
            return
                    session.createCriteria(Notebook.class)
                    .add(Restrictions.eq("price", price))
                    .add(Restrictions.eq("date", date)).list();
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
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = HibernateUtil.getSession();
        try {
            return
                    session.createCriteria(Notebook.class)
                            .add(Restrictions.between("price", priceFrom, priceTo))
                            .add(Restrictions.le("date", date))
                            .add(Restrictions.eq("vendor", vendor)).list();
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