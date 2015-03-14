package hw7.springnotes.service;

import hw7.springnotes.domain.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vladimir on 17.02.2015.
 */
public class Menu {
    public static void main(String[] args) {
        NotebookService notebookService = new NotebookServiceImpl();
        Long id;
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        try {
            date1 = dateFormat.parse("01.08.2010");
            date2 = dateFormat.parse("01.09.2010");
            date3 = dateFormat.parse("01.01.2011");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Vendor vendor1 = new Vendor("Apple");
        Vendor vendor2 = new Vendor("HP");
        Vendor vendor3 = new Vendor("Intel");
        Vendor vendor4 = new Vendor("AMD");
        Vendor vendor5 = new Vendor("OCZ");
        Vendor vendor6 = new Vendor(("Samsung"));
        id = notebookService.add(vendor1);
        id = notebookService.add(vendor2);
        id = notebookService.add(vendor3);
        id = notebookService.add(vendor4);
        id = notebookService.add(vendor5);
        id = notebookService.add(vendor6);

        CPU cpu1 = new CPU(vendor3, (long) 2400, "Core i5");
        CPU cpu2 = new CPU(vendor3, (long) 2400, "Core i7");
        CPU cpu3 = new CPU(vendor4, (long) 3200, "Opteron");
        id = notebookService.add(cpu1);
        id = notebookService.add(cpu2);
        id = notebookService.add(cpu3);

        Memory memory1 = new Memory(vendor3, 1024);
        Memory memory2 = new Memory(vendor5, 2048);
        Memory memory3 = new Memory(vendor6, 4096);
        Memory memory4 = new Memory(vendor6, 8192);
        id = notebookService.add(memory1);
        id = notebookService.add(memory2);
        id = notebookService.add(memory3);
        id = notebookService.add(memory4);

        Notebook notebook1 = new Notebook(vendor1, "MacBookPro", date1, cpu1, memory4);
        Notebook notebook2 = new Notebook(vendor2, "Pavilion", date2, cpu2, memory3);
        Notebook notebook3 = new Notebook(vendor6, "Kaminsung", date3, cpu3, memory2);
        Long notebookId1 = notebookService.add(notebook1);
        Long notebookId2 = notebookService.add(notebook2);
        Long notebookId3 = notebookService.add(notebook3);

        Long storeId1 = notebookService.receive(notebookId1, 10, (double) 2500);
        Long storeId2 = notebookService.receive(notebookId2, 15, (double) 1500);
        Long storeId3 = notebookService.receive(notebookId3, 20, (double) 1000);

        Long saleId1 = notebookService.sale(storeId1, 5);
        Long saleId2 = notebookService.sale(storeId2, 10);
        Long saleId3 = notebookService.sale(storeId3, 12);

        System.err.println(notebookService.getNotebooksFromStore());
        System.err.println(notebookService.getSalesByDays());
        System.err.println(notebookService.getNotebooksByCpuVendor(vendor3));
        System.err.println(notebookService.getNotebooksGtAmount(5));

        notebookService.close();
    }
}
