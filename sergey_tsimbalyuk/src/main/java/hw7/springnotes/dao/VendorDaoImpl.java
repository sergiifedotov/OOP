package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
@Repository
@Transactional
public class VendorDaoImpl implements VendorDao {
    @Qualifier("mySessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Vendor vendor) {
        return (Long) sessionFactory.getCurrentSession().save(vendor);
    }

    @Transactional(readOnly = true)
    @Override
    public Vendor read(Long id) {
        return (Vendor) sessionFactory.getCurrentSession().get(Vendor.class, id);
    }

    @Override
    public boolean update(Vendor vendor) {
        sessionFactory.getCurrentSession().update(vendor);
        return true;
    }

    @Override
    public boolean delete(Vendor vendor) {
        sessionFactory.getCurrentSession().delete(vendor);
        return true;
    }

    @Override
    public List<Vendor> findAll() {
        return (List<Vendor>) sessionFactory.getCurrentSession().createCriteria(Vendor.class).list();
    }
}
