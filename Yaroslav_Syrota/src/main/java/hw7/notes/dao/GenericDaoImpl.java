package hw7.notes.dao;

import hw6.notes.dao.*;
import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

import static hw6.notes.util.HibernateUtil.getSession;

//import static session10.dentist.utils.HibernateUtil.getSession;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/18/13
 */



public class GenericDaoImpl<T, PK extends Serializable> implements hw6.notes.dao.GenericDao<T, PK> {

    private Class<T> type;

    public GenericDaoImpl(Class<T> type) {

        this.type = type;
    }



    @Override
    public PK create(T o) {
        return (PK) getSession().save(o);
    }

    public T get(PK id) {
        return (T) getSession().get(type, id);
    }

    public List<T> getAll() {
        Criteria crit = getSession().createCriteria(type);
        return crit.list();
    }

    @Override
    public void update(T o) {
        getSession().update(o);
    }

    @Override
    public void createOrUpdate(T persistentObject) {

    }

    @Override
    public void delete(T persistentObject) {

    }

}