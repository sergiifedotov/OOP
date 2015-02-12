package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 11.02.2015.
 */
public class Menu {
    public static void main(String[] args) {
        NotebookService notebookService = new NotebookServiceImpl();
        Long id;
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("01.08.2010");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        id = notebookService.add(new Notebook("Macbook", "Apple",(double)  2500, date, "12345"));
        id = notebookService.add(new Notebook("Pavilion", "HP", (double) 1500, date, "54321"));
        System.out.println(notebookService.findAll());
        notebookService.close();
    }

    void deleteNtb(Notebook notebook) {
    }

    void changePrice(Notebook notebook) {
    }

    void changeSerialVendor(Notebook notebook){
    }

    boolean deleteByModel(String model) {
        return false;
    }

    List<Notebook> findByVendor(String vendor) {
        return null;
    }

    List<Notebook> findByPriceManufDate(Double price, Date date) {
        return null;
    }

    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return null;
    }
}
