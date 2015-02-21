package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by vladimir on 17.02.2015.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List<Notebook> findAll();

    List<Notebook> getNotebooksByPortion(int size);
    List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor);

    public void close();

}
