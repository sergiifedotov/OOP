package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by sanya on 17.02.2015.
 */
public class MemoryDaoImpl implements MemoryDao {
    private SessionFactory factory;
    private Logger log = Logger.getLogger(MemoryDaoImpl.class);

    public MemoryDaoImpl(){

    }

    public MemoryDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory) {
        Long id = null;
        Session session = null;
        try{
            session = factory.openSession();
            session.beginTransaction();
            id = (Long)session.save(memory);
            session.getTransaction().commit();
        } catch(HibernateException e ){
            log.error(e);
            session.getTransaction().rollback();
        }finally{
            if (session != null){
                session.close();
            }
        }
        return id;
    }

    @Override
    public Memory read(Long id) {
        Session session = null;
        Memory memory = null;
        try{
            session = factory.openSession();
            memory =(Memory)session.get(Memory.class,id);
        } catch(HibernateException e){
            log.error(e);
        }finally {
            if(session != null){
                session.close();
            }
        }
        return memory;
    }

    @Override
    public boolean update(Memory memory) {
        Session session = null;
        boolean rez = false;
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.update(memory);
            session.getTransaction().commit();
            rez = true;
        } catch(HibernateException e) {
            log.error(e);
            session.getTransaction().rollback();
        } finally{
            if (session != null){
                session.close();
            }
        }
        return rez;
    }

    @Override
    public boolean delete(Memory memory) {
        Session session = null;
        boolean rez = false;
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.delete(memory);
            session.getTransaction().commit();
            rez = true;
        } catch(HibernateException e) {
            log.error(e);
            session.getTransaction().rollback();
        } finally{
            if (session != null){
                session.close();
            }
        }
        return rez;
    }

    @Override
    public List<Memory> findAll() {
        Session session = null;
        List<Memory> list = null;
        try{
            session = factory.openSession();
            list = session.createCriteria(Memory.class).list();
        } catch (HibernateException e){
            log.error(e);
        }finally {
            if (session != null){
                session.close();
            }
        }
        return list;
    }
}
