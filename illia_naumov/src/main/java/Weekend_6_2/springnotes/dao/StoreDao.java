package Weekend_6_2.springnotes.dao;

import Weekend_6_2.springnotes.domain.Store;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public interface StoreDao {
    Long create(Store store);
    Store read(Long ig);
    boolean update(Store store);
    boolean delete(Store store);
    List<Store> findAll();
}
