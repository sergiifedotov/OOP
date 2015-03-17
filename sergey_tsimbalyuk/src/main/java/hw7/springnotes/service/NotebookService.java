package hw7.springnotes.service;

import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Notebook;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
public interface NotebookService {
    Long create(CPU cpu);
    Long receive(int notebookId, int amount, double price);
    Long sale(int storeId, int amount);

    List<hw7.springnotes.domain.Notebook> getNotebooksFromStore();
    List<hw7.springnotes.domain.Notebook> getNotebooksStorePresent();
    List<hw7.springnotes.domain.Notebook> getSalesByDays();
    List<Notebook> getNotebooksByPortion(int size);
}