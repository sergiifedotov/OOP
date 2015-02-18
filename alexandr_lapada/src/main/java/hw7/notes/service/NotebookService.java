package hw7.notes.service;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Store;

/**
 * Created by sanya on 17.02.2015.
 */
public interface NotebookService {

    Long receive(Notebook notebook, Integer amount, Double price);

    Long sale(Store store, Integer amount);

}
