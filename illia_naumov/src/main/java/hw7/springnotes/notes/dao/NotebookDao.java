package hw7.springnotes.notes.dao;

import hw7.springnotes.notes.domain.Notebook;

import java.util.List;

/**
 * Created by user on 20.02.2015.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List<Notebook> findAll();
}
