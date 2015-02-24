package hw7.springnotes.service;

import hw7.springnotes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 23.02.2015.
 */
public interface NotebookService {
    List<Notebook> getNotebooksByPortion(int size);
    List<Notebook> getNotebooksGtAmount(int amount);
    List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor);
    List<Notebook> getNotebooksFromStore();
    List<Notebook> getNotebooksStorePresent();
    Map<Notebook, Integer> getSalesByDays();
    void updateCPU(CPU cpu);
    void updateMemory(Memory memory);
    void updateVendor(Vendor vendor);
    void updateNotebook(Notebook notebook);
    void removeFromStore(Store store, int amount);

    List<Notebook> getNotebooks();
    void close();
}
