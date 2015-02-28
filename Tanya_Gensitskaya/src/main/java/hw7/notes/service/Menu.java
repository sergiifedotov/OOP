package hw7.notes.service;

import hw7.notes.domain.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tanya on 20.02.2015.
 */
public class Menu {
    private final ArrayList<String> listFromConsole = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private NotebookServiceImpl notebookServiceImpl = new NotebookServiceImpl();

    private CPU cpu;
    private Memory memory;
    private Vendor vendor;

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
                        addCPU();
                        break;
                    case "2":
                        addMemory();
                        break;
                    case "3":
                        addVendor();
                        break;
                    case "4":
                        addNotebook();
                        break;
                    case "5":
                        receive();
                        break;
                    case "6":
                        sale();
                        break;
                    case "7":
                        showVendor();
                        break;
                    case "8":

                        break;
                    case "9":

                        break;
                    default:

                        break;
                }
            }
        }
    }


    public void printMenu() {
        System.out.println("Сделайте выбор : \n" +
                "1.  Создать процессор \n" +
                "2.  Создать память \n" +
                "3.  Создать производителя ноутбука\n" +
                "4.  Создать тип ноутбука (обязательно выполнить п.1,2,3) \n" +
                "5.  Принять на склад партию ноутбуков (тип ноутбука, количество, цена) \n" +
                "6.  Продать указанное количество ноутбуков со склада(id склада, количество)\n" +
                "7.  Посмотреть список производителей компьютеров\n" +
                "8.  \n" +
                "9.  \n" +
                "        \n" +
                "10. Введите (exit) для выхода из программы");
    }


    public void addCPU() {
        System.out.println("Введите производителя CPU:");
        String manufacturer = scan.next();
        System.out.println("Введите частоту CPU:");
        String frequency = scan.next();
        System.out.println("Введите модель CPU:");
        String model = scan.next();
        this.cpu = new CPU(manufacturer, frequency, model);

    }

    public void addMemory() {
        System.out.println("Введите производителя Memory:");
        String manufacturer = scan.next();
        System.out.println("Введите размер Memory:");
        String value = scan.next();
        this.memory = new Memory(manufacturer, value);

    }


    public void addVendor() {
        System.out.println("Введите производителя Notebook:");
        String name = scan.next();
        this.vendor = new Vendor(name);
    }

    public void showVendor(){
    List<Vendor> list = notebookServiceImpl.findAll();
        for(Vendor i: list){
            System.out.println(i + " ");
        }
    }

    public void addNotebook() {
        System.out.println("Введите модель Notebook:");
        String model = scan.next();


        System.out.println("Введите год выпуска (dd.mm.yyyy)");
        String manufDate = scan.next();

        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        Date manufactureDate = null;
        try {
            manufactureDate = dateFormat.parse(manufDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Notebook notebook = new Notebook(model, manufactureDate);
        cpu.addNotebooks(notebook);
        vendor.addNotebooks(notebook);
        memory.addNotebooks(notebook);


        Long id = notebookServiceImpl.create(notebook);
        System.out.println(id);

    }
    public void receive(){
        System.out.println("Введите id ноутбука");
         Long id = scan.nextLong();
        Notebook notebook = notebookServiceImpl.read(id);
        System.out.println("Введите к-во ноутбуков");
        int amount = scan.nextInt();
        System.out.println("Введите стоимость ноутбуков");
        double price = scan.nextDouble();
        notebookServiceImpl.receive(notebook, amount, price);
    }

    public void sale(){
        System.out.println("Введите id склада");
        Long id = scan.nextLong();
        Store store = notebookServiceImpl.readStore(id);
        System.out.println("Введите к-во ноутбуков для продажи");
        int amount = scan.nextInt();
        Integer amountStore = store.getAmount();
        store.setAmount(amountStore- amount);
        notebookServiceImpl.update(store);
        notebookServiceImpl.sale(store, amount);
    }
}
