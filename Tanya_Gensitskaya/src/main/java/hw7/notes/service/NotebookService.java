package hw7.notes.service;

import hw7.notes.domain.*;

import java.util.List;

/**
 * Created by Tanya on 20.02.2015.
 */
public interface NotebookService {
    public Long create(CPU cpu);
    public Long create(Memory memory);
    public Long create(Vendor vendor);
    public Long create(Notebook notebook);

    public Long receive(Long notebookId, int amount, double price);
    public Long sale(Long storeId, int amount);


    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);



    public List<Vendor> findAll();
    public Notebook read(Long id);
    public Store readStore(Long ig);
    public boolean update(Store store);

}
