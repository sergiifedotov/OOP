package hw7.springnotes.service;

import hw7.springnotes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Chuvychin on 27.02.2015.
 */
public interface NotebookService {

    Long createCPU(CPU cpu);
    CPU readCPU(Long ig);
    boolean deleteCPU(CPU cpu);

    Long createNotebook(Notebook notebook);
    Notebook readNotebook(Long ig);
    boolean deleteNotebook(Notebook notebook);

    Long createSales(Sales store);
    Sales readSales(Long ig);

    Long createStore(Store store);
    Store readStore(Long ig);

    Long createVendor(Vendor vendor);
    Vendor readVendor(Long ig);
    boolean deleteVendor(Vendor vendor);

    Long createMemory(Memory memory);
    Memory readMemory(Long ig);
    boolean deleteMemory(Memory memory);
    Long sale(Long storeId, int amount);

    Long receive(Long notebookId, int amount, double price);

    List<Notebook> getNotebooksByPortion(int size);
    List<Notebook> getNotebooksGtAmount(int amount);
    List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor);
    List<Notebook> getNotebooksFromStore();
    List<Notebook> getNotebooksStorePresent();
    Map<Notebook, Integer> getSalesByDays();

    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);

    boolean removeFromStore(Store store, int amount);
}
