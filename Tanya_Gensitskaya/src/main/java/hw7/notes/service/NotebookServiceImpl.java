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
    public Long receive(Notebook id, int amount, double price) {
        Store store = new Store(id, amount, price);
        StoreDaoImpl storeDaoImpl = new StoreDaoImpl();
        return storeDaoImpl.create(store);
    }

    @Override
    public Long receive(Long notebookId, int amount, double price) {
        return 1L;
    }

    @Override
    public Long sale(Store id, int amount) {
        Sales sales = new Sales(id, amount);
        SalesDaoImpl salesDaoImpl = new SalesDaoImpl();
        return salesDaoImpl.create(sales);
    }

    @Override
    public Long sale(Long storeId, int amount) {
        return 1L;
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
