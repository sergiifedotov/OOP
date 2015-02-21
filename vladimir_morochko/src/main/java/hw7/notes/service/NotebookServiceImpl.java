package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 17.02.2015.
 *
 * 2.  Создать приложение магазин ноутбуков со следующими функциями:
 Создать процессор
 Создать память
 Создать производителя
 Создать тип ноутбука
 Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
 Продать указанное количество ноутбуков со склада(id склада, количество)

 service
 hw7.notes.service.NotebookService
 Long receive(notebookId id, int amount, double price)
 Long sale(storeId, int amount)
 hw7.notes.service.NotebookServiceImpl

 3. Добавить в приложение ноутбуков следующие функции
 Изменить процессор
 Изменить память
 Изменить имя производителя
 Изменить тип ноутбука
 Списать со склада ноутбуки (ключ, количество)

 service
 hw7.notes.service.NotebookService
 boolean updateCPU(CPU cpu)
 boolean updateMemory(Memory memory)
 boolean updateVendor(Vendor vendor)
 boolean updateNotebook(Notebook notebook)
 boolean removeFromStore(Store store, int amount)
 hw7.notes.service.NotebookServiceImpl

 4. Добавить в приложение ноутбуков следующие функции:
 Показать все ноутбуки на складе (пользователь указывает размер порции)
 Показать все ноутбуки которых больше указанного количества
 Показать все ноутбуки по указанному имени производителя процессора
 Показать все ноутбуки на складе
 Показать типы ноутбуков, оставшиеся на складе по каждому производителю
 Получить объем продаж ноутбуков по каждому дню

 service
 hw7.notes.service.NotebookService
 List<Notebook> getNotebooksByPortion(int size)
 List<Notebook> getNotebooksGtAmount(int amount)
 List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor)
 List<Notebook> getNotebooksFromStore()
 List<Notebook> getNotebooksStorePresent()
 Map<Notebook, int> getSalesByDays()
 hw7.notes.service.NotebookServiceImpl
 */

public class NotebookServiceImpl implements NotebookService {
    private CPUDao cpuDao = new CPUDaoImpl();
    private MemoryDao memoryDao = new MemoryDaoImpl();
    private VendorDao vendorDao = new VendorDaoImpl();
    private NotebookDao notebookDao = new NotebookDaoImpl();
    private StoreDao storeDao = new StoreDaoImpl();
    private SalesDao salesDao = new SalesDaoImpl();

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(CPUDao cpuDao,
                               MemoryDao memoryDao,
                               VendorDao vendorDao,
                               NotebookDao notebookDao,
                               StoreDao storeDao,
                               SalesDao salesDao
                               )
    {
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.vendorDao = vendorDao;
        this.notebookDao = notebookDao;
        this.storeDao = storeDao;
        this.salesDao = salesDao;
    }

    // Создать процессор
    @Override
    public Long add(CPU cpu) {
        return cpuDao.create(cpu);
    }

    // Создать память
    @Override
    public Long add(Memory memory) {
        return memoryDao.create(memory);
    }

    // Создать производителя
    @Override
    public Long add(Vendor vendor) {
        return vendorDao.create(vendor);
    }

    // Создать тип ноутбука
    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    // Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
    @Override
    public Long receive(Long notebookId, int amount, double price) {
        Notebook notebook = notebookDao.read(notebookId);
        Store store = new Store(notebook, amount, price);
        return storeDao.create(store);
    }

    // Продать указанное количество ноутбуков со склада(id склада, количество)
    @Override
    public Long sale(Long storeId, int amount) {
        Store store = storeDao.read(storeId);
        this.removeFromStore(store, amount);

        Date date = new Date();
        Sales sales = new Sales(store, date, amount);
        return salesDao.create(sales);
    }

    // Изменить процессор
    @Override
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    // Изменить память
    @Override
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    // Изменить имя производителя
    @Override
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    // Изменить тип ноутбука
    @Override
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    // Списать со склада ноутбуки (ключ, количество)
    @Override
    public boolean removeFromStore(Store store, int amount) {
        store.setAmount(store.getAmount() - (store.getAmount().compareTo(amount) < 0 ? store.getAmount() : amount));
        return storeDao.update(store);
    }

    // Показать все ноутбуки на складе (пользователь указывает размер порции)
    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        return notebookDao.getNotebooksByPortion(size);
    }

    // Показать все ноутбуки, которых больше указанного количества
    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return storeDao.getNotebooksGtAmount(amount);
    }

    // Показать все ноутбуки по указанному имени производителя процессора
    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return notebookDao.getNotebooksByCpuVendor(cpuVendor);
    }

    // Показать все ноутбуки на складе
    @Override
    public List<Notebook> getNotebooksFromStore() {
        return storeDao.getNotebooksFromStore();
    }

    // Показать типы ноутбуков, оставшиеся на складе по каждому производителю
    @Override
    public List<Notebook> getNotebooksStorePresent() {
        //TODO Map?
        return storeDao.getNotebooksStorePresent();
    }

    // Получить объем продаж ноутбуков по каждому дню
    @Override
    public Map<Notebook, Integer> getSalesByDays() {
        return salesDao.getSalesByDays();
    }

    @Override
    public void close() {
        cpuDao.close();
        memoryDao.close();
        vendorDao.close();
        notebookDao.close();
        storeDao.close();
        salesDao.close();
    }
}
