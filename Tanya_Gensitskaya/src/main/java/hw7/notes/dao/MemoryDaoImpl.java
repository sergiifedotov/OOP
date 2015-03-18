package hw7.notes.dao;

import hw7.notes.domain.Memory;
import hw7.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 19.02.2015.
 */
public class MemoryDaoImpl implements MemoryDao {

    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);
    private SessionFactory factory = new HibernateUtil().buildSessionFactory();

    public MemoryDaoImpl() {
    }


    @Override
    public Long create(Memory memory) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(memory);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Memory read(Long ig) {
        Session session = null;
        Memory memory = new Memory();
        try {
            session = factory.openSession();
            session.beginTransaction();
            memory = (Memory)session.get(Memory.class, ig);
            session.getTransaction().commit();
            return memory;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return memory;
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
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
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
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<Memory> findAll() {
        List<Memory> list = new ArrayList<>();

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            list = session.createCriteria(Memory.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }
}
