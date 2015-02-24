package hw7.springnotes.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Scope("prototype")
@Repository
@Transactional
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
    @Autowired(required = true)
    SessionFactory sessionFactory;

    public GenericDaoImpl() {
    }

    private Class<T> type;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public PK create(T o) {
        return (PK) sessionFactory.getCurrentSession().save(o);
    }

    @Override
    @Transactional(readOnly = true)
    public T read(PK id) {
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public void update(T o) {
        sessionFactory.getCurrentSession().update(o);
    }

    @Override
    public void delete(T o) {
        sessionFactory.getCurrentSession().delete(o);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(type);
        return criteria.list();
    }
}