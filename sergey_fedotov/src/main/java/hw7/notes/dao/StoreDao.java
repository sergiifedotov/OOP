package hw7.notes.dao;

import hw7.notes.domain.Store;

import java.util.List;

/**
 * 2.  Создать приложение магазин ноутбуков со следующими функциями:
 Создать процессор
 Создать память
 Создать производителя
 Создать тип ноутбука
 Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
 Продать указанное количество ноутбуков со склада(id склада, количество)

 domain
 hw7.notes.domain.Notebook
 hw7.notes.domain.Vendor
 hw7.notes.domain.CPU
 hw7.notes.domain.Memory
 hw7.notes.domain.Store
 hw7.notes.domain.Sales
 dao
 hw7.notes.dao.NotebookDao
 Long create(Notebook notebook)
 Notebook read(Long ig)
 boolean update(Notebook notebook)
 boolean delete(Notebook notebook)
 List<Notebook> findAll()
 hw7.notes.dao.VendorDao
 Long create(Vendor vendor)
 Vendor read(Long ig)
 boolean update(Vendor vendor)
 boolean delete(Vendor vendor)
 List<Vendor> findAll()
 hw7.notes.dao.CPUDao
 Long create(CPU cpu)
 CPU read(Long ig)
 boolean update(CPU cpu)
 boolean delete(CPU cpu)
 List<CPU> findAll()
 hw7.notes.dao.MemoryDao
 Long create(Memory memory)
 Memory read(Long ig)
 boolean update(Memory memory)
 boolean delete(Memory memory)
 List<Memory> findAll()
 hw7.notes.dao.StoreDao
 Long create(Store store)
 Store read(Long ig)
 boolean update(Store store)
 boolean delete(Store store)
 List<Store> findAll()
 hw7.notes.dao.SalesDao
 Long create(Sales store)
 Sales read(Long ig)
 boolean update(Sales store)
 boolean delete(Sales store)
 List<Sales> findAll()

 hw7.notes.dao.NotebookDaoImpl
 hw7.notes.dao.VendorDaoImpl
 hw7.notes.dao.CPUDaoImpl
 hw7.notes.dao.MemoryDaoImpl
 hw7.notes.dao.StoreDaoImpl
 hw7.notes.dao.SalesDaoImpl
 service
 hw7.notes.service.NotebookService
 Long receive(notebookId id, int amount, double price)
 Long sale(storeId, int amount)
 hw7.notes.service.NotebookServiceImpl
 view
 hw7.notes.service.Menu
 main()
 */
public interface StoreDao {
    Long create(Store store);
    Store read(Long id);
    boolean update(Store store);
    boolean delete(Store store);
    List<Store> findAll();
}
