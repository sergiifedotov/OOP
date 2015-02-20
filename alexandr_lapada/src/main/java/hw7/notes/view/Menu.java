package hw7.notes.view;

import hw7.notes.domain.*;
import hw7.notes.service.NotebookService;
import hw7.notes.service.NotebookServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sanya on 17.02.2015.
 */
public class Menu {
    private Integer choose = null;
    private Scanner scan = new Scanner(System.in);
    private NotebookServiceImpl notebookService = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");

    public Menu() {

    }

    public Menu(NotebookServiceImpl notebookService) {
        this.notebookService = notebookService;
    }

    public void main() {
        viewMenu();
        while (true) {
            choose = scan.nextInt();
            if (choose == 0) {
                System.out.println("Close...");
                System.exit(0);
            } else if (choose == 1) {
                createCPU();
            } else if (choose == 2) {
                createMemory();
            } else if (choose == 3) {
                createVendor();
            } else if (choose == 4) {
                createNotebook();
            } else if (choose == 5) {
                createStore();
            } else if (choose == 6) {
                readCPU();
            } else if (choose == 7) {
                readMemory();
            } else if (choose == 8) {
                readVendor();
            } else if (choose == 9) {
                readNotebook();
            } else if (choose == 10) {
                readStore();
            } else if (choose == 11) {
                showAllCPUs();
            } else if (choose == 12) {
                showAllMemories();
            } else if (choose == 13) {
                showAllVendors();
            } else if (choose == 14) {
                showAllNotebooks();
            } else if (choose == 15) {
                showAllStore();
            } else if (choose == 16) {
                updateCPU();
            } else if (choose == 17) {
                updateMemory();
            } else if (choose == 18) {
                updateVendor();
            } else if (choose == 19) {
                updateNotebook();
            } else if (choose == 21) {
                showAllNotebookByVendor();
            } else if (choose == 22) {
                showAllNotebookByCPUVendor();
            } else if (choose == 23) {
                showAllNotebookGTAmount();
            } else if (choose == 24) {
                showPortionNotebooks();
            } else if (choose == 25) {
                removeFromStore();
            } else if (choose == 26) {
                saleNotebookFromStore();
            } else {
                System.out.println("Wrong number!!!");
            }
        }
    }

    public void viewMenu(){
        System.out.println("---------MENU---------");
        System.out.println("1 - Create CPU");
        System.out.println("2 - Create memory");
        System.out.println("3 - Create vendor");
        System.out.println("4 - Create notebook");
        System.out.println("5 - Create(receive) store");
        System.out.println("6 - Get CPU");
        System.out.println("7 - Get memory");
        System.out.println("8 - Get vendor");
        System.out.println("9 - Get notebook");
        System.out.println("10 - Get store");
        System.out.println("11 - Show all CPUs");
        System.out.println("12 - Show all memories");
        System.out.println("13 - Show all vendors");
        System.out.println("14 - Show all notebooks");
        System.out.println("15 - Show all stores");
        System.out.println("16 - Update CPU");
        System.out.println("17 - Update memory");
        System.out.println("18 - Update vendor");
        System.out.println("19 - Update notebook");
        System.out.println("21 - Show all notebook by vendor");
        System.out.println("22 - Show all notebook by cpu vendor");
        System.out.println("23 - Show all notebook greater than amount");
        System.out.println("24 - Show portion notebooks");
        System.out.println("25 - Remove from store notebook");
        System.out.println("26 - (Create) Sale notebook from store");
        System.out.println("0 - Exit");
        System.out.println("-----------------------");
    }

    private void removeFromStore(){
        showAllStore();
        System.out.println("Choose store id for remove notebook");
        Store store = notebookService.readStore(scan.nextLong());
        System.out.print("Enter quantity for remove - ");
        notebookService.removeFromStore(store, scan.nextInt());
    }

    private void saleNotebookFromStore(){
        showAllStore();
        System.out.println("Choose store id for sale notebooks - ");
        Long id = scan.nextLong();
        System.out.print("Enter notebooks quantity for sale - ");
        notebookService.sale(id,scan.nextInt());
    }

    private void showPortionNotebooks(){
        System.out.print("Enter portion please - ");
        ArrayList<Notebook> list = (ArrayList<Notebook>)notebookService.getNotebooksByPortion(scan.nextInt());
        System.err.println(" ID "+" Vendor "+" Model "+"Date"+" CPU "+" Memory ");
        for (int i = 0; i < list.size(); i++){
            Notebook notebook = list.get(i);
            System.err.println(notebook.getId()+" "+notebook.getVendor().getName()+" "+notebook.getModel()+" "+dateFormat.format(notebook.getDate())
                    +" "+notebook.getCpu().getModel()+" "+notebook.getMemory().getSize());
        }
    }

    private void showAllNotebookGTAmount(){
        System.out.print("Enter amount please - ");
        ArrayList<Notebook> list = (ArrayList<Notebook>)notebookService.getNotebooksGtAmount(scan.nextInt());
        System.err.println(" ID "+" Vendor "+" Model "+"Date"+" CPU "+" Memory ");
        for (int i = 0; i < list.size(); i++){
            Notebook notebook = list.get(i);
            System.err.println(notebook.getId()+" "+notebook.getVendor().getName()+" "+notebook.getModel()+" "+dateFormat.format(notebook.getDate())
                    +" "+notebook.getCpu().getModel()+" "+notebook.getMemory().getSize());
        }
    }

    private void showAllNotebookByCPUVendor(){
        System.out.print("Enter vendor please - ");
        ArrayList<Notebook> list = (ArrayList<Notebook>)notebookService.getNotebooksByCpuVendor(scan.next());
        System.err.println(" ID "+" Vendor "+" Model "+"Date"+" CPU "+" Memory ");
        for (int i = 0; i < list.size(); i++){
            Notebook notebook = list.get(i);
            System.err.println(notebook.getId()+" "+notebook.getVendor().getName()+" "+notebook.getModel()+" "+dateFormat.format(notebook.getDate())
                    +" "+notebook.getCpu().getModel()+" "+notebook.getMemory().getSize());
        }
    }

    private void showAllNotebookByVendor(){
        ArrayList<Notebook> list = (ArrayList<Notebook>)notebookService.getNotebooksStorePresent();
        System.err.println(" ID "+" Vendor "+" Model "+"Date"+" CPU "+" Memory ");
        for (int i = 0; i < list.size(); i++){
            Notebook notebook = list.get(i);
            System.err.println(notebook.getId()+" "+notebook.getVendor().getName()+" "+notebook.getModel()+" "+dateFormat.format(notebook.getDate())
                    +" "+notebook.getCpu().getModel()+" "+notebook.getMemory().getSize());
        }
    }


    //-----------CREATE----------

    private void createCPU() {
        CPU cpu = new CPU();
        System.out.print("Enter frequency cpu - ");
        cpu.setFrequency(scan.nextDouble());
        System.out.print("Enter vendor cpu - ");
        cpu.setVendor(scan.next());
        System.out.print("Enter model cpu - ");
        cpu.setModel(scan.next());
        notebookService.createCPU(cpu);
        viewMenu();
    }

    private void createMemory() {
        Memory memory = new Memory();
        System.out.print("Enter vendor memory - ");
        memory.setVendor(scan.next());
        System.out.print("Enter memory size - ");
        memory.setSize(scan.nextInt());
        viewMenu();
    }

    private void createVendor() {
        Vendor vendor = new Vendor();
        System.out.print("Enter name vendor");
        vendor.setName(scan.next());
        notebookService.createVendor(vendor);
        viewMenu();
    }

    private void createNotebook() {
        Date date = null;
        Notebook notebook = new Notebook();

        System.out.print("Enter manufacture date. dd.mm.yyyy - ");
        try {
            date = dateFormat.parse(scan.next());
            notebook.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        showAllVendors();
        System.out.println("Choose id vendor please - ");
        notebook.setVendor(notebookService.readVendor(scan.nextLong()));

        System.out.print("Enter model - ");
        notebook.setModel(scan.next());

        showAllCPUs();
        System.out.println("Choose id CPU please - ");
        notebook.setCpu(notebookService.readCPU(scan.nextLong()));

        showAllMemories();
        System.out.println("Choose id memory please - ");
        notebook.setMemory(notebookService.readMemory(scan.nextLong()));

        notebookService.createNotebook(notebook);
        viewMenu();
    }

    private void createStore(){
        showAllNotebooks();
        System.out.println("Choose id notebook please - ");
        Notebook notebook = notebookService.readNotebook(scan.nextLong());
        System.out.print("Enter quantity notebooks - ");
        Integer quantity = scan.nextInt();
        System.out.print("Enter price for notebook - ");
        Double price = scan.nextDouble();
        notebookService.receive(notebook, quantity, price);
        viewMenu();
    }

    //-----------UPDATE--------------

    private void updateCPU(){
        showAllCPUs();
        System.out.println("Choose cpu id for update");
        CPU cpu = notebookService.readCPU(scan.nextLong());
        System.err.println("Old vendor - "+cpu.getVendor());
        System.out.print("Enter new vendor - ");
        cpu.setVendor(scan.next());
        System.err.println("Old model - "+cpu.getModel());
        System.out.print("Enter new model - ");
        cpu.setModel(scan.next());
        System.err.println("Old frequency - "+cpu.getFrequency());
        System.out.print("Enter new frequency - ");
        cpu.setFrequency(scan.nextDouble());
        notebookService.updateCPU(cpu);
    }

    private void updateMemory(){
        showAllMemories();
        System.out.println("Choose memory id for update");
        Memory memory = notebookService.readMemory(scan.nextLong());
        System.err.println("Old vendor - "+memory.getVendor());
        System.out.print("Enter new vendor - ");
        memory.setVendor(scan.next());
        System.err.println("Old size - "+memory.getSize());
        System.out.print("Enter new size - ");
        memory.setSize(scan.nextInt());
        notebookService.updateMemory(memory);
    }

    private void updateVendor(){
        showAllVendors();
        System.out.println("Choose vendor id for update");
        Vendor vendor = notebookService.readVendor(scan.nextLong());
        System.err.println("Old name - "+vendor.getName());
        System.out.print("Enter new name - ");
        vendor.setName(scan.next());
        notebookService.updateVendor(vendor);
    }

    private void updateNotebook(){
        showAllNotebooks();
        System.out.println("Choose notebook id for update - ");
        Notebook notebook = notebookService.readNotebook(scan.nextLong());
        System.err.println("Old model - "+notebook.getModel());
        System.out.print("Enter new model - ");
        notebook.setModel(scan.next());
        System.err.println("Old date - "+notebook.getDate());
        System.out.print("Enter new date. dd.mm.yyyy - ");
        try {
            Date date = dateFormat.parse(scan.next());
            notebook.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        notebookService.updateNotebook(notebook);

    }

    //---------------READ-----------

    private CPU readCPU() {
        CPU cpu = null;
        System.out.print("Enter id - ");
        Long id = scan.nextLong();
        try {
            cpu = notebookService.readCPU(id);
            System.err.println(" " + cpu.getId() + "    " + cpu.getVendor() + "   " + cpu.getModel() + "  " + cpu.getFrequency());
        } catch (NullPointerException e) {
            System.out.println("WRONG ID");
        }
        return cpu;
    }

    private Memory readMemory(){
        Memory memory = null;
        System.out.print("Enter id - ");
        Long id = scan.nextLong();
        try {
            memory = notebookService.readMemory(id);
            System.err.println(" " + memory.getId() + "    " + memory.getVendor() + "    " + memory.getSize());
        } catch (NullPointerException e) {
            System.out.println("WRONG ID");
        }
        return memory;
    }

    private Vendor readVendor(){
        Vendor vendor = null;
        System.out.print("Enter id - ");
        Long id = scan.nextLong();
        try {
            vendor = notebookService.readVendor(id);
            System.err.println(" " + vendor.getId() + "    " + vendor.getName());
        } catch (NullPointerException e) {
            System.out.println("WRONG ID");
        }
        return vendor;
    }

    private Notebook readNotebook(){
        return null;
    }

    private Store readStore(){
        Store store = null;
        return store;
    }

    //--------------FINDALL---------------

    private void showAllVendors() {
        ArrayList<Vendor> list = (ArrayList<Vendor>) notebookService.findAllVendor();
        System.err.println("--------Vendor---------");
        System.err.println("ID" + "    " + "NAME");
        for (int i = 0; i < list.size(); i++) {
            Vendor vendor = list.get(i);
            System.err.println(" " + vendor.getId() + "    " + vendor.getName());
        }
    }

    private void showAllCPUs() {
        ArrayList<CPU> list = (ArrayList<CPU>) notebookService.findAllCPU();
        System.err.println("------------------CPU------------------");
        System.err.println("ID" + "    " + "VENDOR" + "    " + "MODEL" + "    " + "FREQUENCY");
        for (int i = 0; i < list.size(); i++) {
            CPU cpu = list.get(i);
            System.err.println(" " + cpu.getId() + "    " + cpu.getVendor() + "   " + cpu.getModel() + "  " + cpu.getFrequency());
        }
    }

    private void showAllMemories() {
        ArrayList<Memory> list = (ArrayList<Memory>) notebookService.findAllMemory();
        System.err.println("------------Memory-----------");
        System.err.println("ID" + "    " + "VENDOR" + "    " + "SIZE");
        for (int i = 0; i < list.size(); i++) {
            Memory memory = list.get(i);
            System.err.println(" " + memory.getId() + "    " + memory.getVendor() + "    " + memory.getSize());
        }
    }

    private void showAllNotebooks(){
        ArrayList<Notebook> list = (ArrayList<Notebook>) notebookService.findAllNotebook();
        System.err.println("---------Notebook---------");
        System.err.println(" ID "+" Vendor "+" Model "+" CPU "+" Memory ");
        for (int i = 0; i < list.size(); i++){
            Notebook notebook = list.get(i);
            System.err.println(" "+notebook.getId()+" "+notebook.getVendor().getName()+" "+notebook.getModel()+" "+notebook.getCpu().getModel()+" "+notebook.getMemory().getSize());
        }
    }

    private void showAllStore(){
        ArrayList<Store> list = (ArrayList<Store>) notebookService.findeAllStore();
        System.err.println("---------Notebook---------");
        System.err.println(" ID "+" Quantity ");
        for (int i = 0; i < list.size(); i++){
            Store store = list.get(i);
            System.err.println(" "+store.getId()+" "+store.getQuantity());
        }
    }

}
