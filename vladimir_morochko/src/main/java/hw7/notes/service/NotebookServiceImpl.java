package hw7.notes.service;

import hw7.notes.*;
import hw7.notes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 17.02.2015.
 */
public class NotebookServiceImpl implements NotebookService {
    @Override
    public Long receive(Long notebookId, int amount, double price) {
        return null;
    }

    @Override
    public Long sale(Long storeId, int amount) {
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
}
