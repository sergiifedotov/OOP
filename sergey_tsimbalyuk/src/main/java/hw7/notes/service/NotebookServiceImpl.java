package hw7.notes.service;

import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.domain.Notebook;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
@Transactional
public class NotebookServiceImpl implements NotebookService{
    private NotebookDaoImpl notebookDaoImpl;
    private int notebookId;
    private int amount;
    private double price;

    @Override
    public Long receive(Long notebookId, int amount, double price) {

        return null;
    }

    @Override
    public Long sale(int storeId, int amount) {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksStorePresent() {
        return null;
    }

    @Override
    public List<Notebook> getSalesByDays() {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        return notebookDaoImpl.getPortion(0,size);
    }
}