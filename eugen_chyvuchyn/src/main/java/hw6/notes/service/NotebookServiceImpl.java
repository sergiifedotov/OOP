package hw6.notes.service;


import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Chuvychin on 09.02.2015.
 */


public class NotebookServiceImpl implements NotebookService {

private NotebookDaoImpl notebookDao;

    public NotebookServiceImpl(NotebookDaoImpl noteDao){
        notebookDao = noteDao;
    }

    @Override
    public Long add(Notebook notebook) {

        return notebookDao.create(notebook);
    }

    public NotebookServiceImpl() {
    }

    @Override
    public List<Notebook> findAll() {

        return notebookDao.findAll();
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook temp = notebookDao.read(id);
        temp.setPrice(price);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook temp = notebookDao.read(id);
        temp.setVendor(vendor);
        temp.setSerial(serial);
        notebookDao.update(temp);
    }

    @Override
    public boolean delete(Long id) {

        return notebookDao.delete(notebookDao.read(id));
    }

    @Override
    public boolean deleteByModel(String model) {
        List<Notebook> templist = notebookDao.findByModel(model);
        boolean result = false;
        for (Notebook temp:templist){

            result = notebookDao.delete(temp);
            if (result ==false){
                System.out.println("Не удаляется"+ temp.toString());
                return result;
            }

        }
        return result;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        return notebookDao.findByVendor(vendor);
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        return notebookDao.findByPriceManufDate(price,date);
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return notebookDao.findBetweenPriceLtDateByVendor(priceFrom,priceTo,date,vendor);
    }
}
