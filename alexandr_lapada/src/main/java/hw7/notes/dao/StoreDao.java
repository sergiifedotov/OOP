package hw7.notes.dao;

import hw7.notes.Store;

import java.util.List;

/**
 * Created by sanya on 17.02.2015.
 */
public interface StoreDao {

    Long create(Store store);

    Store read(Long id);

    boolean update(Store store);

    boolean delete(Store store);

    List<Store> findAll();
}
