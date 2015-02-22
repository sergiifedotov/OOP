package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);
    SessionFactory factory;
    @Override
    public Long create(Notebook notebook) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(notebook);
            session.getTransaction().commit();
            return (Long) notebook.getId();
        }catch (HibernateException e){
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
            try{
                session.beginTransaction();
                Notebook ntb = (Notebook) session.get(Notebook.class, id);
                session.getTransaction().commit();
                return ntb;
            }catch (HibernateException e){
                log.error("Transaction failed", e);
                session.getTransaction().rollback();
            } finally {
                session.close();
            }
            return null;
        }

    @Override
    public boolean update(Notebook notebook) {
        return false;
    }

    @Override
    public boolean delete(Notebook notebook) {
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        return null;
    }
}
