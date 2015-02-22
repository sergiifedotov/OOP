package hw7.notes.service;

import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.dao.SalesDaoImpl;
import hw7.notes.dao.StoreDaoImpl;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Sales;
import hw7.notes.domain.Store;

import java.util.Date;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public class NotebookServiceImpl implements NotebookService {
    NotebookDaoImpl notebookDaoImpl;
    StoreDaoImpl storeDaoImpl;
    SalesDaoImpl salesDaoImpl;

    public NotebookServiceImpl(NotebookDaoImpl notebookDaoImpl, StoreDaoImpl storeDaoImpl) {
        this.notebookDaoImpl = notebookDaoImpl;
        this.storeDaoImpl  = storeDaoImpl;
        this.salesDaoImpl = salesDaoImpl;
    }

    @Override
    public Long receive(long notebookId, int amount, double price) {
        Notebook ntb = notebookDaoImpl.read((Long)notebookId);
        Store newDelivery = new Store(ntb, amount, price);
        storeDaoImpl.create(newDelivery);
        return newDelivery.getId();

    }

    @Override
    public Long sale(long storeId, int amount) {
        Sales sale = new Sales(storeDaoImpl.read(storeId), new Date(), amount);
        salesDaoImpl.create(sale);
        storeDaoImpl.delete(storeDaoImpl.read(storeId));
        return sale.getId();
    }
}
