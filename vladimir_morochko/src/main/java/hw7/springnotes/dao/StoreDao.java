package hw7.springnotes.dao;

import hw7.springnotes.domain.Store;

import java.util.List;

/**
 * Created by vladimir on 23.02.2015.
 */
public interface StoreDao {
    Long create(Store store);
    Store read(Long ig);
    boolean update(Store store);
    boolean delete(Store store);
    List<Store> findAll();
}
