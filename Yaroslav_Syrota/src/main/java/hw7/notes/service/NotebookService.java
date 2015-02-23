package hw7.notes.service;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by @CAT_Caterpiller on 11.02.2015.
 */

public interface NotebookService {
    Long add(Notebook notebook);
    List<Notebook> findAll();
}
