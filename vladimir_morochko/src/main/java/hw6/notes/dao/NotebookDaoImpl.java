package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.*;

import java.util.List;

/**
 * Created by vladimir on 11.02.2015.
 *
 *  Создать DAO для таблицы ноутбуки
 Таблица ноутбуки имеет следующую структуру
 (id, serial, vendor, model, manufacture date, price)
 domain
 hw6.notes.domain.Notebook
 dao
 hw6.notes.dao.NotebookDao
 Long create(Notebook ntb)
 Notebook read(Long ig)
 boolean update(Notebook ntb)
 boolean delete(Notebook ntb)
 List<Notebook> findAll()
 hw6.notes.dao.NotebookDaoImpl
 */
public class NotebookDaoImpl implements NotebookDao{
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
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
    public Notebook read(Long id) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (Notebook) session.get(Notebook.class, id);
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
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
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
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = null;
        try {
            session = factory.openSession();
            Criteria criteria = session.createCriteria(Notebook.class);
            return criteria.list();
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
}
