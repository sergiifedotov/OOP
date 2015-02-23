package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by sanya on 11.02.2015.
 */
public class Menu {
    private Scanner scan = new Scanner(System.in);
    private Integer choose = null;
    private Notebook notebook;
    private NotebookServiceImpl notebookService;
    private ArrayList<Notebook> list;

    public Menu(NotebookServiceImpl notebookService) {
        this.notebookService = notebookService;
    }

    public void main() {
        System.out.println("---------MENU----------");
        System.out.println("1 - Add notebook to DB");
        System.out.println("2 - Show all notebooks");
        System.out.println("3 - Delete notebook by id");
        System.out.println("4 - Change price notebook by id");
        System.out.println("5 - Change serial and vendor by id");
        System.out.println("6 - Delete notebook by model");
        System.out.println("7 - Show all notebooks by vendor");
        System.out.println("8 - Show all notebooks by price and date");
        System.out.println("9 - Show all notebooks by price from to, date and vendor");
        System.out.println("0 - Exit");
        System.out.println("-----------------------");
        while (true) {
            choose = scan.nextInt();
            if (choose == 0) {
                System.out.println("Close...");
                System.exit(0);
            } else if (choose == 1) {
                addNotebook();
            } else if (choose == 2) {
                findAll();
            } else if (choose == 3) {
                deleteNtb();
            } else if (choose == 4) {
                changePrice();
            } else if (choose == 5) {
                changeSerialVendor();
            } else if (choose == 6) {
                deleteByModel();
            } else if (choose == 7) {
                findByVendor();
            } else if (choose == 8) {
                findByPriceManufDate();
            } else if (choose == 9) {
                findBetweenPriceLtDateByVendor();
            } else {
                System.err.println("Wrong choice");
            }
        }
    }

    private void addNotebook() {
        notebook = new Notebook();
        System.out.print("Enter serial number - ");
        notebook.setSerial(scan.next());
        System.out.print("Enter vendor - ");
        notebook.setVendor(scan.next());
        System.out.print("Enter model - ");
        notebook.setModel(scan.next());
        System.out.print("Enter price - ");
        notebook.setPrice(scan.nextDouble());

        notebookService.add(notebook);
    }

    private void findAll() {
        int id = 0;
        list = (ArrayList<Notebook>) notebookService.findAll();
        System.out.println(" № " + " Id  " + "  Model " + " Price ");
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Notebook not = (Notebook) iter.next();
            System.err.println(" " + id + "   " + not.getId() + "   " + not.getModel() + "  " + not.getPrice());
            id++;
        }
    }

    private void deleteNtb() {
        Long id = null;
        System.out.print("Enter id - ");
        id = scan.nextLong();
        notebookService.delete(id);
    }

    private void changePrice() {
        Long id = null;
        Double price = null;
        System.out.print("Enter id - ");
        id = scan.nextLong();
        System.out.print("Enter new price - ");
        price = scan.nextDouble();
        notebookService.changePrice(id, price);
    }

    private void changeSerialVendor() {
        Long id = null;
        String serial = null;
        String vendor = null;
        System.out.print("Enter id - ");
        id = scan.nextLong();
        System.out.print("Enter new serial - ");
        serial = scan.next();
        System.out.print("Enter new vendor - ");
        vendor = scan.next();
        notebookService.changeSerialVendor(id, serial, vendor);
    }

    private void deleteByModel() {

    }

    private void findByVendor() {
        String vendor = null;
        int id = 0;
        System.out.print("Enter vendor");
        vendor = scan.next();
        list = (ArrayList<Notebook>) notebookService.findByVendor(vendor);
        System.out.println(" № " + " Id  " + "  Model " + " Price ");
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Notebook not = (Notebook) iter.next();
            System.err.println(" " + id + "   " + not.getId() + "   " + not.getModel() + "  " + not.getPrice());
            id++;
        }
    }

    private void findByPriceManufDate() {
        Date date = null;
        Double price = null;
        int id = 0;
        System.out.print("Enter price");
        price = scan.nextDouble();
        System.out.print("Enter date");
        String dateString = scan.next();
        list = (ArrayList<Notebook>) notebookService.findByPriceManufDate(price,date);
        System.out.println(" № " + " Id  " + "  Model " + " Price ");
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Notebook not = (Notebook) iter.next();
            System.err.println(" " + id + "   " + not.getId() + "   " + not.getModel() + "  " + not.getPrice());
            id++;
        }
    }

    private void findBetweenPriceLtDateByVendor() {
        Date date = null;
        Double priceFrom = null;
        Double priceTo = null;
        String vendor = null;
        int id = 0;
        System.out.print("Enter price from");
        priceFrom = scan.nextDouble();
        System.out.print("Enter price to");
        priceTo = scan.nextDouble();
        System.out.print("Enter date");
        String dateString = scan.next();
        System.out.print("Enter vendor");
        vendor = scan.next();
        list = (ArrayList<Notebook>) notebookService.findBetweenPriceLtDateByVendor(priceFrom,priceTo,date,vendor);
        System.out.println(" № " + " Id  " + "  Model " + " Price ");
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Notebook not = (Notebook) iter.next();
            System.err.println(" " + id + "   " + not.getId() + "   " + not.getModel() + "  " + not.getPrice());
            id++;
        }
    }
}
