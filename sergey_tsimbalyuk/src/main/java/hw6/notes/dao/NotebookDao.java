package hw6.notes.dao;


import hw6.notes.domain.Notebook;
import java.util.Date;
import java.util.List;

/**
 * Created by tsv on 09.02.15.
 */
public interface NotebookDao {
    public Long create(Notebook ntb);
    public Notebook read(Long ig);
    boolean update(Notebook ntb);
    boolean delete(Notebook ntb);
    public List findByModel(String model);
    public List<Notebook> findAll();
    public List  findByVendor(String vendor);
    public List findByPriceManufDate(Double price ,Date date );
    public List findBetweenPriceLtDateByVendor(Double min, Double max, Date date, String vendor);
}