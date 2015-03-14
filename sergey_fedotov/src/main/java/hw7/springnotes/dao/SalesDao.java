package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Sales;
import java.util.List;
import java.util.Map;

/**
 * 2.  Создать приложение магазин ноутбуков со следующими функциями:
 Создать процессор
 Создать память
 Создать производителя
 Создать тип ноутбука
 Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
 Продать указанное количество ноутбуков со склада(id склада, количество)

 domain
 hw7.springnotes.domain.Notebook
 hw7.springnotes.domain.Vendor
 hw7.springnotes.domain.CPU
 hw7.springnotes.domain.Memory
 hw7.springnotes.domain.Store
 hw7.springnotes.domain.Sales
 dao
 hw7.springnotes.dao.NotebookDao
 Long create(Notebook notebook)
 Notebook read(Long ig)
 boolean update(Notebook notebook)
 boolean delete(Notebook notebook)
 List<Notebook> findAll()
 hw7.springnotes.dao.VendorDao
 Long create(Vendor vendor)
 Vendor read(Long ig)
 boolean update(Vendor vendor)
 boolean delete(Vendor vendor)
 List<Vendor> findAll()
 hw7.springnotes.dao.CPUDao
 Long create(CPU cpu)
 CPU read(Long ig)
 boolean update(CPU cpu)
 boolean delete(CPU cpu)
 List<CPU> findAll()
 hw7.springnotes.dao.MemoryDao
 Long create(Memory memory)
 Memory read(Long ig)
 boolean update(Memory memory)
 boolean delete(Memory memory)
 List<Memory> findAll()
 hw7.springnotes.dao.StoreDao
 Long create(Store store)
 Store read(Long ig)
 boolean update(Store store)
 boolean delete(Store store)
 List<Store> findAll()
 hw7.springnotes.dao.SalesDao
 Long create(Sales store)
 Sales read(Long ig)
 boolean update(Sales store)
 boolean delete(Sales store)
 List<Sales> findAll()

 hw7.springnotes.dao.NotebookDaoImpl
 hw7.springnotes.dao.VendorDaoImpl
 hw7.springnotes.dao.CPUDaoImpl
 hw7.springnotes.dao.MemoryDaoImpl
 hw7.springnotes.dao.StoreDaoImpl
 hw7.springnotes.dao.SalesDaoImpl
 service
 hw7.springnotes.service.NotebookService
 Long receive(notebookId id, int amount, double price)
 Long sale(storeId, int amount)
 hw7.springnotes.service.NotebookServiceImpl
 view
 hw7.springnotes.service.Menu
 main()
 */
public interface SalesDao {
    Long create(Sales sales);
    Sales read(Long id);
    boolean update(Sales sales);
    boolean delete(Sales sales);
    List<Sales> findAll();
    Map<Notebook,Integer> getSalesByDays();
}
