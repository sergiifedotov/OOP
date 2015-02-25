package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sanya on 24.02.2015.
 */
@Repository
@Transactional
public class VendorDaoImpl implements VendorDao {

    @Autowired
    private SessionFactory factory;

    public VendorDaoImpl(){

    }

    @Override
    public Long create(Vendor vendor) {
        Session session = factory.getCurrentSession();
        Long id = (long)session.save(vendor);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public Vendor read(Long id) {
        Session session = factory.getCurrentSession();
        return (Vendor)session.get(Vendor.class,id);
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = factory.getCurrentSession();
        session.update(vendor);
        return false;
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = factory.getCurrentSession();
        session.delete(vendor);
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vendor> findAll() {
        Session session = factory.getCurrentSession();
        List<Vendor> list = session.createCriteria(Vendor.class).list();
        return list;
    }
}
