package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by sanya on 17.02.2015.
 */
public class CPUDaoImpl implements CPUDao {
    private Logger log = Logger.getLogger(CPUDaoImpl.class);
    private SessionFactory factory;

    public CPUDaoImpl(){

    }

    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
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
        } catch (HibernateException e) {
            log.error(e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public CPU read(Long id) throws NullPointerException {
        Session session = null;
        CPU cpu = null;
        try {
            session = factory.openSession();
            cpu = (CPU) session.get(CPU.class, id);
        } catch (HibernateException e) {
            log.error(e);
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
        boolean rez = false;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
            rez = true;
        } catch (HibernateException e) {
            log.error(e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return rez;
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = null;
        boolean rez = false;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
            rez = true;
        } catch (HibernateException e) {
            log.error(e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return rez;
    }

    @Override
    public List<CPU> findAll() {
        Session session = null;
        List<CPU> list = null;
        try {
            session = factory.openSession();
            list = session.createCriteria(CPU.class).list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }
}
