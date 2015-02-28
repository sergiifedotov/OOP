package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tanya on 11.02.2015.
 */
public class NotebookServiceImpl implements NotebookService {

    NotebookDaoImpl n = new NotebookDaoImpl();


    @Override
    public Long add(Notebook notebook) {
        Long id = n.create(notebook);
        System.out.println(id);
        return id;
    }

    @Override
    public List<Notebook> findAll() {
        List<Notebook> list = n.findAll();
        return list;
    }

    @Override
    public Notebook read(Long id) {
        Notebook notebook = n.read(id);
        return notebook;
    }

    @Override
    public void deleteNtb(Notebook notebook) {
        n.delete(notebook);
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook notebook = n.read(id);
        notebook.setPrice(price);
        n.update(notebook);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook notebook = n.read(id);
        notebook.setSerial(serial);
        notebook.setVendor(vendor);
        n.update(notebook);
    }

    @Override
    public boolean deleteByModel(String model) {
        List<Notebook> list = n.findByModel(model);
        for (Notebook i : list) {
            n.delete(i);
        }
        return true;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        List<Notebook> list = n.findByVendor(vendor);
        return list;
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        List<Notebook> list = n.findByPriceManufDate(price, date);
        return list;
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        List<Notebook> list = n.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
        return list;
    }

    public Notebook createNewNotebook() {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("введите параметры ноутбука \n" + "PRICE:");
        Double price = scan2.nextDouble();

        System.out.println("SERIAL:");
        String serial = scan2.next();

        System.out.println("VENDOR:");
        String vendor = scan2.next();

        System.out.println("MODEL:");
        String model = scan2.next();
        System.out.println("MANUFACTURE_DATE   (dd.mm.yyyy)  :");
        String manufDate = scan2.next();
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        Date manufactureDate = null;
        try {
            manufactureDate = dateFormat.parse(manufDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Notebook notebook = new Notebook(price, serial, vendor, model, manufactureDate);
        return notebook;

    }
}
