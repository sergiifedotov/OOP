package hw7.notes.service;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
public interface NotebookService {
    Long receive(int notebookId, int amount, double price);
    Long sale(int storeId, int amount);
}