package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Chuvychin on 20.02.2015.
 */
public class MemoryDaoImpl implements MemoryDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public MemoryDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public MemoryDaoImpl() {
    }

    @Override
    public Long create(Memory memory) {
        Session session = null;
        try {
            session = factory.openSession();
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
        }
        return null;
    }

    @Override
    public Memory read(Long ig) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (Memory)session.get(Memory.class, ig);

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
    }

    @Override
    public boolean update(Memory memory) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(memory);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return false;
    }

    @Override
    public boolean delete(Memory memory) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(memory);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return false;
    }

    @Override
    public List<Memory> findAll() {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Memory>)session.createCriteria(Memory.class).list();


        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
    }
}
