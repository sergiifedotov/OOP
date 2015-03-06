package Weekend_6_2.springnotes.service;

import Weekend_6_2.springnotes.dao.*;
import Weekend_6_2.springnotes.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by illia_naumov on 20.02.2015.
 */
@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    private NotebookDao notebookDao;
    @Autowired
    private StoreDao storeDao;
    @Autowired
    private SalesDao salesDao;
    @Autowired
    private CPUDao cpuDao;
    @Autowired
    private MemoryDao memoryDao;
    @Autowired
    private VendorDao vendorDao;
    private int pointer = 0;


    public NotebookServiceImpl() {
        /**notebookDao = new NotebookDaoImpl();
        storeDao = new StoreDaoImpl();
        salesDao = new SalesDaoImpl();
        cpuDao = new CPUDaoImpl();
        memoryDao = new MemoryDaoImpl();
        vendorDao = new VendorDaoImpl();
         */ //comment because of autowired
    }

    @Override
    public Long receive(long notebookId, int amount, double price) {
        Notebook ntb = notebookDao.read((Long) notebookId);
        Store newDelivery = new Store(ntb, amount, price);
        storeDao.create(newDelivery);
        return newDelivery.getId();

    }

    @Override
    public Long sale(long storeId, int amount) {
        Sales sale = new Sales(storeDao.read(storeId), new Date(), amount);
        salesDao.create(sale);
        storeDao.delete(storeDao.read(storeId));
        return sale.getId();
    }

    public void add(CPU cpu){
        cpuDao.create(cpu);
    }
    public void add(Memory memory){
        memoryDao.create(memory);
    }
    public Long add(Notebook notebook){
        notebookDao.create(notebook);
        return notebook.getId();
    }
    public void add(Sales sales){
        salesDao.create(sales);
    }
    public void add(Store store){
        storeDao.create(store);
    }
    public void add(Vendor vendor){
        vendorDao.create(vendor);
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
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
        int balance = store.getQuantity() - amount;
        if(balance > 0){
            store.setQuantity(balance);
        } else {
            store.setQuantity(0);
        }
        return storeDao.update(store);
    }

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        List <Notebook> notesList = notebookDao.findAll();
        List <Notebook> newList = new ArrayList<Notebook>();
        int howManyLeftToShow = notesList.size() - pointer;
        if(howManyLeftToShow - size > -1){
            for(int i = 0; i < size; i++){
                for(int j = pointer; j < pointer + size; j++){
                    newList.add(notesList.get(j));
                }
            }
            pointer = pointer + size;
        } else {
            for(int i = pointer; i < notesList.size(); i++){
                newList.add(notesList.get(i));
            }
            pointer = 0;
        }
        return newList;
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

}
