package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Sales;

import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 17.02.2015.
 */
public interface SalesDao {
    Long create(Sales sales);
    Sales read(Long ig);
    boolean update(Sales sales);
    boolean delete(Sales sales);
    List<Sales> findAll();
    Map<Notebook,Integer> getSalesByDays();

    void close();
}
