package hw7.springnotes.dao;

import hw7.springnotes.domain.Store;

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
