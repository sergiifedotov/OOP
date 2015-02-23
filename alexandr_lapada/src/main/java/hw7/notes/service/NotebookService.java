package hw7.notes.service;

import hw7.notes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by sanya on 17.02.2015.
 */
public interface NotebookService {

    Long receive(Long id, int amount, double price);

    Long sale(Long id, int amount);

    boolean removeFromStore(Store store, int amount);

    List<Notebook> getNotebooksByPortion(int size);

    List<Notebook> getNotebooksGtAmount(int amount);

    List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor);

    List<Notebook> getNotebooksStorePresent();

    Map<Notebook, Integer> getSalesByDays();

    List<Notebook> getNotebooksFromStore();

    //---------CPU

    Long createCPU(CPU cpu);

    CPU readCPU(Long id);

    boolean updateCPU(CPU cpu);

    boolean deleteCPU(CPU cpu);

    List<CPU> findAllCPU();

    //--------MEMORY

    Long createMemory(Memory memory);

    Memory readMemory(Long id);

    boolean updateMemory(Memory memory);

    boolean deleteMemory(Memory memory);

    List<Memory> findAllMemory();

    //------VENDOR

    Long createVendor(Vendor vendor);

    Vendor readVendor(Long id);

    boolean updateVendor(Vendor vendor);

    boolean deleteVendor(Vendor vendor);

    List<Vendor> findAllVendor();

    //---------NOTEBOOK

    Long createNotebook(Notebook notebook);

    Notebook readNotebook(Long id);

    boolean updateNotebook(Notebook notebook);

    boolean deleteNotebook(Notebook notebook);

    List<Notebook> findAllNotebook();

    //------------STORE

    Long createStore(Store store);

    Store readStore(Long id);

    boolean updateStore(Store store);

    boolean deleteStore(Store store);

    List<Store> findAllStore();

    //-----------SALES

    Long create(Sales sales);

    Sales readSales(Long id);

    boolean updateSales(Sales sales);

    boolean deleteSales(Sales sales);

    List<Sales> findAllSales();

}
