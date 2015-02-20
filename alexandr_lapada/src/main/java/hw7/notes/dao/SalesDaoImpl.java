package hw7.notes.dao;

import hw7.notes.domain.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by sanya on 17.02.2015.
 */
public class SalesDaoImpl implements SalesDao {
    private Logger log = Logger.getLogger(StoreDaoImpl.class);
    private SessionFactory factory;

    public SalesDaoImpl(){

    }

    public SalesDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Sales sales) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(sales);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error(e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Sales read(Long id) {
        Session session = null;
        Sales sales = null;
        try{
            session = factory.openSession();
            sales = (Sales)session.get(Sales.class, id);
        } catch (HibernateException e){
            log.error(e);
        } finally{
            if (session != null){
                session.close();
            }
        }
        return sales;
    }

    @Override
    public boolean update(Sales sales) {
        Session session = null;
        boolean rez = false;
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
            rez = true;
        } catch (HibernateException e){
            log.error(e);
            session.getTransaction().rollback();
        } finally{
            if (session != null){
                session.close();
            }
        }
        return rez;
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = null;
        boolean rez = false;
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
            rez = true;
        } catch (HibernateException e){
            log.error(e);
            session.getTransaction().rollback();
        } finally{
            if (session != null){
                session.close();
            }
        }
        return rez;
    }

    @Override
    public List<Sales> findAll() {
        Session session = null;
        List<Sales> list = null;
        try{
            session = factory.openSession();
            list = session.createCriteria(Sales.class).list();
        } catch (HibernateException e){
            log.error(e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return list;
    }
}
