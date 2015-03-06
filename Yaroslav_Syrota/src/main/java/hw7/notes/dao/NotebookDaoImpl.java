package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Chuvychin on 20.02.2015.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public NotebookDaoImpl() {
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(notebook);
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
    public Notebook read(Long ig) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (Notebook)session.get(Notebook.class, ig);

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return false;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Notebook>)session.createCriteria(Notebook.class).list();


        } catch (HibernateException e) {
            log.error("Open session failed", e);

        }
        return null;
    }

//    public List<Notebook> getNotebooksByPortion(int size) {
//        Session session = null;
//        try {
//            session = factory.openSession();
//            session.beginTransaction();
//            return (List<Notebook>)session.createCriteria(Notebook.class).setMaxResults(size).list();
//
//
//        } catch (HibernateException e) {
//            log.error("Open session failed", e);
//
//        }
//        return null;
//    }
}
