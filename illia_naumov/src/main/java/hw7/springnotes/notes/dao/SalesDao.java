package hw7.springnotes.notes.dao;

import hw7.springnotes.notes.domain.Sales;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public interface SalesDao {
    Long create(Sales store);
    Sales read(Long ig);
    boolean update(Sales store);
    boolean delete(Sales store);
    List<Sales> findAll();
}
