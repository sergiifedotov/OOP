package hw7.notes.service;


import hw7.notes.dao.NotebookDao;
import hw7.notes.dao.SalesDao;
import hw7.notes.dao.StoreDao;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Sales;
import hw7.notes.domain.Store;

import java.util.List;


/**
 *
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDao notebookDao;
    private StoreDao storeDao;
    private SalesDao salesDao;

    public NotebookServiceImpl(NotebookDao dao) {
        notebookDao = dao;
    }

    public NotebookServiceImpl(NotebookDao dao, StoreDao storeDao) {
        notebookDao = dao;
        this.storeDao = storeDao;
    }

    public NotebookServiceImpl(StoreDao storeDao, SalesDao salesDao) {
        this.storeDao = storeDao;
        this.salesDao = salesDao;
    }

    @Override
    public Long receive(long notebookId, int amount, double price) {
        Notebook notebook = notebookDao.read(notebookId);
        Store store = new Store(notebook,amount,price);
        return storeDao.create(store);
    }

    @Override
    public Long sale(long storeId, int amount) {
        Store store = storeDao.read(storeId);
        Sales sales = new Sales(store,java.util.Calendar.getInstance().getTime(),amount);
        return salesDao.create(sales);
    }


    @Override
    public List<Notebook> findAll() {
        return notebookDao.findAll();
    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }
}
