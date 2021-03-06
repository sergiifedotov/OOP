package hw7.notes.service;


import hw7.notes.dao.*;
import hw7.notes.domain.*;

import java.util.List;

/**
 * Created by Tanya on 20.02.2015.
 */
public class NotebookServiceImpl implements NotebookService {


    @Override
    public Long create(CPU cpu) {
        CPUDaoImpl cpuDaoimpl = new CPUDaoImpl();
        Long id = cpuDaoimpl.create(cpu);
        return id;
    }

    @Override
    public Long create(Memory memory) {
        return null;
    }

    @Override
    public Long create(Vendor vendor) {
        return null;
    }

    @Override
    public Long create(Notebook notebook) {
        NotebookDaoImpl notebookDaoImpl = new NotebookDaoImpl();
        Long id = notebookDaoImpl.create(notebook);
        return id;
    }



    @Override
    public Long receive(Long notebookId, int amount, double price) {
        NotebookDaoImpl notebookDaoImpl = new NotebookDaoImpl();
        Notebook notebook = notebookDaoImpl.read(notebookId);
        Store store = new Store(notebook, amount, price);
        StoreDaoImpl storeDaoImpl = new StoreDaoImpl();
        return storeDaoImpl.create(store);

    }



    @Override
    public Long sale(Long storeId, int amount) {
        StoreDaoImpl storeDaoImpl = new StoreDaoImpl();
        Store store = storeDaoImpl.read(storeId);
        Sales sales = new Sales(store, amount);
        SalesDaoImpl salesDaoImpl = new SalesDaoImpl();
        return salesDaoImpl.create(sales);
    }




    @Override
    public boolean updateCPU(CPU cpu) {
        CPUDaoImpl cpuDaoImpl = new CPUDaoImpl();
        cpuDaoImpl.update(cpu);
        return true;
    }

    @Override
    public boolean updateMemory(Memory memory) {
        MemoryDaoImpl memoryDaoImpl = new MemoryDaoImpl();
        memoryDaoImpl.update(memory);
        return true;
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        VendorDaoImpl vendorDaoImpl = new VendorDaoImpl();
        vendorDaoImpl.update(vendor);
        return true;
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        NotebookDaoImpl notebookDaoImpl = new NotebookDaoImpl();
        notebookDaoImpl.update(notebook);
        return false;
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        Integer amountStore = store.getAmount();
        Integer newAmount = amountStore -amount;
        store.setAmount(newAmount);
        StoreDaoImpl storeDaoImpl = new StoreDaoImpl();
        storeDaoImpl.update(store);
        return true;
    }









    public List<Vendor> findAll() {
        VendorDaoImpl vendorDaoImpl = new VendorDaoImpl();
        List<Vendor> list = vendorDaoImpl.findAll();
        return list;
    }

    @Override
    public Notebook read(Long id) {
        NotebookDaoImpl notebookDaoImpl = new NotebookDaoImpl();
        Notebook notebook = notebookDaoImpl.read(id);
        return notebook;
    }

    @Override
    public Store readStore(Long ig) {
        StoreDaoImpl storeDaoImpl = new StoreDaoImpl();
        return storeDaoImpl.read(ig);
    }

    @Override
    public boolean update(Store store) {
        StoreDaoImpl storeDaoImpl = new StoreDaoImpl();
        storeDaoImpl.update(store);
        return true;
    }
}
