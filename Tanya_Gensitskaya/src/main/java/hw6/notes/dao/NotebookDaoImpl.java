package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Создать DAO для таблицы ноутбуки
 * Таблица ноутбуки имеет следующую структуру
 * (id, serial, vendor, model, manufacture date, price)
 * domain
 * hw6.notes.domain.Notebook
 * dao
 * hw6.notes.dao.NotebookDao
 * Long create(Notebook ntb)
 * Notebook read(Long ig)
 * boolean update(Notebook ntb)
 * boolean delete(Notebook ntb)
 * List<Notebook> findAll()
 * hw6.notes.dao.NotebookDaoImpl
 */
public class NotebookDaoImpl implements NotebookDao {

    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl() {
    }


    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(ntb);
            session.getTransaction().commit();
            return id;
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

    @Override
    public Notebook read(Long ig){
        Session session = null;
        Notebook notebook = new Notebook();
        try {
            session = factory.openSession();
            session.beginTransaction();
            notebook = (Notebook) session.get(Notebook.class, ig);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return notebook;
    }
    @Override
    public boolean update(Notebook ntb){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(ntb);
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
    public boolean delete(Notebook ntb){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(ntb);
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
    public List<Notebook> findAll(){
        List<Notebook> list = new ArrayList<>();

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            list = session.createCriteria(Notebook.class).list();
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
