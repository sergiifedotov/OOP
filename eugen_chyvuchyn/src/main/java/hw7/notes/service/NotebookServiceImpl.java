package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Chuvychin on 20.02.2015.
 */
public class NotebookServiceImpl implements NotebookService {
    private CPUDaoImpl cpuDao;
    private MemoryDaoImpl memoryDao;
    private NotebookDaoImpl notebookDao;
    private SalesDaoImpl salesDao;
    private StoreDaoImpl storeDao;
    private VendorDaoImpl vendorDao;

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(CPUDaoImpl cpuDao, MemoryDaoImpl memoryDao, NotebookDaoImpl notebookDao, SalesDaoImpl salesDao, StoreDaoImpl storeDao, VendorDaoImpl vendorDao) {
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.notebookDao = notebookDao;
        this.salesDao = salesDao;
        this.storeDao = storeDao;
        this.vendorDao = vendorDao;
    }

    @Override //Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
    public Long receive(Long notebookId, int amount, double price) {
        Notebook notebook = notebookDao.read(notebookId);
        Store store = new Store(notebook,amount,price);
        return storeDao.create(store);
    }

    @Override //Продать указанное количество ноутбуков со склада(id склада, количество)
    public Long sale(Long storeId, int amount) {
        Store store = storeDao.read(storeId);
        Date sales_date = new Date();
        Sales sales = new Sales(store,sales_date,amount);
        if (this.removeFromStore(store,amount)) {
            return salesDao.create(sales);
        }
        return null;
    }

    @Override // Изменить процессор
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Override // Изменить память
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    @Override // Изменить имя производителя
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Override // Изменить тип ноутбука
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    @Override // Списать со склад ноутбуки (ключ, количество)
    public boolean removeFromStore(Store store, int amount) {
        if(store.getAmount()-amount >=0){
            store.setAmount(store.getAmount()-amount);
            return storeDao.update(store);
        }
        return false;
    }

    @Override // Показать все ноутбуки на складе (пользователь указывает размер порции)
    public List<Notebook> getNotebooksByPortion(int size) {
        return null;
    }

    @Override // Показать все ноутбуки которых больше указанного количества
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return null;
    }

    @Override //  Показать все ноутбуки по указанному имени производителя процессора
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return null;
    }

    @Override // Показать все ноутбуки на складе
    public List<Notebook> getNotebooksFromStore() {
        return notebookDao.findAll();
    }

    @Override // Показать типы ноутбуков, оставшиеся на складе по каждому производителю
    public List<Notebook> getNotebooksStorePresent() {
        return null;
    }

    @Override //  Получить объем продаж ноутбуков по каждому дню
    public Map<Notebook, Integer> getSalesByDays() {
        return null;
    }
}
