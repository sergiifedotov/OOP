package hw7.notes.service;

import hw7.notes.*;
import hw7.notes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 17.02.2015.
 */
public interface NotebookService {
    Long add(CPU cpu);
    Long add(Memory memory);
    Long add(Vendor vendor);
    Long add(Notebook notebook);

    Long receive(Long notebookId, int amount, double price);
    Long sale(Long storeId, int amount);

    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);

    List<Notebook> getNotebooksByPortion(int size);
    List<Notebook> getNotebooksGtAmount(int amount);
    List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor);
    List<Notebook> getNotebooksFromStore();
    List<Notebook> getNotebooksStorePresent();
    Map<Notebook, Integer> getSalesByDays();

    void close();
}
