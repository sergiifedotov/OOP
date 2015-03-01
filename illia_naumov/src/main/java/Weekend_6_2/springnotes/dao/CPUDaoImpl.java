package Weekend_6_2.springnotes.dao;

import Weekend_6_2.springnotes.domain.CPU;
import Weekend_6_2.springnotes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
@Transactional
public class CPUDaoImpl implements CPUDao {
    private static Logger log = Logger.getLogger(CPUDaoImpl.class);

    public CPUDaoImpl() {
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
