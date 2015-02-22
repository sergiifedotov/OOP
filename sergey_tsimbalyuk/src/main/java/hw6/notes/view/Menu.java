package hw6.notes.view;

import hw6.notes.domain.Notebook;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tsv on 14.02.15.
 */
class Menu {

}
/*
public class Menu {
    private static Scanner scanInt;
    private static Scanner scan;
    private static NotebookServiceImpl service;
    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");

    public Menu() {
        this.service = new NotebookServiceImpl();
        this.scanInt = new Scanner(System.in);
        this.scan = new Scanner(System.in);
        mainMenu();
    }

    public static int isInteger(){
        int x=-1;
        if(scanInt.hasNextInt()){
            x = scanInt.nextInt();
        }else {
            System.out.println("Неправильный тип ввода ведите целое число (пример: 1, 34, 45)");
            scanInt.nextLine();
        }
        return x;
    }



    public static void manipulationMenu(){
        int choice = -1;
        do{
            System.out.println("\n._________________________________________________________.");
            System.out.println("| Манипуляции с базой данних                              |");
            System.out.println("|_________________________________________________________|");
            System.out.println("| Какую операцию хотите вполнить?                         |");
            System.out.println("| Удалить ноутбук по id -                                1|");
            System.out.println("| Удалить ноутбук по id -                                2|");
            System.out.println("| Изменить цену ноутбука по id -                         3|");
            System.out.println("| Изменить серийный номер и производителя по id -        4|");
            System.out.println("|_________________________________________________________|");
            choice  = isInteger();
        }while(choice<0 || choice>4);
        if(choice == 1){
            deleteNtb(null);
        }if(choice == 2){
            deleteByModel();
        }if(choice == 3){
            changePrice(null);
        }if(choice == 4){
            changeSerialVendor(null);
        }

    }

    public static void showMenu(){
        int choice = -1;
        do{
            System.out.println("\n._________________________________________________________.");
            System.out.println("| Получить ноутбки                              |");
            System.out.println("|_________________________________________________________|");
            System.out.println("| Получить ноутбуки по производителю -                   1|");
            System.out.println("| Получить ноутбуки по цене и году выпоска -             2|");
            System.out.println("| Получить ноутбуки цене в указанном диапазоне, меньше   3|");
            System.out.println("|_________________________________________________________|");
            choice  = isInteger();
        }while(choice<1 || choice>3);
        if(choice == 1){
            showByVendor();
        }if(choice == 2){
            showByPriceManufDate();
        }if(choice == 3){
            showBetweenPriceLtDateByVendor();
        }
    }


    public static void mainMenu(){
        int choice = -1;
        boolean exit = false;
        while(!exit){
            do{
                System.out.println("\n._________________________________________________________.");
                System.out.println("| Главное меню                                            |");
                System.out.println("|_________________________________________________________|");
                System.out.println("| Какую операцию хотите вполнить?                         |");
                System.out.println("| Добавить новый ноутбук -                               1|");
                System.out.println("| Показать базу данних -                                 2|");
                System.out.println("| Манипуляции с базой данных -                           3|");
                System.out.println("| Получить ноутбки -                                     4|");
                System.out.println("| Виход -                                                0|");
                System.out.println("|_________________________________________________________|");
                choice  = isInteger();
            }while(choice<0 || choice>4);
            if(choice == 1){
                addNewNotebook();
            }if(choice == 2){
                showBase();
            }if(choice == 3){
                manipulationMenu();
            }if(choice == 4){
                showMenu();
            }if(choice == 0){
                service.close();
                exit = true;
            }
            choice = -1;
        }
    }

    public static void showBase(){
        List<Notebook> base = service.findAll();
        System.out.println("База \"Ноутбуки\":");
        if(base != null && base.size() != 0){
            for(int i=0;i<base.size();i++){
                System.out.println(base.get(i));
            }
        }else System.out.println("пуста...");
    }
    public static void deleteNtb(Notebook notebook){
        System.out.println("Удалить ноутбук по id");
        System.out.println("Введите id ноутбук который хотите удалить:");
        int id = scanInt.nextInt();
        if(service.deleteNtb(new Long(id))) System.out.println("ноутбук успешно удален!");
        else System.out.println("такого ноутбука в списке нету!");
    }
    public static void changePrice(Notebook notebook){
        System.out.println("Изменение цены нотбука по id");
        System.out.println("Введите id ноутбук:");
        int id = scanInt.nextInt();
        System.out.println("Введите новую цену:");
        double newPrice = scanInt.nextInt();
        service.changePrice(new Long(id),newPrice);
    }
    public static void changeSerialVendor(Notebook notebook){
        System.out.println(" серийный номер и производителя по id");
        System.out.println("Введите id :");
        int id = scanInt.nextInt();
        System.out.println("Введите новуый серийный номер:");
        String newSerial = scan.nextLine();
        System.out.println("Введите нового производителя");
        String newVendor = scan.nextLine();
        service.changeSerialVendor(new Long(id),newSerial,newVendor);
    }
    public static void addNewNotebook(){
        System.out.println("Новый ноутбук");
        System.out.println("Введите серийный номер");
        String serial = scan.nextLine();
        System.out.println("Введите имя продавца:");
        String vendor = scan.nextLine();
        System.out.println("Введите модель:");
        String model = scan.nextLine();
        System.out.println("Введите ман.:");
        String manufacture = scan.nextLine();
        System.out.println("Введите цену:");
        String price = scan.nextLine();
        Notebook newNotebook = new Notebook(serial,model,vendor,manufacture,format.format(new Date()),price);
        System.out.println("создан новй ноутбук:");
        System.out.println(newNotebook);
        service.add(newNotebook);
    }

    public static void showByVendor(){
        System.out.println("Ноутбуки по производителю ");
        System.out.println("Введите производителя:");
        String vendor = scan.nextLine();
        service.showByVendor(vendor);
    }
    public static void showByPriceManufDate(){
        System.out.println("Получить ноутбуки по цене и году выпоска");
        System.out.println("Введите цену:");
        double Price =  scanInt.nextInt();
        System.out.println("ведите дату выпуска:");
        String date = scan.nextLine();
        service.showByPriceManufDate(Price, date);
    }
    public static void showBetweenPriceLtDateByVendor(){
        System.out.println("Получить ноутбуки цене в указанном диапазоне, меньше:");
        System.out.println("Введите диапазон меньше которого");
        double price =-1;
        do{
            price = scanInt.nextInt();
        }while (price<-1);
        service.showBetweenPriceLtDateByVendor(price);
    }

    public static void deleteByModel(){
        System.out.println("Удалить ноутбук по Модели");
        System.out.println("Введите модель ноутбук который хотите удалить:");
        String model = scan.nextLine();
        service.deleteByModel(model);
    }
    public static void main(String[] args) {
        new Menu();
    }
}*/
