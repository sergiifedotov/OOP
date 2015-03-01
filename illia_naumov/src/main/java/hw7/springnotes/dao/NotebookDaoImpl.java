package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
@Transactional
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);

    public NotebookDaoImpl() {
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(notebook);
            session.getTransaction().commit();
            return (Long) notebook.getId();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Notebook read(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Notebook ntb = (Notebook) session.get(Notebook.class, id);
            session.getTransaction().commit();
            return ntb;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(notebook);
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
    public boolean delete(Notebook notebook) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(notebook);
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
    public List<Notebook> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            return session.createCriteria(Notebook.class).list();
        } catch (HibernateException e) {
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

