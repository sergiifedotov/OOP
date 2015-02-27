package hw7.notes.dao;

import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long id);
    boolean update(Vendor vendor);

    boolean delete(Vendor vendor);

    List<Vendor> findAll();
}
