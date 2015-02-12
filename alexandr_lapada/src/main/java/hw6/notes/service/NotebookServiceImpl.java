package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by sanya on 11.02.2015.
 */
public class NotebookServiceImpl implements NotebookService{
    private NotebookDaoImpl notebookDaoImpl;

    public NotebookServiceImpl(NotebookDaoImpl notebookDao){
        this.notebookDaoImpl = notebookDao;
    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDaoImpl.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return notebookDaoImpl.findAll();
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook notebook = null;
        try {
            notebook = notebookDaoImpl.read(id);
            notebook.setPrice(price);
            notebookDaoImpl.update(notebook);
        } catch (NullPointerException e) {
            System.out.println("Wrong ID!!!!");
        };

    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor){
        Notebook notebook = null;
        try {
            notebook = notebookDaoImpl.read(id);
            notebook.setSerial(serial);
            notebook.setVendor(vendor);
            notebookDaoImpl.update(notebook);

        } catch (NullPointerException e) {
            System.out.println("Wrong ID!!!!");
        }
    }

    @Override
    public boolean delete(Long id){
        Notebook notebook = null;
        try {
            notebook = notebookDaoImpl.read(id);
            return notebookDaoImpl.delete(notebook);
        } catch (NullPointerException e) {
            System.out.println("Wrong ID!!!!");
        }finally {
            return false;
        }

    }
}
