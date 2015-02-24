package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;

import java.util.List;

/**
 * Created by vladimir on 23.02.2015.
 */
public interface SalesDao {
    Long create(Sales sales);
    Sales read(Long id);
    void update(Sales sales);
    void delete(Sales sales);
    List<Sales> findAll();
}
