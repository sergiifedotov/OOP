package hw7.springnotes.service;

import hw7.springnotes.dao.GenericDao;
import hw7.springnotes.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 23.02.2015.
 */
@Repository
public class NotebookServiceImpl implements NotebookService {

    @Autowired(required = true)
    GenericDao<Notebook, Long> notebookDao;

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksStorePresent() {
        return null;
    }

    @Override
    public Map<Notebook, Integer> getSalesByDays() {
        return null;
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return false;
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return false;
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return false;
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return false;
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        return false;
    }

    @Override
    public List<Notebook> getNotebooks() {
        return notebookDao.findAll();
    }

}
