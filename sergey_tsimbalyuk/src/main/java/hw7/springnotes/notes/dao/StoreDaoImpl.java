package hw7.springnotes.dao;


import hw7.springnotes.domain.Store;
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
public class StoreDaoImpl implements StoreDao{
    @Qualifier("mySessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Store store) {
        return (Long) sessionFactory.getCurrentSession().save(store);
    }

    @Transactional(readOnly = true)
    @Override
    public Store read(Long id) {
        return (Store) sessionFactory.getCurrentSession().get(Store.class, id);
    }

    @Override
    public boolean update(Store store) {
        sessionFactory.getCurrentSession().update(store);
        return true;
    }

    @Override
    public boolean delete(Store store) {
        sessionFactory.getCurrentSession().delete(store);
        return true;
    }

    @Override
    public List<Store> findAll() {
        return (List<Store>) sessionFactory.getCurrentSession().createCriteria(Store.class).list();
    }
}
