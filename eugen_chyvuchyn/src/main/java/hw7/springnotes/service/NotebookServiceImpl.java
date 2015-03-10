package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Chuvychin on 27.02.2015.
 */

@Component
@Transactional
public class NotebookServiceImpl implements NotebookService {

    @Autowired
    private CPUDao cpuDao;
    @Autowired
    private MemoryDao memoryDao;
    @Autowired
    private NotebookDao notebookDao;
    @Autowired
    private SalesDao salesDao;
    @Autowired
    private StoreDao storeDao;
    @Autowired
    private VendorDao vendorDao;

    public NotebookServiceImpl() {
    }

    @Override
    public Long createCPU(CPU cpu) {
        return null;
    }

    @Override
    public CPU readCPU(Long ig) {
        return null;
    }

    @Override
    public boolean deleteCPU(CPU cpu) {
        return false;
    }

    @Override
    public Long createNotebook(Notebook notebook) {
        return null;
    }

    @Override
    public Notebook readNotebook(Long ig) {
        return null;
    }

    @Override
    public boolean deleteNotebook(Notebook notebook) {
        return false;
    }

    @Override
    public Long createSales(Sales store) {
        return null;
    }

    @Override
    public Sales readSales(Long ig) {
        return null;
    }

    @Override
    public Long createStore(Store store) {
        return null;
    }

    @Override
    public Store readStore(Long ig) {
        return null;
    }

    @Override
    public Long createVendor(Vendor vendor) {
        return null;
    }

    @Override
    public Vendor readVendor(Long ig) {
        return null;
    }

    @Override
    public boolean deleteVendor(Vendor vendor) {
        return false;
    }

    @Override
    public Long createMemory(Memory memory) {
        return null;
    }

    @Override
    public Memory readMemory(Long ig) {
        return null;
    }

    @Override
    public boolean deleteMemory(Memory memory) {
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



    public CPUDao getCpuDao() {
        return cpuDao;
    }

    public void setCpuDao(CPUDao cpuDao) {
        this.cpuDao = cpuDao;
    }

    public MemoryDao getMemoryDao() {
        return memoryDao;
    }

    public void setMemoryDao(MemoryDao memoryDao) {
        this.memoryDao = memoryDao;
    }

    public NotebookDao getNotebookDao() {
        return notebookDao;
    }

    public void setNotebookDao(NotebookDao notebookDao) {
        this.notebookDao = notebookDao;
    }

    public SalesDao getSalesDao() {
        return salesDao;
    }

    public void setSalesDao(SalesDao salesDao) {
        this.salesDao = salesDao;
    }

    public StoreDao getStoreDao() {
        return storeDao;
    }

    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public VendorDao getVendorDao() {
        return vendorDao;
    }

    public void setVendorDao(VendorDao vendorDao) {
        this.vendorDao = vendorDao;
    }
}
