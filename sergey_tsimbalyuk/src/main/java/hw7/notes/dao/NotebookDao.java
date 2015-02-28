package hw7.notes.dao;

import hw7.notes.domain.Notebook;

import java.util.List;
/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List<Notebook> findAll();
}
