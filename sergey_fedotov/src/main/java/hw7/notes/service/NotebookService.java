package hw7.notes.service;

import hw7.notes.domain.Notebook;
import java.util.List;

/**
 *
 */
public interface NotebookService {
    Long receive(long notebookId, int amount, double price);
    Long sale(long storeId, int amount);

    Long add(Notebook notebook);
    List<Notebook> findAll();
}
