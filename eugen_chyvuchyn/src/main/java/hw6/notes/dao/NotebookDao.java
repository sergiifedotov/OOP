package hw6.notes.dao;


import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by Chuvychin on 09.02.2015.
 */
public interface NotebookDao {

    Long create(Notebook ntb);
    Notebook read(Long ig);
    boolean update(Notebook ntb);
    boolean delete(Notebook ntb);
    List<Notebook> findAll();
}
