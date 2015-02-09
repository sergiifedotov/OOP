package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsv on 09.02.15.
 */
public class NotebookHibernateDaoImpl implements NotebookDao {
    private static SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookHibernateDaoImpl.class);
    private List<Notebook> notebookList = new ArrayList<Notebook>();
    public NotebookHibernateDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = null;
        try {
            session = (Session) factory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(ntb);
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
    public Notebook read(Long id) {
        Session session = null;
        try {
            session = (Session) factory.openSession();
            return (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            System.out.println("ERROR");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info("Reference to SessionFactory " + factory);
        return null;
    }

    @Override
    public void update(Notebook notebook) {
        Session session=null;
        try {
            session=factory.openSession();
            session.update(notebook);
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public void delete(Notebook notebook) {

        Session session = null;
        try{
            session=factory.openSession();
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }

    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        try {
            return session.createCriteria(Notebook.class)
                    .add(Restrictions.eq("id", 3))
                    .add(Restrictions.like("name", "%e%"))
                    .list();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

}