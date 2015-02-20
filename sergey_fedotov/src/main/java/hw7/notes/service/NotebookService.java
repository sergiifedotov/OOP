package hw7.notes.service;

import hw7.notes.domain.*;

import java.util.List;

/**
 *3. Добавить в приложение ноутбуков следующие функции
 Изменить процессор
 Изменить память
 Изменить имя производителя
 Изменить тип ноутбука
 Списать со склад ноутбуки (ключ, количество)
 */
public interface NotebookService {
    Long receive(long notebookId, int amount, double price);
    Long sale(long storeId, int amount);
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);

    Long add(Notebook notebook);
    List<Notebook> findAll();
}
