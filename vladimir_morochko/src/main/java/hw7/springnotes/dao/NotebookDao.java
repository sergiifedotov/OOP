package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Vendor;

import java.util.List;

/**
 * Created by vladimir on 23.02.2015.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    void delete(Notebook notebook);
    List<Notebook> findAll();

    List<Notebook> getNotebooksByPortion(int size);
    List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor);
}
