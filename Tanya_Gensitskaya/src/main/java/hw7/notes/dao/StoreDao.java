package hw7.notes.dao;

import hw7.notes.domain.Store;

import java.util.List;

/**
 * Created by Tanya on 19.02.2015.
 */
public interface StoreDao {
    public Long create(Store store);
    public Store read(Long ig);
    public boolean update(Store store);
    public boolean delete(Store store);
    public List<Store> findAll();
}
