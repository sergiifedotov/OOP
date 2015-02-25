package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import java.util.Date;
import java.util.List;

/**
 * Created by illia_naumov
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDaoImpl notebookDao;

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(NotebookDaoImpl notebookDao){
        this.notebookDao = notebookDao;
    }
    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return notebookDao.findAll();
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook ntb = notebookDao.read(id);
        ntb.setPrice(price);
        notebookDao.update(ntb);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook ntb = notebookDao.read(id);
        ntb.setSerial(serial);
        ntb.setVendor(vendor);
        notebookDao.update(ntb);
    }

    @Override
    public boolean deleteByModel(String model) {
        List <Notebook> notebooks = notebookDao.findByModel(model);
        int quantity = notebooks.size();
        int deletedNotes = 0;
        if(quantity > 0){
            for(Notebook note:notebooks){
                notebookDao.delete(note);
                deletedNotes++;
            }
            if(deletedNotes == quantity) {return true;}
        }
        return false;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        return notebookDao.findByVendor(vendor);
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        return findByPriceManufDate(price, date);
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
    }
//
}
