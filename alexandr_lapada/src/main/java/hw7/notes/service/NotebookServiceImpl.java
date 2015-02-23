package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by sanya on 17.02.2015.
 */
public class NotebookServiceImpl implements NotebookService {
    CPUDaoImpl cpuDao = null;
    MemoryDaoImpl memoryDao = null;
    VendorDaoImpl vendorDao = null;
    NotebookDaoImpl notebookDao = null;
    StoreDaoImpl storeDao = null;
    SalesDaoImpl salesDao = null;

    public NotebookServiceImpl(){

    }

    public NotebookServiceImpl(CPUDaoImpl cpuDao, MemoryDaoImpl memoryDao, VendorDaoImpl vendorDao,
                               NotebookDaoImpl notebookDao, StoreDaoImpl storeDao, SalesDaoImpl salesDao) {
        this.salesDao = salesDao;
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.vendorDao = vendorDao;
        this.notebookDao = notebookDao;
        this.storeDao = storeDao;
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
    public List<Notebook> getNotebooksByCpuVendor(String cpuVendor) {
        return notebookDao.getNotebooksByCpuVendor(cpuVendor);
    }


    @Override
    public List<Notebook> getNotebooksStorePresent() {
        return notebookDao.getNotebooksStorePresent();
    }

    @Override
    public Map<Notebook, Integer> getSalesByDays() {
        return null;
    }

    //-----------CPU-----

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
        return cpuDao.update(cpu);
    }

    @Override
    public boolean deleteCPU(CPU cpu) {
        return cpuDao.delete(cpu);
    }

    @Override
    public List<CPU> findAllCPU() {
        return cpuDao.findAll();
    }

    //-----------MEMORY-----------

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
        return memoryDao.update(memory);
    }

    @Override
    public boolean deleteMemory(Memory memory) {
        return memoryDao.delete(memory);
    }

    @Override
    public List<Memory> findAllMemory() {
        return memoryDao.findAll();
    }

    //-----------VENDOR------

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
        return vendorDao.update(vendor);
    }

    @Override
    public boolean deleteVendor(Vendor vendor) {
        return vendorDao.delete(vendor);
    }

    @Override
    public List<Vendor> findAllVendor() {
        return vendorDao.findAll();
    }

    //---------------NOTEBOOK-----------

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
        return notebookDao.update(notebook);
    }

    @Override
    public boolean deleteNotebook(Notebook notebook) {
        return notebookDao.delete(notebook);
    }

    @Override
    public List<Notebook> findAllNotebook() {
        return notebookDao.findAll();
    }

    //-----------STORE--------------

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
        return storeDao.update(store);
    }

    @Override
    public boolean deleteStore(Store store) {
        return storeDao.delete(store);
    }

    @Override
    public List<Store> findAllStore() {
        return storeDao.findAll();
    }

    //-------------SALES------------

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
        return salesDao.update(sales);
    }

    @Override
    public boolean deleteSales(Sales sales) {
        return salesDao.delete(sales);
    }

    @Override
    public List<Sales> findAllSales() {
        return salesDao.findAll();
    }


}
