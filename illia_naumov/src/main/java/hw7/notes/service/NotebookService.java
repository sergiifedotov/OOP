package hw7.notes.service;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public interface NotebookService {
    Long receive(long notebookId, int amount, double price);
    Long sale(long storeId, int amount);
}
