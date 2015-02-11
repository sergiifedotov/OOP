package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by illia_naumov
 */
public class NotebookDaoImpl implements NotebookDao{
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(ntb);
            session.getTransaction().commit();
            return (Long) (ntb.getId());
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
            }
        return null;
        }


    @Override
    public Notebook read(Long ig) {
        return null;
    }

    @Override
    public boolean update(Notebook ntb) {
        return false;
    }

    @Override
    public boolean delete(Notebook ntb) {
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = hw6.notes.util.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Notebooks");
        return query.list();
    }
}
