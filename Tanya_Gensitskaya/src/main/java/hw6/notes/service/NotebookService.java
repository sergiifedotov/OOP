package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;


public interface NotebookService {
    Long add(Notebook notebook);
    List<Notebook> findAll();
    Notebook read(Long id);
    void deleteNtb(Notebook notebook);
    void changePrice(Long id, double price);
    void changeSerialVendor(Long id, String serial, String vendor);

    boolean deleteByModel(String model);
    List<Notebook> findByVendor(String vendor);
    List<Notebook> findByPriceManufDate(Double price, Date date);
    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);
}
