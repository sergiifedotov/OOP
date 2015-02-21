package hw7.notes.view;

import hw7.notes.domain.CPU;
import hw7.notes.service.NotebookService;

import java.util.Scanner;

/**
 * Created by sanya on 17.02.2015.
 */
public class MenuCPU {
    private NotebookService notebookService = null;
    private Scanner scan = new Scanner(System.in);
    public MenuCPU(){

    }

    public MenuCPU(NotebookService notebookService){
        this.notebookService = notebookService;
    }

    public void createCPU() {
        String vendor;
        Double frequency;
        String model;

        System.out.print("Enter frequency cpu - ");
        frequency = scan.nextDouble();
        System.out.print("Enter vendor cpu - ");
        vendor = scan.next();
        System.out.print("Enter model cpu - ");
        model = scan.next();

        CPU cpu = new CPU(vendor, frequency, model);
        notebookService.createCPU(cpu);
    }

    public void readCPU(){
        Long id;

        System.out.print("Enter id - ");
        id = scan.nextLong();
        try {
            System.err.println( notebookService.readCPU(id).getVendor() + " " + notebookService.readCPU(id).getModel());
        }catch(NullPointerException e){
            System.out.println("WRONG ID");
        }
    }
}
