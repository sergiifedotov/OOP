package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Sales;

import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 23.02.2015.
 */
public interface SalesDao {
    Long create(Sales sales);
    Sales read(Long id);
    boolean update(Sales sales);
    void delete(Sales sales);
    List<Sales> findAll();

    List<Sales> getSalesByDays();
}
