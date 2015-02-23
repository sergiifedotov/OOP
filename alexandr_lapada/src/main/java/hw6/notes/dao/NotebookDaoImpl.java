package hw6.notes.dao;


import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Expression;
import java.util.Date;
import java.util.List;

/**
 * Created by sanya on 10.02.2015.
 */
public class NotebookDaoImpl implements NotebookDao{
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(){

    }

    public NotebookDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (long) session.save(ntb);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Notebook notebook = null;
        Session session = null;
        try {
            session = factory.openSession();
            notebook = (Notebook) session.get(Notebook.class, id);
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
    public boolean update(Notebook ntb) {
        Session session = null;
        boolean rez = false;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            rez = true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return rez;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = null;
        boolean rez = false;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            rez = true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return rez;
    }

    @Override
    public List<Notebook> findAll() {
        List<Notebook> list = null;
        Session session = null;
        try{
            session = factory.openSession();
            list = session.createCriteria(Notebook.class).list();
        }catch(HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public List<Notebook> findByModel(String model) {
        List list = null;
        Session session = null;
        try{
            session = factory.openSession();
            list =  session.createCriteria(Notebook.class).add(Restrictions.eq("model",model)).list();
        }catch (HibernateException e){
            log.error("Open session filed",e);
            session.getTransaction().rollback();
        }finally{
            if (session != null){
                session.close();
            }
        }
        return list;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        List list = null;
        Session session = null;
        try{
            session = factory.openSession();
            list =  session.createCriteria(Notebook.class).add(Restrictions.eq("vendor",vendor)).list();
        }catch (HibernateException e){
            log.error("Open session filed",e);
            session.getTransaction().rollback();
        }finally{
            if (session != null){
                session.close();
            }
        }
        return list;
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        List list = null;
        Session session = null;
        try{
            session = factory.openSession();
            list =  session.createCriteria(Notebook.class).add(Restrictions.eq("price",price)).list();
        }catch (HibernateException e){
            log.error("Open session filed",e);
            session.getTransaction().rollback();
        }finally{
            if (session != null){
                session.close();
            }
        }
        return list;
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        List list = null;
        Session session = null;
        try{
            session = factory.openSession();
            list =  session.createCriteria(Notebook.class).add(Restrictions.gt("price",priceFrom)).add(Restrictions.lt("price",priceTo)).add(Restrictions.eq("vendor",vendor)).list();
        }catch (HibernateException e){
            log.error("Open session filed",e);
            session.getTransaction().rollback();
        }finally{
            if (session != null){
                session.close();
            }
        }
        return list;
    }
}
