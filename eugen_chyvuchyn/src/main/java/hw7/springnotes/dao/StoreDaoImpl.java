package hw7.springnotes.dao;

import hw7.springnotes.domain.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chuvychin on 27.02.2015.
 */
@Repository
public class StoreDaoImpl implements StoreDao {

    @Autowired
    private SessionFactory factory;

    public StoreDaoImpl() {
    }

    @Override
    public Long create(Store store) {
        Session session = factory.getCurrentSession();
        Long id = (long)session.save(store);


        return id;
    }

    @Override
    public Store read(Long ig) {
        Session session = factory.getCurrentSession();
        return (Store)session.get(Store.class,ig);
    }

    @Override
    public boolean update(Store store) {
        Session session = factory.getCurrentSession();
        session.update(store);

        return true;
    }

    @Override
    public boolean delete(Store store) {
        Session session = factory.getCurrentSession();
        session.delete(store);

        return true;
    }

    @Override
    public List<Store> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Store.class).list();
    }
}
