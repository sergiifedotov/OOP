package hw7.notes.service;

import hw7.notes.domain.Notebook;

import java.util.List;

/**
 *
 */
public interface NotebookService {
    Long add(Notebook notebook);
    List<Notebook> findAll();
}
