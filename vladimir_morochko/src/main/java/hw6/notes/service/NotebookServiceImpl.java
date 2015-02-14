package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 11.02.2015.
 *
 * service
 hw6.notes.service.NotebookService
 Long add(Notebook notebook)
 List<Notebook> findAll()
 hw6.notes.service.NotebookServiceImpl
 */

public class NotebookServiceImpl implements NotebookService {
    private NotebookDao notebookDao = new NotebookDaoImpl();

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(NotebookDaoImpl notebookDaoImpl) {
        this.notebookDao = notebookDaoImpl;
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
        Notebook notebook = notebookDao.read(id);
        notebook.setPrice(price);
        notebookDao.update(notebook);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook notebook = notebookDao.read(id);
        notebook.setSerial(serial);
        notebook.setVendor(vendor);
        notebookDao.update(notebook);
    }

    @Override
    public void deleteNtb(Notebook notebook) {
        notebookDao.delete(notebook);
    }

    @Override
    public void changePrice(Notebook notebook) {
        // TODO
    }

    @Override
    public void changeSerialVendor(Notebook notebook) {

        // TODO
    }

    @Override
    public boolean deleteByModel(String model) {
        List<Notebook> list = notebookDao.findByModel(model);
        if (list != null && list.size() > 0) {
            for (Notebook notebook : list) {
                notebookDao.delete(notebook);
            }
            return true;
        }
        return false;
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

    public void close() {
        notebookDao.close();
    }
}
