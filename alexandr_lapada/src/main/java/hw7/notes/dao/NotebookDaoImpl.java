package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Map;

/**
 * Created by sanya on 17.02.2015.
 */
public class NotebookDaoImpl implements NotebookDao {

    private Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(){

    }

    public NotebookDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = null;
        Long id = null;
        try{
            session = factory.openSession();
            session.beginTransaction();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error(e);
            session.getTransaction().rollback();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Notebook notebook = null;
        Session session = null;
        try{
            session = factory.openSession();
            notebook = (Notebook)session.get(Notebook.class,id);
        } catch(HibernateException e){
            log.error(e);
        } finally{
            if (session != null){
                session.close();
            }
        }
        return notebook;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = null;
        boolean rez = false;
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            rez = true;
        } catch (HibernateException e){
            log.error(e);
            session.getTransaction().rollback();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return rez;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = null;
        boolean rez = false;
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            rez = true;
        } catch (HibernateException e){
            log.error(e);
            session.getTransaction().rollback();
        } finally {
            if (session != null){
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
        } catch(HibernateException e){
            log.error(e);
        }finally {
            if (session != null){
                session.close();
            }
        }

        return list;
    }

    @Override
    public List<Notebook> getPortion(Integer firstResult, Integer maxResult) {
        Session session = null;
        List<Notebook> list = null;
        try{
            session = factory.openSession();
            list = session.createCriteria(Notebook.class).setFirstResult(firstResult).setMaxResults(maxResult).list();
        } catch (HibernateException e){
            log.error(e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return list;
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        Session session = null;
        List<Notebook> list = null;
        try{
            session = factory.openSession();
            list = session.createCriteria(Notebook.class).createCriteria("stores").add(Restrictions.gt("quantity",amount)).list();
        } catch (HibernateException e){
            log.error(e);
        } finally {
            if(session != null){
                session.close();
            }
        }
        return list;
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(String cpuVendor) {
        Session session = null;
        List<Notebook> list = null;
        try{
            session = factory.openSession();
            list = session.createCriteria(Notebook.class).createCriteria("cpu").add(Restrictions.eq("vendor", cpuVendor)).list();
        } catch (HibernateException e){
            log.error(e);
        } finally {
            if(session != null){
                session.close();
            }
        }
        return list;
    }

    @Override
    public List<Notebook> getNotebooksStorePresent() {
        Session session = null;
        List<Notebook> list = null;
        try{
            session = factory.openSession();
            list = session.createCriteria(Notebook.class).createCriteria("stores").list();
            //setProjection(Projections.property("vendor"))
        } catch (HibernateException e){
            log.error(e);
        } finally {
            if(session != null){
                session.close();
            }
        }
        return list;
    }

    @Override
    public Map<Notebook, Integer> getSalesByDays() {
        //createCriteria("sales").setProjection(Projections.property("salesDate"))
        return null;
    }


}
