package hw7.notes.dao;

import hw7.notes.domain.CPU;
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
public class CPUDaoImpl implements  CPUDao {
    private static Logger log = Logger.getLogger(CPUDaoImpl.class);
    private SessionFactory factory = new HibernateUtil().buildSessionFactory();

    public CPUDaoImpl() {
    }


    @Override
    public Long create(CPU cpu) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(cpu);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Open session failed tt", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public CPU read(Long ig) {
        Session session = null;
        CPU cpu = new CPU();
        try {
            session = factory.openSession();
            session.beginTransaction();
            cpu = (CPU)session.get(CPU.class, ig);
            session.getTransaction().commit();
            return cpu;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cpu;
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(cpu);
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
    public boolean delete(CPU cpu) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(cpu);
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
    public List<CPU> findAll() {
        List<CPU> list = new ArrayList<>();

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            list = session.createCriteria(CPU.class).list();
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
