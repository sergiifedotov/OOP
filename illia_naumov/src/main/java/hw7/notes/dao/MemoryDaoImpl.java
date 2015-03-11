package hw7.notes.dao;

import hw7.springnotes.domain.Memory;
import hw7.springnotes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public class MemoryDaoImpl implements hw7.springnotes.dao.MemoryDao {
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);

    public MemoryDaoImpl() {
    }

    @Override
    public Long create(Memory memory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(memory);
            session.getTransaction().commit();
            return (Long) memory.getId();
        }catch (HibernateException e){
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Memory read(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Memory memory = (Memory) session.get(Memory.class, id);
            session.getTransaction().commit();
            return memory;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public boolean update(Memory memory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(memory);
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
    public List<Memory> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            return session.createCriteria(Memory.class).list();
        }catch(HibernateException e){
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally{
            if(session != null){
                session.close();
            }
        }
        return null;
    }
}
