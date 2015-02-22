package hw7.notes.dao;

import hw7.notes.Notebook;

import java.util.List;
import java.util.Map;

/**
 * Created by sanya on 17.02.2015.
 */
public interface NotebookDao {
    Long create(Notebook notebook);

    Notebook read(Long id);

    boolean update(Notebook notebook);

    boolean delete(Notebook notebook);

    List<Notebook> findAll();

    List<Notebook> getPortion(Integer first, Integer result);

    List<Notebook> getNotebooksGtAmount(int amount);

    List<Notebook> getNotebooksByCpuVendor(String cpuVendor);

    List<Notebook> getNotebooksStorePresent();

    Map<Notebook, Integer> getSalesByDays();
}
