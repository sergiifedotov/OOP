package hw7.notes.service;

import hw7.notes.domain.Notebook;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
public interface NotebookService {
    Long receive(Long notebookId, int amount, double price);
    Long sale(int storeId, int amount);

    List<Notebook> getNotebooksFromStore();
    List<Notebook> getNotebooksStorePresent();
    List<Notebook> getSalesByDays();
    List<Notebook> getNotebooksByPortion(int size);
}