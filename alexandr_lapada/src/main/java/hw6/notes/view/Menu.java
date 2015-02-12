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

    public Menu(NotebookServiceImpl notebookService){
        this.notebookService = notebookService;
    }

    public void main(){
        System.out.println("---------MENU----------");
        System.out.println("1 - Add notebook to DB");
        System.out.println("2 - Show all notebooks");
        System.out.println("0 - Exit");
        System.out.println("-----------------------");
        while(true) {
            choose = scan.nextInt();
            if (choose == 0){
                System.out.println("Close...");
                System.exit(0);
            } else if (choose == 1){
                System.out.println("You enter 1");
                addNotebook();
            } else if (choose == 2){
                System.out.println("You enter 2");
                System.out.println(" Id  "+"  Model "+" Date ");
                findAll();

            } else {
                System.err.println("Wrong choice");
            }
        }
    }

    private void addNotebook(){
        notebook = new Notebook();
        System.out.print("Enter serial number - ");
        notebook.setSerial(scan.nextLong());
        System.out.print("Enter vendor - ");
        notebook.setVendor(scan.next());
        System.out.print("Enter model - ");
        notebook.setModel(scan.next());
        System.out.print("Enter price - ");
        notebook.setPrice(scan.nextDouble());

        notebookService.add(notebook);
    }

    private void findAll() {
        ArrayList<Notebook> list = (ArrayList<Notebook>) notebookService.findAll();
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Notebook not = (Notebook) iter.next();
            System.err.println(" " + not.getId() + "   " + not.getModel()+"  "+not.getManufactureDate());
        }
    }
}
