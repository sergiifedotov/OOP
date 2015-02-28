package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Создать DAO для таблицы ноутбуки
 * dao
 * hw6.notes.dao.NotebookDao
 * hw6.notes.dao.NotebookDaoImpl
 * <p/>
 * Long create(Notebook ntb)         Long create(Notebook notebook)
 * Notebook read(Long ig)
 * boolean update(Notebook ntb)      boolean update(Notebook notebook)
 * boolean delete(Notebook ntb)      boolean delete(Notebook notebook)
 * List<Notebook> findAll()
 * List<Notebook> findByModel(String model)
 * List<Notebook> findByVendor(String vendor)
 * List<Notebook> findByPriceManufDate(Double price, Date date)
 * List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor)
 * domain
 * hw6.notes.domain.Notebook
 * <p/>
 * Таблица ноутбуки имеет следующую структуру
 * (id, serial, vendor, model, manufacture date, price)
 * service
 * hw6.notes.service.NotebookService
 * hw6.notes.service.NotebookServiceImpl
 * <p/>
 * Long add(Notebook notebook)
 * List<Notebook> findAll()
 * void changePrice(Long id, double price)
 * void changeSerialVendor(Long id, String serial, String vendor)
 * boolean delete(Long id)
 * boolean deleteByModel(String model)
 * List<Notebook> findByVendor(String vendor)
 * List<Notebook> findByPriceManufDate(Double price, Date date)
 * List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor)
 * <p/>
 * view
 * hw6.notes.service.Menu
 * main()
 * Реализовать функции:
 * - Добавить новый ноутбук
 * - Показать список ноутбуков (включая порядковый номер id)
 * - Удалить ноутбук по id
 * - Изменить цену ноутбука по id
 * - Изменить серийный номер и производителя по id
 * - Удалить ноутбуки по названию модели
 * - Получить ноутбуки по производителю
 * - Получить ноутбуки по цене и году выпуска
 * - Получить ноутбуки по цене в указанном диапазоне, меньше указанной даты выпуска и указанного производителя
 * void deleteNtb(Notebook notebook)
 * void changePrice(Notebook notebook)
 * void changeSerialVendor(Notebook notebook)
 * void deleteByModel()
 * void showByVendor()
 * void showByPriceManufDate()
 * void showBetweenPriceLtDateByVendor()
 * util
 * hw6.notes.util.HibernateUtil
 */
public class Menu {

    private final ArrayList<String> listFromConsole = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private NotebookServiceImpl notebookServiceImpl = new NotebookServiceImpl();


    public Menu() {
    }


    public void present() {
        if (listFromConsole.isEmpty()) {
            listFromConsole.add("notNull");
        }
        boolean next = true;

        while (next) {
            printMenu();
            String str = scan.nextLine();
            if ("".equals(str)) {
                str = scan.nextLine();
            }
            listFromConsole.set(0, str);
            if ("exit".equals(str)) {
                next = false;
                System.exit(0);
            } else {
                String menuItem = listFromConsole.get(0);
                switch (menuItem) {
                    case "1":
                        addNotebook();
                        break;
                    case "2":
                        findAllNotebook();
                        break;
                    case "3":
                        deleteById();
                        break;
                    case "4":
                        changePriceP();
                        break;
                    case "5":
                        changeSerialVendorV();
                        break;
                    case "6":
                        deleteByModel();
                        break;
                    case "7":
                        showByVendor();
                        break;
                    case "8":
                        showByPriceManufDate();
                        break;
                    case "9":
                        showBetweenPriceLtDateByVendor();
                        break;
                    default:

                        break;
                }
            }
        }
    }


    public void printMenu() {
        System.out.println("Сделайте выбор : \n" +
                "1.  Добавить новый ноутбук \n" +
                "2.  Показать список ноутбуков \n" +
                "3.  Удалить ноутбук по id \n" +
                "4.  Изменить цену ноутбука по id \n" +
                "5.  Изменить серийный номер и производителя по id \n" +
                "6.  Удалить ноутбуки по названию модели\n" +
                "7.  Получить ноутбуки по производителю\n" +
                "8.  Получить ноутбуки по цене и году выпуска\n" +
                "9.  Получить ноутбуки по цене в указанном диапазоне, меньше\n" +
                "        указанной  даты  выпуска и указанного производителя\n" +
                "10. Введите (exit) для выхода из программы");
    }

    public void addNotebook() {
        Notebook notebook = notebookServiceImpl.createNewNotebook();
        notebookServiceImpl.add(notebook);
    }

    public void findAllNotebook() {
        List<Notebook> list = notebookServiceImpl.findAll();
        for (Notebook i : list) {
            System.out.println(i + " ");
        }
    }

//    public void deleteNtb(Notebook notebook) {
//    }

    public void deleteById() {
        System.out.println("Введите номер ID для notebook");
        Long id = scan.nextLong();
        Notebook notebook = notebookServiceImpl.read(id);
        notebookServiceImpl.deleteNtb(notebook);
    }

//    public void changePrice(Notebook notebook) {
//    }

    public void changePriceP() {
        System.out.println("Введите номер ID для notebook");
        Long id = scan.nextLong();
        System.out.println("Введите новую цену:");
        Double price = scan.nextDouble();
        notebookServiceImpl.changePrice(id, price);
    }

//    public void changeSerialVendor(Notebook notebook) {
//    }

    public void changeSerialVendorV() {
        System.out.println("Введите номер ID для notebook");
        Long id = scan.nextLong();
        System.out.println("Введите новый серийный номер:");
        String serial = scan.next();
        System.out.println("Введите нового производителя:");
        String vendor = scan.next();

        notebookServiceImpl.changeSerialVendor(id, serial, vendor);
    }

    public void deleteByModel() {
        System.out.println("Введите номер модели Notebook");
        String model = scan.next();
        notebookServiceImpl.deleteByModel(model);
    }


    public void showByVendor() {
        System.out.println("Введите название производителя");
        String vendor = scan.next();
        List<Notebook> list = notebookServiceImpl.findByVendor(vendor);
        for (Notebook i : list) {
            System.out.println(i + " ");
        }
    }

    public void showByPriceManufDate() {
        System.out.println("Введите цену");
        Double price = scan.nextDouble();
        System.out.println("Введите год выпуска (dd.mm.yyyy)");
        String manufDate = scan.next();
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        Date manufactureDate = null;
        try {
            manufactureDate = dateFormat.parse(manufDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Notebook> list = notebookServiceImpl.findByPriceManufDate(price, manufactureDate);
        for (Notebook i : list) {
            System.out.println(i + " ");
        }
    }

    public void showBetweenPriceLtDateByVendor() {
        System.out.println("Укажите производителя");
        String vendor = scan.next();
        System.out.println("Введите цену от _ грн.");
        Double priceFrom = scan.nextDouble();
        System.out.println("Введите цену до _ грн.");
        Double priceTo = scan.nextDouble();
        System.out.println("Введите год выпуска (dd.mm.yyyy)");
        String manufDate = scan.next();
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        Date manufactureDate = null;
        try {
            manufactureDate = dateFormat.parse(manufDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Notebook> list = notebookServiceImpl.findBetweenPriceLtDateByVendor(priceFrom, priceTo, manufactureDate, vendor);
        for (Notebook i : list) {
            System.out.println(i + " ");
        }
    }
}
