package session10.dentist.dao;

import javafx.scene.canvas.GraphicsContext;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/18/13
 */
public class GenericDaoImpl {

}
/*
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    private Class<T> type;
    private Session session;

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

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}*/
