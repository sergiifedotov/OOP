package hw6.notes.service;
import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;
/**
 * Created by tsv on 14.02.15.
 */
public interface NotebookService {
    public Long add(Notebook notebook);
    public List<Notebook> findAll();
    public boolean deleteNtb(long id);
    public void changePrice(Long id, double price);
    public void changeSerialVendor(Long id, String serial, String vendor);
    public  boolean deleteByModel(String model);
    public void showByVendor(String vendor);
    public void showByPriceManufDate(double Price, String date);
    public void showBetweenPriceLtDateByVendor(double price);
    public List findByVendor( String vendor );
    public List findByPriceManufDate(Double price, Date date );
    public List findBetweenPriceLtDateByVendor(Double min, Double max, Date date, String vendor);
}