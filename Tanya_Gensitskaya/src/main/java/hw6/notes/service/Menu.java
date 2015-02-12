package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tanya on 11.02.2015.
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
                    default:

                        break;
                }

            }
            printMenu ();

    }
    }


    public void printMenu (){
        System.out.println("Сделайте выбор : \n" +
                "1. Добавить новый ноутбук \n" +
                "2. Показать список ноутбуков \n" +
                "3. Удалить ноутбук по id \n" +
                "4. Изменить цену ноутбука по id \n"+
                "5. Изменить серийный номер и производителя по id \n" +
                "6. Нажмите  Enter для выхода из программы" );
    }

    public  void deleteNtb(Notebook notebook){

    }
    public void changePrice(Notebook notebook){

    }
    public void changeSerialVendor(Notebook notebook){

    }
}
