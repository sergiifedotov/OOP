package hw7.springnotes;

import hw7.springnotes.service.NotebookService;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;


import java.util.Locale;

/**
 * Created by vladimir on 23.02.2015.
 *
 * Написать приложение "Магазин ноутбуков" с использованием Spring:
 Тип ноутбука(производитель, модель, дата производства, процессор, память)
 Производители(имя)
 Процессоры(производитель, частота, модель)
 Память(производитель, размер)
 Склад ноутбуков(тип ноутбука, количество, цена)
 Продажи(склад ноутбуков, дата продажи, количество)

 hw7.springnotes.dao.NotebookDaoImpl
 hw7.springnotes.dao.VendorDaoImpl
 hw7.springnotes.dao.CPUDaoImpl
 hw7.springnotes.dao.MemoryDaoImpl
 hw7.springnotes.dao.StoreDaoImpl
 hw7.springnotes.dao.SalesDaoImpl

 Добавить следующие функции:
 Создать процессор
 Создать память
 Создать производителя
 Создать тип ноутбука
 Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
 Продать указанное количество ноутбуков со склада(id склада, количество)
 Изменить процессор
 Изменить память
 Изменить имя производителя
 Изменить тип ноутбука
 Списать со склад ноутбуки (ключ, количество)
 Показать все ноутбуки на складе (пользователь указывает размер порции)
 Показать все ноутбуки которых больше указанного количества
 Показать все ноутбуки по указанному имени производителя процессора
 Показать все ноутбуки на складе
 Показать типы ноутбуков, оставшиеся на складе по каждому производителю
 Получить объем продаж ноутбуков по каждому дню

 hw7.springnotes.service.NotebookService
 List<Notebook> getNotebooksByPortion(int size)
 List<Notebook> getNotebooksGtAmount(int amount)
 List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor)
 List<Notebook> getNotebooksFromStore()
 List<Notebook> getNotebooksStorePresent()
 Map<Notebook, int> getSalesByDays()
 boolean updateCPU(CPU cpu)
 boolean updateMemory(Memory memory)
 boolean updateVendor(Vendor vendor)
 boolean updateNotebook(Notebook notebook)
 boolean removeFromStore(Store store, int amount)

 */

public class Main {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("hw7/springnotes/context.xml");

    private NotebookService notebookService = applicationContext.getBean("notebookServiceImpl", NotebookService.class);


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Main main = new Main();
        NotebookService ns = main.notebookService;

        System.err.println(ns.getNotebooks());
        System.err.println(ns.getNotebooksFromStore());
        System.err.println(ns.getSalesByDays());

        ns.close();
    }
}
