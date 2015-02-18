package hw7.notes.dao;

import hw7.notes.domain.Notebook;

import java.util.List;

/**
 *  Создать сущности для базы данных "Магазин ноутбуков":
 Тип ноутбука(производитель, модель, дата производства, процессор, память)
 Производители(имя)
 Процессоры(производитель, частота, модель)
 Память(производитель, размер)
 Склад ноутбуков(тип ноутбука, количество, цена)
 Продажи(склад ноутбуков, дата продажи, количество)

 domain
 hw7.notes.domain.Notebook
 hw7.notes.domain.Vendor
 hw7.notes.domain.CPU
 hw7.notes.domain.Memory
 hw7.notes.domain.Store
 hw7.notes.domain.Sales
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List<Notebook> findAll();
}
