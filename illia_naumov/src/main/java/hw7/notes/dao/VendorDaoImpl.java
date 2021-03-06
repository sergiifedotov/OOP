package hw7.notes.dao;

import hw7.springnotes.dao.MemoryDaoImpl;
import hw7.springnotes.domain.Vendor;
import hw7.springnotes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public class VendorDaoImpl implements hw7.springnotes.dao.VendorDao {
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);

    public VendorDaoImpl() {
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(vendor);
            session.getTransaction().commit();
            return vendor.getId();
        }catch(HibernateException e){
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public Vendor read(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Vendor vendor = (Vendor) session.get(Vendor.class, id);
            session.getTransaction().commit();
            return vendor;
        }catch(HibernateException e){
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Vendor> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            return session.createCriteria(Vendor.class).list();
        }catch(HibernateException e){
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally{
            if(session != null){
                session.close();
            }
        }
        return null;
    }
}
