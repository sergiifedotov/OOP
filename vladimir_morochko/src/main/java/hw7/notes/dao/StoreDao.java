package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Store;

import java.util.List;

/**
 * Created by vladimir on 17.02.2015.
 */
public interface StoreDao {
    Long create(Store store);
    Store read(Long ig);
    boolean update(Store store);
    boolean delete(Store store);
    List<Store> findAll();
    List<Notebook> getNotebooksGtAmount(int amount);
    List<Notebook> getNotebooksFromStore();
    List<Notebook> getNotebooksStorePresent();

    void close();
}