package hw6.notes.view;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookServiceImpl;

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
        System.out.println("0 - Exit");
        System.out.println("-----------------------");
        while (true) {
            choose = scan.nextInt();
            if (choose == 0) {
                System.out.println("Close...");
                System.exit(0);
            } else if (choose == 1) {
                System.out.println("You enter 1");
                addNotebook();
            } else if (choose == 2) {
                System.out.println("You enter 2");
                findAll();
            } else if (choose == 3) {
                deleteNtb();
            } else if (choose == 4) {
                changePrice();
            } else if (choose == 5) {
                changeSerialVendor();
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

    }
}
