package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public class CPUDaoImpl implements CPUDao{
    private static Logger log = Logger.getLogger(CPUDaoImpl.class);
    SessionFactory factory;
    public CPUDaoImpl(SessionFactory factory){
        this.factory = factory;
    }
    @Override
    public Long create(CPU cpu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(cpu);
            session.getTransaction().commit();
            return (Long) cpu.getId();
        }catch (HibernateException e){
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public CPU read(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            CPU cpu = (CPU) session.get(CPU.class, id);
            session.getTransaction().commit();
            return cpu;
        }catch (HibernateException e){
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<CPU> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createCriteria(CPU.class).list();
        } catch (HibernateException e){
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
