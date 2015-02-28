package hw6.notes.service;
import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;
/**
 * Created by tsv on 14.02.15.
 */
public interface NotebookService {
    void add(Notebook notebook);
    List<Notebook> findAll();
    Notebook read(Long id);

    void deleteNtb(Notebook ntb);
    void changePrice(Long id, double price);
    void changeSerialVendor(Long id, String serial, String vendor);
    void deleteByModel(String model);

    List<Notebook> findByVendor(String vendor);
    List<Notebook> findByPriceManufDate(Double price, Date date);
    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);

}