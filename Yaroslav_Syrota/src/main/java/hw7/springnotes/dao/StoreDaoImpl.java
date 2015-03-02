package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Store;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
public class StoreDaoImpl implements StoreDao {
    @Qualifier("mySessionFactoryHW7")
    @Autowired(required = true)
    private SessionFactory sessionFactory; // фабрика берется из контекста

    public StoreDaoImpl() {
    }

    @Override
    public Long create(Store store) {
        return (Long) sessionFactory.getCurrentSession().save(store);
    }

    @Override
    @Transactional(readOnly = true)
    public Store read(Long id) {
        return (Store) sessionFactory.getCurrentSession().get(Store.class, id);
    }

    @Override
    public void update(Store store) {
        sessionFactory.getCurrentSession().update(store);
    }

    @Override
    public void delete(Store store) {
        sessionFactory.getCurrentSession().delete(store);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Store> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Store.class);
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> getNotebooksGtAmount(int amount) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Store.class)
                .add(Restrictions.gt("amount", amount))
                .setProjection(Projections.property("notebook"));
        return criteria.list();
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Store.class)
                .setProjection(Projections.property("notebook"));
        return criteria.list();
    }
}
