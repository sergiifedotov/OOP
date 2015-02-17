package hw7.notes.dao;

import hw7.notes.domain.Sales;

import java.util.List;

/**
 * Created by vladimir on 17.02.2015.
 */
public interface SalesDao {
    Long create(Sales store);
    Sales read(Long ig);
    boolean update(Sales store);
    boolean delete(Sales store);
    List<Sales> findAll();

}
