package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        return null;
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
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
    public Map<Notebook, Integer> getSalesByDays() {
        return null;
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
}
