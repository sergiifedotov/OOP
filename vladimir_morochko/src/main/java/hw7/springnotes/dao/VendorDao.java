package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;

import java.util.List;

/**
 * Created by vladimir on 23.02.2015.
 */
public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long id);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    List<Vendor> findAll();
}
