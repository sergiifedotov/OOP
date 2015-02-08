package hw6.service;

import hw6.domain.Notebook;

import java.util.List;

/**
 * Created by Chuvychin on 09.02.2015.
 */
public interface NotebookService {

  Long add(Notebook notebook);
  List<Notebook> findAll();
}
