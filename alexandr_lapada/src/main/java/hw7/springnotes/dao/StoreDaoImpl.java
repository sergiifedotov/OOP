package hw7.springnotes.dao;

import hw7.springnotes.domain.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by sanya on 24.02.2015.
 */
@Repository
@Transactional
public class StoreDaoImpl implements StoreDao{

    @Autowired
    private SessionFactory factory;

    public StoreDaoImpl(){

    }

    @Override
    public Long create(Store store) {
        Session session = factory.getCurrentSession();
        Long id = (long)session.save(store);
        return id;
    }

    @Override
    @Transactional
    public Store read(Long id) {
        Session session = factory.getCurrentSession();
        return (Store)session.get(Store.class,id);
    }

    @Override
    public boolean update(Store store) {
        Session session = factory.getCurrentSession();
        session.update(store);
        return false;
    }

    @Override
    public boolean delete(Store store) {
        Session session = factory.getCurrentSession();
        session.delete(store);
        return false;
    }

    @Override
    public List<Store> findAll() {
        Session session = factory.getCurrentSession();
        List<Store> list = session.createCriteria(Store.class).list();
        return list;
    }

    public List<Store> findAllBySalesDay(Date date){
        Session session = factory.getCurrentSession();
        List<Store> list = session.createCriteria(Store.class).createCriteria("sales").add(Restrictions.eq("salesDate",date)).list();
        return list;
    }
}
