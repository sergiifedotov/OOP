package hw7.notes.service;

import hw7.springnotes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public interface NotebookService {
    public void add(CPU cpu);
    public void add(Memory memory);
    public Long add(Notebook notebook);
    public void add(Sales sales);
    public void add(Store store);
    public void add(Vendor vendor);
    Long receive(Long notebookId, int amount, double price);
    Long sale(Long storeId, int amount);
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);
    public List<Notebook> getNotebooksByPortion(int size);
    public List<Notebook> getNotebooksGtAmount(int amount);
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor);
    public List<Notebook> getNotebooksFromStore();
    public List<Notebook> getNotebooksStorePresent();
    public Map<Notebook, Integer> getSalesByDays();
}
