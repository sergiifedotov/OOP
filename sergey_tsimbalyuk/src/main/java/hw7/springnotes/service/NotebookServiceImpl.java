package hw7.springnotes.service;

import hw7.notes.dao.NotebookDaoImpl;
import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Memory;
import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Sales;
import hw7.springnotes.domain.Store;
import hw7.springnotes.domain.Vendor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
@Transactional
public class NotebookServiceImpl implements NotebookService {
    private NotebookDaoImpl notebookDaoImpl;
    private int notebookId;
    private int amount;
    private double price;

    private CPU cpu;
    private Memory memory;
    private hw7.springnotes.domain.Notebook notebook;
    private Sales sales;
    private Store store;
    private Vendor vendor;

    @Override
    public Long create(hw7.notes.domain.CPU cpu) {
        return null;
    }

    @Override
    public Long receive(int notebookId, int amount, double price) {

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
    public List<hw7.notes.domain.Notebook> getNotebooksByPortion(int size) {
        return notebookDaoImpl.getPortion(0,size);
    }
}