package hw7.springnotes.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/18/13
 */
public interface GenericDao<T, PK extends Serializable> {
    PK create(T persistentObject);
    T read(PK id);
    boolean update(T persistentObject);
    boolean delete(T persistentObject);
    List<T> findAll();
}
