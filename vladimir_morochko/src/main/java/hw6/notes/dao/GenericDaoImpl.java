package hw6.notes.dao;

import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

//import static session10.dentist.utils.HibernateUtil.getSession;
import static hw6.notes.util.HibernateUtil.getSession;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/18/13
 */

/*

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

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
        Criteria criteria = getSession().createCriteria(type);
        return criteria.list();
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

*/