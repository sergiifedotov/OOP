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
    Создать DAO для таблицы ноутбуки
 dao
     hw6.notes.dao.NotebookDao
    hw6.notes.dao.NotebookDaoImpl

    Long create(Notebook ntb)         Long create(Notebook notebook)
    Notebook read(Long ig)
    boolean update(Notebook ntb)      boolean update(Notebook notebook)
    boolean delete(Notebook ntb)      boolean delete(Notebook notebook)
    List<Notebook> findAll()
    List<Notebook> findByModel(String model)
    List<Notebook> findByVendor(String vendor)
    List<Notebook> findByPriceManufDate(Double price, Date date)
    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor)
 domain
    hw6.notes.domain.Notebook

    Таблица ноутбуки имеет следующую структуру
    (id, serial, vendor, model, manufacture date, price)
 service
    hw6.notes.service.NotebookService
     hw6.notes.service.NotebookServiceImpl

    Long add(Notebook notebook)
    List<Notebook> findAll()
    void changePrice(Long id, double price)
    void changeSerialVendor(Long id, String serial, String vendor)
    boolean delete(Long id)
     boolean deleteByModel(String model)
     List<Notebook> findByVendor(String vendor)
    List<Notebook> findByPriceManufDate(Double price, Date date)
    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor)

 view
    hw6.notes.service.Menu
    main()
    Реализовать функции:
     - Добавить новый ноутбук
     - Показать список ноутбуков (включая порядковый номер id)
    - Удалить ноутбук по id
     - Изменить цену ноутбука по id
    - Изменить серийный номер и производителя по id
    - Удалить ноутбуки по названию модели
    - Получить ноутбуки по производителю
    - Получить ноутбуки по цене и году выпуска
    - Получить ноутбуки по цене в указанном диапазоне, меньше указанной даты выпуска и указанного производителя
           void deleteNtb(Notebook notebook)
           void changePrice(Notebook notebook)
           void changeSerialVendor(Notebook notebook)
           void deleteByModel()
           void showByVendor()
           void showByPriceManufDate()
           void showBetweenPriceLtDateByVendor()
 util
    hw6.notes.util.HibernateUtil
 */
public class Menu {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.present();
    }


    private final ArrayList<String> listFromConsole = new ArrayList<>();

    public void present() {
        Scanner scan = new Scanner(System.in);
        printMenu();
        if (listFromConsole.isEmpty()) {
            listFromConsole.add("notNull");
        }

        while (!listFromConsole.get(0).equals("")) {
            String str = scan.nextLine();
            listFromConsole.set(0, str);
            if ("".equals(str)) {
                System.exit(0);
            } else {
                String menuItem = listFromConsole.get(0);
                switch (menuItem) {
                    case "1":
                        NotebookServiceImpl nsi1 = new NotebookServiceImpl();
                        Notebook notebook1 = nsi1.createNewNotebook();
                        nsi1.add(notebook1);
                        break;
                    case "2":
                        NotebookServiceImpl ns2 = new NotebookServiceImpl();
                        ns2.findAll();
                        break;
                    case "3":
                        Scanner scan3 = new Scanner(System.in);
                        System.out.println("Введите номер ID для notebook");
                        Long id3 = scan3.nextLong();

                        NotebookServiceImpl nsi3 = new NotebookServiceImpl();
                        Notebook notebook3 = nsi3.read(id3);
                        nsi3.deleteNtb(notebook3);
                        break;
                    case "4":
                        Scanner scan4 = new Scanner(System.in);
                        System.out.println("Введите номер ID для notebook");
                        Long id4 = scan4.nextLong();
                        System.out.println("Введите новую цену:");
                        Double price4 = scan4.nextDouble();
                        NotebookServiceImpl nsi4 = new NotebookServiceImpl();
                        nsi4.changePrice(id4, price4);
                        break;
                    case "5":
                        Scanner scan5 = new Scanner(System.in);
                        System.out.println("Введите номер ID для notebook");
                        Long id5 = scan5.nextLong();
                        System.out.println("Введите новый серийный номер:");
                        String serial5 = scan5.next();
                        System.out.println("Введите нового производителя:");
                        String vendor5 = scan5.next();
                        NotebookServiceImpl nsi5 = new NotebookServiceImpl();
                        nsi5.changeSerialVendor(id5, serial5, vendor5);
                        break;
                    case "6":
                        Scanner scan6 = new Scanner(System.in);
                        System.out.println("Введите номер модели Notebook");
                        String model6 = scan6.next();

                        NotebookServiceImpl nsi6 = new NotebookServiceImpl();
                        nsi6.deleteByModel(model6);
                        break;
                    case "7":
                        Scanner scan7 = new Scanner(System.in);
                        System.out.println("Введите название производителя");
                        String vendor7 = scan7.next();

                        NotebookServiceImpl nsi7 = new NotebookServiceImpl();
                        List<Notebook> list7 = nsi7.findByVendor(vendor7);
                        for(Notebook i: list7){
                            System.out.println(i + " ");
                        }
                        break;
                    case "8":
                        Scanner scan8 = new Scanner(System.in);
                        System.out.println("Введите цену");
                        Double price8 = scan8.nextDouble();
                        System.out.println("Введите год выпуска (dd.mm.yyyy)");
                        String manufDate = scan8.next();
                        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
                        Date manufactureDate = null;
                        try {
                            manufactureDate = dateFormat.parse(manufDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        NotebookServiceImpl nsi8 = new NotebookServiceImpl();
                        List<Notebook> list8 = nsi8.findByPriceManufDate(price8, manufactureDate);
                        for(Notebook i: list8){
                            System.out.println(i + " ");
                        }
                        break;
                    case "9":
                        Scanner scan9 = new Scanner(System.in);
                        System.out.println("Укажите производителя");
                        String vendor = scan9.next();
                        System.out.println("Введите цену от _ грн.");
                        Double priceFrom9 = scan9.nextDouble();
                        System.out.println("Введите цену до _ грн.");
                        Double priceTo9 = scan9.nextDouble();
                        System.out.println("Введите год выпуска (dd.mm.yyyy)");
                        String manufDate9 = scan9.next();

                        DateFormat dateFormat9 = new SimpleDateFormat("dd.mm.yyyy");
                        Date manufactureDate9 = null;
                        try {
                            manufactureDate9 = dateFormat9.parse(manufDate9);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        NotebookServiceImpl nsi9 = new NotebookServiceImpl();
                        List<Notebook> list9 = nsi9.findBetweenPriceLtDateByVendor(priceFrom9, priceTo9, manufactureDate9, vendor);
                        for(Notebook i: list9){
                            System.out.println(i + " ");
                        }
                        break;
                    default:

                        break;
                }

            }
            printMenu ();

    }
    }


    public void printMenu (){
        System.out.println("Сделайте выбор : \n" +
                "1.  Добавить новый ноутбук \n" +
                "2.  Показать список ноутбуков \n" +
                "3.  Удалить ноутбук по id \n" +
                "4.  Изменить цену ноутбука по id \n"+
                "5.  Изменить серийный номер и производителя по id \n" +
                "6.  Удалить ноутбуки по названию модели\n" +
                "7.  Получить ноутбуки по производителю\n" +
                "8.  Получить ноутбуки по цене и году выпуска\n" +
                "9.  Получить ноутбуки по цене в указанном диапазоне, меньше\n" +
                "        указанной  даты  выпуска и указанного производителя\n"+
                "10. Нажмите  Enter для выхода из программы");
    }

    public  void deleteNtb(Notebook notebook){
    }
    public void changePrice(Notebook notebook){
    }
    public void changeSerialVendor(Notebook notebook){
    }
    public void deleteByModel(){
    }
    public void showByVendor(){
    }
    public void showByPriceManufDate(){
    }
    public void showBetweenPriceLtDateByVendor(){
    }
}
