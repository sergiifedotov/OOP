package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 *
 */
public class CPUDaoImpl implements CPUDao {
    private static Logger log = Logger.getLogger(CPUDaoImpl.class);


    public static void main(String[] args) {

        CPUDaoImpl cpuDaoImpl = new CPUDaoImpl();

        System.out.println(cpuDaoImpl.findAll().toString());

    }

    public CPUDaoImpl() {

    }

    @Override
    public Long create(CPU cpu) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(cpu);
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
    public CPU read(Long id) {

        Session session = HibernateUtil.getSession();
        try {
            return (CPU) session.get(CPU.class,id);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(cpu);
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
        }
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(cpu);
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
        }
    }

    @Override
    public List<CPU> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return (List) session.createCriteria(CPU.class).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;

    }

}