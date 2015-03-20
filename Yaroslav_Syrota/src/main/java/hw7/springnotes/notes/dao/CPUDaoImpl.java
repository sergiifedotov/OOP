package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Chuvychin on 20.02.2015.
 */
public class CPUDaoImpl implements CPUDao {

    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public CPUDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public CPUDaoImpl() {
    }

    @Override
    public Long create(CPU cpu) {
        Session session = null;
        try {
            session = factory.openSession();
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
    public CPU read(Long ig) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (CPU)session.get(CPU.class, ig);

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
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

        }
        return false;
    }

    @Override
    public List<CPU> findAll() {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<CPU>)session.createCriteria(CPU.class).list();


        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
    }
}
