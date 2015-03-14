package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import hw7.springnotes.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 *
 */
public class MemoryDaoImpl implements MemoryDao {
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);


    public static void main(String[] args) {

        MemoryDaoImpl memoryDaoImpl = new MemoryDaoImpl();

        System.out.println(memoryDaoImpl.findAll().toString());

    }

    public MemoryDaoImpl() {

    }

    @Override
    public Long create(Memory memory) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(memory);
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
    public Memory read(Long id) {

        Session session = HibernateUtil.getSession();
        try {
            return (Memory) session.get(Memory.class,id);
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
    public boolean update(Memory memory) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(memory);
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
    public List<Memory> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return (List) session.createCriteria(Memory.class).list();
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