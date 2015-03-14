package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;

import java.util.List;

/**
 * Created by Tanya on 19.02.2015.
 */
public interface VendorDao {
    public Long create(Vendor vendor);
    public Vendor read(Long ig);
    public boolean update(Vendor vendor);
    public boolean delete(Vendor vendor);
    public List<Vendor> findAll();
}
