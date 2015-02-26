package hw6.notes.view;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * Написать приложение для управления ноутбуками.
 Реализовать функции:
 - Добавить новый ноутбук
 - Показать список ноутбуков (включая порядковый номер id)
 Добавить в приложение ноутбуков следующие функции:
 - Удалить ноутбук по id
 - Изменить цену ноутбука по id
 - Изменить серийный номер и производителя по id

 domain
 hw6.notes.domain.Notebook
 dao
 hw6.notes.dao.NotebookDao
 Long create(Notebook notebook)
 Notebook read(Long ig)
 boolean update(Notebook notebook)
 boolean delete(Notebook notebook)
 List<Notebook> findAll()
 hw6.notes.dao.NotebookDaoImpl
 util
 hw6.notes.util.HibernateUtil
 service
 hw6.notes.service.NotebookService
 Long add(Notebook notebook)
 List<Notebook> findAll()
 hw6.notes.service.NotebookServiceImpl
 view
 hw6.notes.service.Menu
 main()
 void deleteNtb(Notebook notebook)
 void changePrice(Notebook notebook)
 void changeSerialVendor(Notebook notebook)
 */
public class Menu {

    private static final int EXIT_ITEM = 0;
    private static final int SHOW_ALL_NOTEBOOKS_ITEM = 1;
    private static final int ADD_NEW_NOTEBOOK_ITEM = 2;
    private static final int DELETE_NOTEBOOK_BY_ID_ITEM = 3;
    private static final int CHANGE_PRICE_NOTEBOOK_BY_ID_ITEM = 4;
    private static final int CHANGE_SERIAL_AND_VENDOR_BY_ID_ITEM = 5;
    private static final int DELETE_NOTEBOOK_BY_MODEL_ID_ITEM = 6;
    private static final int SHOW_ALL_NOTEBOOKS_BY_VENDOR_ID_ITEM = 7;
    private static final int SHOW_ALL_NOTEBOOKS_BY_PRICE_AND_DATE_ID_ITEM = 8;
    private static final int SHOW_ALL_NOTEBOOKS_BY_PRICE_FROM_TO_DATE_AND_VENDOR_ID_ITEM = 9;

    private NotebookService notebookService;
    private Scanner scan;


    public static void main(String[] args) {

        NotebookDao notebookDao = new NotebookDaoImpl();
        NotebookService notebookService = new NotebookServiceImpl(notebookDao);

        Menu menu = new Menu(notebookService);
        menu.main();
    }

    public Menu() {
        scan = new Scanner(System.in);
    }

    public Menu(NotebookService notebookService) {
        this();
        this.notebookService = notebookService;
    }

    public void main() {
        int choise = EXIT_ITEM;

        do {
            showMenu();
            choise = getInput();

            switch (choise) {
                case EXIT_ITEM:
                    System.exit(0);
                    break;
                case SHOW_ALL_NOTEBOOKS_ITEM:
                    showAllNotebooks();
                    break;
                case ADD_NEW_NOTEBOOK_ITEM:
                    addNewNotebook();
                    break;
                case DELETE_NOTEBOOK_BY_ID_ITEM:
                    deleteNtb();
                    break;
                case CHANGE_PRICE_NOTEBOOK_BY_ID_ITEM:
                    changePrice();
                    break;
                case CHANGE_SERIAL_AND_VENDOR_BY_ID_ITEM:
                    changeSerialVendor();
                    break;
                case DELETE_NOTEBOOK_BY_MODEL_ID_ITEM:
                    deleteByModel();
                    break;
                case SHOW_ALL_NOTEBOOKS_BY_VENDOR_ID_ITEM:
                    showByVendor();
                    break;
                case SHOW_ALL_NOTEBOOKS_BY_PRICE_AND_DATE_ID_ITEM:
                    showByPriceManufDate();
                    break;
                case SHOW_ALL_NOTEBOOKS_BY_PRICE_FROM_TO_DATE_AND_VENDOR_ID_ITEM:
                    showBetweenPriceLtDateByVendor();
                    break;
            }
        } while (choise != EXIT_ITEM);

    }

    private void showAllNotebooks() {
        for (Notebook notebook : notebookService.findAll()) {
            System.out.println(notebook);
        }
    }

    private void addNewNotebook() {

        System.out.println("Input serial");
        String serial = scan.nextLine();
        System.out.println("Input vendor");
        String vendor = scan.nextLine();
        System.out.println("Input model");
        String model = scan.nextLine();
        Date manufacture_date = scanDateWithRetry("Input manufacture date");
        double price = scanDoubleWithRetry("Input price");

        Notebook notebook = new Notebook(serial, vendor, model, manufacture_date, price);
        System.out.println("Added notebook " + notebook);
        notebookService.add(notebook);
    }

    private void deleteNtb() {
        Long id = null;
        System.out.println("Input id");
        id = scan.nextLong();

        notebookService.delete(id);
    }

    private void changePrice() {
        System.out.print("Input id");
        Long id = scan.nextLong();
        double price = scanDoubleWithRetry("Input price");

        notebookService.changePrice(id, price);
    }

    private void changeSerialVendor() {

        System.out.print("Input id");
        Long id = scan.nextLong();
        System.out.println("Input new serial");
        String serial = scan.nextLine();
        System.out.println("Input new vendor");
        String vendor = scan.nextLine();

        notebookService.changeSerialVendor(id, serial, vendor);
    }

    private void deleteByModel() {
        System.out.println("Input model");
        String model = scan.nextLine();

        notebookService.deleteByModel(model);
    }

    private void showByVendor() {
        System.out.println("Input new vendor");
        String vendor = scan.nextLine();

        for (Notebook notebook : notebookService.findByVendor(vendor)) {
            System.out.println(notebook);
        }

    }

    private void showByPriceManufDate() {

        double price = scanDoubleWithRetry("Input price");
        Date manufacture_date = scanDateWithRetry("Input manufacture date");
        for (Notebook notebook : notebookService.findByPriceManufDate(price, manufacture_date)) {
            System.out.println(notebook);
        }

    }

    private void showBetweenPriceLtDateByVendor() {
        double priceFrom = scanDoubleWithRetry("Input price from");
        double priceTo = scanDoubleWithRetry("Input price to");
        Date manufacture_date = scanDateWithRetry("Input manufacture date");
        System.out.println("Input new vendor");
        String vendor = scan.nextLine();
        for (Notebook notebook : notebookService.findBetweenPriceLtDateByVendor(priceFrom, priceTo, manufacture_date,vendor)) {
            System.out.println(notebook);
        }
    }

    private double scanDoubleWithRetry(String message) {
        Double rezult;
        do {
            System.out.println(message);
            rezult = scan.nextDouble();
            if(rezult>0){
                return rezult;
            }else{
                System.out.println("Illegal price format, price < 0 , try again");
            }

        } while (!(rezult > 0));
        return rezult;
    }

    private Date scanDateWithRetry(String message) {
        final String DATE_FORMAT = "mm.dd.yyyy";
        Date date = null;
        String dateStr;
        do {
            System.out.println(message);
            dateStr = scan.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException pe) {
                System.out.println("Illegal date format, correct format is \'" + DATE_FORMAT + "\', try again");
            }
        } while (date == null);
        return date;
    }

    private int scanIntWithRetry(String ageMsg) {
        Integer age = null;
        String ageStr;
        do {
            System.out.println(ageMsg);
            ageStr = scan.nextLine();
            try {
                age = Integer.valueOf(ageStr);
            } catch (NumberFormatException nfe) {
                System.out.println("Not an int value, input again");
            }
        } while (age == null);

        return age;
    }

    private int getInput() {
        int res = -1;
        String inputStr = scan.nextLine();
        try {
            res = Integer.parseInt(inputStr);
        } catch (NumberFormatException nfe) {
            System.out.println("String " + inputStr + " is not a number");
        }

        return res;
    }

    public void showMenu() {
        System.out.println("-----------------");
        System.out.println("1. Show all notebooks");
        System.out.println("2. Add new notebook");
        System.out.println("3. Delete notebook by id");
        System.out.println("4. Change price notebook by id");
        System.out.println("5. Change serial and vendor by id");
        System.out.println("6. Delete notebook by model");
        System.out.println("7. Show all notebooks by vendor");
        System.out.println("8. Show all notebooks by price and date");
        System.out.println("9. Show all notebooks by price from to, date and vendor");
        System.out.println("0. Exit");
    }

}
