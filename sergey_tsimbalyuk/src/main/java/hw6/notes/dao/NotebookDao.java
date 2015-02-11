package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by tsv on 09.02.15.
 */
public interface NotebookDao {
    Long create(Notebook notebook);

    Notebook read(Long id);

    void update(Notebook notebook);

    void delete(Notebook notebook);

    List<Notebook> findAll();
}