package hw6.notes.service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by tsv on 14.02.15.
 */

public class Menu {


    private final ArrayList<String> listFromConsole = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
//    private NotebookServiceImpl notebookServiceImpl = new NotebookServiceImpl();


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
            } else {
                String menuItem = listFromConsole.get(0);
                switch (menuItem) {
                    case "1":
                        addNotebook();
                        break;
                    case "2":
//                        findAllNotebook();
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
//        Notebook notebook = notebookServiceImpl.createNewNotebook();
//        notebookServiceImpl.add(notebook);
    }

//    public void findAllNotebook() {
//        notebookServiceImpl.findAll();
//    }

//    public void deleteNtb(Notebook notebook) {
//    }

    public void deleteById() {
//        System.out.println("Введите номер ID для notebook");
//        Long id = scan.nextLong();
//        Notebook notebook = notebookServiceImpl.read(id);
//        notebookServiceImpl.deleteNtb(notebook);
    }

//    public void changePrice(Notebook notebook) {
//    }

    public void changePriceP() {
//        System.out.println("Введите номер ID для notebook");
//        Long id = scan.nextLong();
//        System.out.println("Введите новую цену:");
//        Double price = scan.nextDouble();
//        notebookServiceImpl.changePrice(id, price);
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

//        notebookServiceImpl.changeSerialVendor(id, serial, vendor);
    }

    public void deleteByModel() {
        System.out.println("Введите номер модели Notebook");
        String model = scan.next();
//        notebookServiceImpl.deleteByModel(model);
    }


    public void showByVendor() {
        System.out.println("Введите название производителя");
        String vendor = scan.next();
//        List<Notebook> list = notebookServiceImpl.findByVendor(vendor);
//        for (Notebook i : list) {
//            System.out.println(i + " ");
//        }
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
//        List<Notebook> list = notebookServiceImpl.findByPriceManufDate(price, manufactureDate);
//        for (Notebook i : list) {
//            System.out.println(i + " ");
//        }
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
//        List<Notebook> list = notebookServiceImpl.findBetweenPriceLtDateByVendor(priceFrom, priceTo, manufactureDate, vendor);
//        for (Notebook i : list) {
//            System.out.println(i + " ");
//        }
    }
}
