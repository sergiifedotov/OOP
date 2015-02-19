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
 Списать со склад ноутбуки (ключ, количество)

 service
 hw7.notes.service.NotebookService
 boolean updateCPU(CPU cpu)
 boolean updateMemory(Memory memory)
 boolean updateVendor(Vendor vendor)
 boolean updateNotebook(Notebook notebook)
 boolean removeFromStore(Store store, int amount)
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
                               ) {
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.vendorDao = vendorDao;
        this.notebookDao = notebookDao;
        this.storeDao = storeDao;
        this.salesDao = salesDao;
    }


    @Override
    public Long add(CPU cpu) {
        return cpuDao.create(cpu);
    }

    @Override
    public Long add(Memory memory) {
        return memoryDao.create(memory);
    }

    @Override
    public Long add(Vendor vendor) {
        return vendorDao.create(vendor);
    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
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
        store.setAmount(store.getAmount() - (store.getAmount().compareTo(amount) < 0 ? store.getAmount() : amount));
        return storeDao.update(store);
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
}
