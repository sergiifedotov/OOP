package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chuvychin on 27.02.2015.
 */

@Repository
public class VendorDaoImpl implements VendorDao{

    @Autowired
    private SessionFactory factory;

    public VendorDaoImpl() {
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = factory.getCurrentSession();
        Long id = (long)session.save(vendor);
        return id;
    }

    @Override
    public Vendor read(Long ig) {
        Session session = factory.getCurrentSession();

        return (Vendor)session.get(Vendor.class,ig);
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = factory.getCurrentSession();
        session.update(vendor);
        return true;
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = factory.getCurrentSession();
        session.delete(vendor);
        return true;
    }

    @Override
    public List<Vendor> findAll() {
        Session session = factory.getCurrentSession();

        return session.createCriteria(Vendor.class).list();
    }
}
