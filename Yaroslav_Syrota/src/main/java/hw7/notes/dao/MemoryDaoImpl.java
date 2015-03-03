package hw7.notes.dao;

import hw7.notes.domain.Memory;
import hw7.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vladimir on 17.02.2015.
 */
public class MemoryDaoImpl implements MemoryDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Logger logger = Logger.getLogger(NotebookDaoImpl.class);

    public MemoryDaoImpl() {
    }

    public MemoryDaoImpl(SessionFactory sessionFactory) {
        this();
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Memory memory) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(memory);
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
    public Memory read(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            return (Memory) session.get(Memory.class, id);
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
    public boolean update(Memory memory) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(memory);
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
    public List<Memory> findAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Memory.class);
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
    public void close() {
        sessionFactory.close();
    }
}
