package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by sanya on 17.02.2015.
 */
public class VendorDaoImpl implements VendorDao {
    private Logger log = Logger.getLogger(VendorDaoImpl.class);
    SessionFactory factory = null;

    public VendorDaoImpl(){

    }

    public VendorDaoImpl(SessionFactory factory){
        this.factory =factory;
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = null;
        Long id = null;
        try{
            session = factory.openSession();
            session.beginTransaction();
            id = (Long)session.save(vendor);
            session.getTransaction().commit();
        } catch(HibernateException e){
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
    public Vendor read(Long id) {
        Session session = null;
        Vendor vendor = null;
        try {
            session = factory.openSession();
            vendor = (Vendor) session.get(Vendor.class, id);
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return vendor;
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = null;
        boolean rez = false;
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.update(vendor);
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
    public boolean delete(Vendor vendor) {
        Session session = null;
        boolean rez = false;
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.delete(vendor);
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
    public List<Vendor> findAll() {
        Session session = null;
        List<Vendor> list = null;
        try {
            session = factory.openSession();
            list = session.createCriteria(Vendor.class).list();
        }catch (HibernateException e){
            log.error(e);
        }finally{
            if (session != null){
                session.close();
            }
        }
        return list;
    }
}
