package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by vladimir on 11.02.2015.
 *
 * service
 hw6.notes.service.NotebookService
 Long add(Notebook notebook)
 List<Notebook> findAll()
 hw6.notes.service.NotebookServiceImpl
 */
public interface NotebookService {
    Long add(Notebook notebook);
    List<Notebook> findAll();
}
