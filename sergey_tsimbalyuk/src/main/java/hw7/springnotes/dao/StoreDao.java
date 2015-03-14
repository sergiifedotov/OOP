package hw7.springnotes.dao;

import hw7.springnotes.domain.Store;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
public interface StoreDao {
    Long create(Store store);

    Store read(Long id);
    boolean update(Store store);
    boolean delete(Store store);
    List<Store> findAll();
}
