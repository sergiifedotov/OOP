package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Vendor;

import java.util.List;

/**
 * Created by sanya on 24.02.2015.
 */
public interface NotebookDao {

    Long create(Notebook notebook);

    Notebook read(Long id);

    boolean update(Notebook notebook);

    boolean delete(Notebook notebook);

    List<Notebook> findAll();

    List<Notebook> getPortion(Integer first, Integer result);

    List<Notebook> getNotebooksGtAmount(int amount);

    List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor);
}
