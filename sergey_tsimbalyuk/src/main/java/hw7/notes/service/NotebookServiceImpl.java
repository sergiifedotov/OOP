package hw7.notes.service;

import hw7.notes.dao.NotebookDaoImpl;
import org.springframework.transaction.annotation.Transactional;

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
    public Long receive(int notebookId, int amount, double price) {

        return null;
    }

    @Override
    public Long sale(int storeId, int amount) {
        return null;
    }
}