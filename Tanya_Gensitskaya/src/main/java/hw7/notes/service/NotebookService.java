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




    public Long receive(Long id, int amount, double price); // метод не используется
    public Long receive(Notebook id, int amount, double price);
    public Long sale(Store id, int amount);




    public List<Vendor> findAll();
    public Notebook read(Long id);
    public Store readStore(Long ig);
    public boolean update(Store store);

}
