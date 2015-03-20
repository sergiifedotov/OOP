package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 26.02.15 // 2:11
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDao notebookDao;

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(NotebookDao dao) {
        notebookDao = dao;
    }



    @Override
    public void add(Notebook notebook) {
        notebookDao.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return notebookDao.findAll();
    }

    @Override
    public Notebook read(Long id) {
        return notebookDao.read(id);
    }

    @Override
    public void deleteNtb(Notebook ntb) {
        notebookDao.delete(ntb);
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook note = notebookDao.read(id);
        note.setPrice((int) price);
        notebookDao.update(note);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook note = notebookDao.read(id);
        note.setSerial(serial);
        note.setVendor(vendor);
        notebookDao.update(note);
    }

    @Override
    public void deleteByModel(String model) {
        notebookDao.findByModel(model).forEach(this::deleteNtb);
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        return notebookDao.findByVendor(vendor);
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        return notebookDao.findByPriceManufDate(price, date);
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return notebookDao.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
    }

}