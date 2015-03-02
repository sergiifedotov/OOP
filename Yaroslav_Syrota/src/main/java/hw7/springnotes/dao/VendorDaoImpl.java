package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 23.02.2015.
 */
@Repository
@Transactional
public class VendorDaoImpl implements VendorDao {
    @Qualifier("mySessionFactoryHW7")
    @Autowired(required = true)
    private SessionFactory sessionFactory; // фабрика берется из контекста

    public VendorDaoImpl() {
    }

    @Override
    public Long create(Vendor vendor) {
        return (Long) sessionFactory.getCurrentSession().save(vendor);
    }

    @Override
    @Transactional(readOnly = true)
    public Vendor read(Long id) {
        return (Vendor) sessionFactory.getCurrentSession().get(Vendor.class, id);
    }

    @Override
    public void update(Vendor vendor) {
        sessionFactory.getCurrentSession().update(vendor);
    }

    @Override
    public void delete(Vendor vendor) {
        sessionFactory.getCurrentSession().delete(vendor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vendor> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Vendor.class);
        return criteria.list();
    }
}
