package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;

import java.util.List;

/**
 * Created by sanya on 17.02.2015.
 */
public interface SalesDao {

    Long create(Sales sales);

    Sales read(Long id);

    boolean update(Sales sales);

    boolean delete(Sales sales);

    List<Sales> findAll();
}
