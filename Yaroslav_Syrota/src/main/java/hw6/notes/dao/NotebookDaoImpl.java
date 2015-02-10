package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
// import java.util.logging.Logger;

/**
 * Created by @CAT_Caterpiller on 10.02.2015.
 */

public class NotebookDaoImpl implements NotebookDao {
    // private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory sessionFactory;

    public NotebookDaoImpl() {}

    public NotebookDaoImpl(SessionFactory sessionFactory) {
        super();
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch(HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Notebook read(Long id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Notebook notebook = (Notebook) session.get(Notebook.class, id);
            return notebook;
        } catch(HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return true;
        } catch(HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        } catch(HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        return sessionFactory.openSession().createCriteria(Notebook.class).list();
    }
}
