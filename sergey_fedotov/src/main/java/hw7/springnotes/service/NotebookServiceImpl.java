package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import java.util.List;
import java.util.Map;


/**
 *
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDao notebookDao;
    private StoreDao storeDao;
    private SalesDao salesDao;
    private CPUDao cpuDao;
    private MemoryDao memoryDao;
    private VendorDao vendorDao;

    public NotebookServiceImpl(NotebookDao dao) {
        notebookDao = dao;
    }

    public NotebookServiceImpl(NotebookDao notebookDao, StoreDao storeDao, SalesDao salesDao, CPUDao cpuDao, MemoryDao memoryDao, VendorDao vendorDao) {
        this.notebookDao = notebookDao;
        this.storeDao = storeDao;
        this.salesDao = salesDao;
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.vendorDao = vendorDao;
    }

    public NotebookServiceImpl(NotebookDao dao, StoreDao storeDao) {
        notebookDao = dao;
        this.storeDao = storeDao;
    }

    public NotebookServiceImpl(StoreDao storeDao, SalesDao salesDao) {
        this.storeDao = storeDao;
        this.salesDao = salesDao;
    }

    public NotebookServiceImpl() {
    }

    @Override
    public Long receive(Long notebookId, int amount, double price) {
        Notebook notebook = notebookDao.read(notebookId);
        Store store = new Store(notebook,amount,price);
        return storeDao.create(store);
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Store store = storeDao.read(storeId);
        Sales sales = new Sales(store,java.util.Calendar.getInstance().getTime(),amount);
        return salesDao.create(sales);
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return  memoryDao.update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        Integer actualAmount = store.getAmount();

        if (actualAmount >= amount){
            store.setAmount(actualAmount - amount);
            return storeDao.update(store);
        }else{
            System.err.println(" insufficient balance, the actual balance: " + actualAmount);
            return false;
        }

    }

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        return notebookDao.getNotebooksByPortion(size);
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return notebookDao.getNotebooksGtAmount(amount);
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return notebookDao.getNotebooksByCpuVendor(cpuVendor);
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {
        return notebookDao.getNotebooksFromStore();
    }

    @Override
    public List<Notebook> getNotebooksStorePresent() {
        return notebookDao.getNotebooksStorePresent();
    }

    @Override
    public Map<Notebook, Integer> getSalesByDays() {
        return salesDao.getSalesByDays();
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
