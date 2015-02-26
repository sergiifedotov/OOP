package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import hw7.springnotes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Repository
@Transactional
public class VendorDaoImpl implements VendorDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);

    @Autowired
    private SessionFactory factory;


    public static void main(String[] args) {

        VendorDaoImpl vendorDaoImpl = new VendorDaoImpl();

        System.out.println(vendorDaoImpl.findAll().toString());

    }

    public VendorDaoImpl() {

    }

    @Override
    public Long create(Vendor vendor) {
        return (Long) factory.getCurrentSession().save(vendor);
    }

    @Override
    @Transactional(readOnly = true)
    public Vendor read(Long id) {
        return (Vendor) factory.getCurrentSession().get(Vendor.class,id);
    }

    @Override
    public boolean update(Vendor vendor) {
        factory.getCurrentSession().update(vendor);
        return true;
    }

    @Override
    public boolean delete(Vendor vendor) {
        factory.getCurrentSession().delete(vendor);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vendor> findAll() {
        return (List)factory.getCurrentSession().createCriteria(Vendor.class).list();
    }

}