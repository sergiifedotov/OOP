package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 11.02.2015.
 *
 * service
 hw6.notes.service.NotebookService
 Long add(Notebook notebook)
 List<Notebook> findAll()
 hw6.notes.service.NotebookServiceImpl
 */
public interface NotebookService {
    Long add(Notebook notebook);
    List<Notebook> findAll();
    void changePrice(Long id, double price);
    void changeSerialVendor(Long id, String serial, String vendor);

    void deleteNtb(Notebook notebook);
    void changePrice(Notebook notebook);
    void changeSerialVendor(Notebook notebook);
    boolean deleteByModel(String model);
    List<Notebook> findByVendor(String vendor);
    List<Notebook> findByPriceManufDate(Double price, Date date);
    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);

    void close();
}
