package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Memory;
import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Sales;
import hw7.springnotes.domain.Store;
import hw7.springnotes.domain.Vendor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by vladimir on 23.02.2015.
 */
@Service
public class NotebookServiceImpl implements NotebookService {

    @Qualifier("mySessionFactoryHW7")
    @Autowired(required = true)
    private SessionFactory sessionFactory;

//    @Autowired(required = true)
//    private GenericDao<Notebook, Long> notebookDao;

    @Autowired(required = true)
    private NotebookDao notebookDao;

    @Autowired(required = true)
    private CPUDao cpuDao;

    @Autowired(required = true)
    private MemoryDao memoryDao;

    @Autowired(required = true)
    private SalesDao salesDao;

    @Autowired(required = true)
    private StoreDao storeDao;

    @Autowired(required = true)
    private VendorDao vendorDao;

    public NotebookServiceImpl() {
    }

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        return notebookDao.getNotebooksByPortion(size);
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return storeDao.getNotebooksGtAmount(amount);
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return notebookDao.getNotebooksByCpuVendor(cpuVendor);
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {
        return storeDao.getNotebooksFromStore();
    }

    @Override
    public List<Notebook> getNotebooksStorePresent() {
        int amount = 0;
        return getNotebooksGtAmount(amount);
    }

    @Override
    public Map<Notebook, Integer> getSalesByDays() {
        Map<Notebook, Integer> map = null;
        List list = salesDao.getSalesByDays();
        if (list != null) {
            map = new HashMap<>();
            Iterator<Sales> iterator = list.iterator();
            while (iterator.hasNext()) {
                Sales sales = iterator.next();
                Integer amount = sales.getAmount();
                Store store = sales.getStore();
                Notebook notebook = store.getNotebook();
                map.put(notebook, amount);
            }
        }
        return map;
    }

    @Override
    public void updateCPU(CPU cpu) {
        cpuDao.update(cpu);
    }

    @Override
    public void updateMemory(Memory memory) {
        memoryDao.update(memory);
    }

    @Override
    public void updateVendor(Vendor vendor) {
        vendorDao.update(vendor);
    }

    @Override
    public void updateNotebook(Notebook notebook) {
        notebookDao.update(notebook);
    }

    @Override
    public void removeFromStore(Store store, int amount) {
        store.setAmount(store.getAmount() - (store.getAmount().compareTo(amount) < 0 ? store.getAmount() : amount));
        storeDao.update(store);
    }

    @Override
    public List<Notebook> getNotebooks() {
        return notebookDao.findAll();
    }

    @Override
    public void close() {
        sessionFactory.close();
    }

    @Override
    public Long receive(Long notebookId, int amount, double price) {
        Notebook notebook = notebookDao.read(notebookId);
        Store store = new Store(notebook, amount, price);
        return storeDao.create(store);
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Store store = storeDao.read(storeId);
        this.removeFromStore(store, amount);

        Date date = new Date();
        Sales sales = new Sales(store, date, amount);
        return salesDao.create(sales);
    }

}
