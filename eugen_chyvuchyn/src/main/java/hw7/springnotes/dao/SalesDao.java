package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;

import java.util.List;

/**
 * Created by Chuvychin on 27.02.2015.
 */
public interface SalesDao {
    Long create(Sales store);
    Sales read(Long ig);
    boolean update(Sales store);
    boolean delete(Sales store);
    List<Sales> findAll();
}
