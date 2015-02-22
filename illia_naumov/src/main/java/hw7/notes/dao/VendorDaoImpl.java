package hw7.notes.dao;

import hw6.notes.util.HibernateUtil;
import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public class VendorDaoImpl implements VendorDao {
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);
    SessionFactory factory;
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
    public Vendor read(Long ig) {
        return null;
    }

    @Override
    public boolean update(Vendor vendor) {
        return false;
    }

    @Override
    public boolean delete(Vendor vendor) {
        return false;
    }

    @Override
    public List<Vendor> findAll() {
        return null;
    }
}
