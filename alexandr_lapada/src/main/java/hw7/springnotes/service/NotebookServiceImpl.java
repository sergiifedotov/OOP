package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sanya on 24.02.2015.
 */
@Component
public class NotebookServiceImpl implements NotebookService {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");

    @Autowired
    private CPUDao cpuDao;
    @Autowired
    private MemoryDao memoryDao;
    @Autowired
    private NotebookDao notebookDao;
    @Autowired
    private SalesDao salesDao;
    @Autowired
    private StoreDao storeDao;
    @Autowired
    private VendorDao vendorDao;

    public NotebookServiceImpl(){

    }

    @Override
    public Long receive(Long id, int amount, double price) {
        Notebook notebook = notebookDao.read(id);
        Store store = new Store(notebook, amount, price);
        notebook.setStore(store);
        notebookDao.update(notebook);
        return storeDao.create(store);
    }

    @Override
    public Long sale(Long id, int amount) {
        Long idSale = null;
        Store store = storeDao.read(id);
        Integer quantity = store.getQuantity();
        if (quantity >= amount){
            quantity = quantity - amount;
            store.setQuantity(quantity);
            storeDao.update(store);
            Date date = new Date();
            SimpleDateFormat dateFormate = new SimpleDateFormat("dd.MM.YYYY");
            dateFormate.format(date);
            Sales sales = new Sales(store,date,amount);
            idSale = salesDao.create(sales);
        }else{
            System.err.println(" this quantity not available");
        }
        return idSale;
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        Integer quantity = store.getQuantity();
        boolean rez = false;
        if (quantity >= amount){
            quantity = quantity - amount;
            store.setQuantity(quantity);
            rez = storeDao.update(store);
        }else{
            System.err.println(" this quantity not available");
        }
        return rez;
    }

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        return notebookDao.getPortion(0,size);
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
    public List<Notebook> getNotebooksStorePresent() {
        return notebookDao.findAll();
    }

    @Override
    public Map<Notebook, Integer> getSalesByDays() throws ParseException {
        Date date = null;
        Map<Notebook, Integer> map = new HashMap<Notebook, Integer>();
        //date = dateFormat.parse("25.02.2015");
        date = dateFormat.parse("02.02.2015");
        ArrayList<Store> list = (ArrayList)storeDao.findAllBySalesDay(date);
        System.err.println(dateFormat.format(date));
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++ ){
            Store store = list.get(i);
            System.out.println(i);
            System.err.println(" "+store.getId()+" "+store.getQuantity());
        }
        return map;
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {
        return null;
    }

    //------------CPU----------

    @Override
    public Long createCPU(CPU cpu) {
        return cpuDao.create(cpu);
    }

    @Override
    public CPU readCPU(Long id) {
        return cpuDao.read(id);
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        cpuDao.update(cpu);
        return false;
    }

    @Override
    public boolean deleteCPU(CPU cpu) {
        cpuDao.delete(cpu);
        return false;
    }

    @Override
    public List<CPU> findAllCPU() {
        return cpuDao.findAll();
    }

    //----------MEMORY----------------

    @Override
    public Long createMemory(Memory memory) {
        return memoryDao.create(memory);
    }

    @Override
    public Memory readMemory(Long id) {
        return memoryDao.read(id);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        memoryDao.update(memory);
        return false;
    }

    @Override
    public boolean deleteMemory(Memory memory) {
        memoryDao.delete(memory);
        return false;
    }

    @Override
    public List<Memory> findAllMemory() {
        return memoryDao.findAll();
    }

    //-------------VENDOR-------------

    @Override
    public Long createVendor(Vendor vendor) {
        return vendorDao.create(vendor);
    }

    @Override
    public Vendor readVendor(Long id) {
        return vendorDao.read(id);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        vendorDao.update(vendor);
        return false;
    }

    @Override
    public boolean deleteVendor(Vendor vendor) {
        vendorDao.delete(vendor);
        return false;
    }

    @Override
    public List<Vendor> findAllVendor() {
        return vendorDao.findAll();
    }

    //------------NOTEBOOK--------------

    @Override
    public Long createNotebook(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    @Override
    public Notebook readNotebook(Long id) {
        return notebookDao.read(id);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        notebookDao.update(notebook);
        return false;
    }

    @Override
    public boolean deleteNotebook(Notebook notebook) {
        notebookDao.delete(notebook);
        return false;
    }

    @Override
    public List<Notebook> findAllNotebook() {
        return notebookDao.findAll();
    }

    //---------------STORE---------------

    @Override
    public Long createStore(Store store) {
        return storeDao.create(store);
    }

    @Override
    public Store readStore(Long id) {
        return storeDao.read(id);
    }

    @Override
    public boolean updateStore(Store store) {
        storeDao.update(store);
        return false;
    }

    @Override
    public boolean deleteStore(Store store) {
        storeDao.update(store);
        return false;
    }

    @Override
    public List<Store> findAllStore() {
        return storeDao.findAll();
    }

    //-------------SALES-----------------

    @Override
    public Long create(Sales sales) {
        return salesDao.create(sales);
    }

    @Override
    public Sales readSales(Long id) {
        return salesDao.read(id);
    }

    @Override
    public boolean updateSales(Sales sales) {
        salesDao.update(sales);
        return false;
    }

    @Override
    public boolean deleteSales(Sales sales) {
        salesDao.delete(sales);
        return false;
    }

    @Override
    public List<Sales> findAllSales() {
        return salesDao.findAll();
    }
}
