package Weekend_6_2.springnotes.dao;

import Weekend_6_2.springnotes.domain.Vendor;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long ig);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    List<Vendor> findAll();
}
