package session11.company.dao;

import session11.company.domain.Company;

import java.util.List;

/**
 * Created by warit on 15.02.2015.
 */
public interface CompanyDao {
    Long create(Company company);
    Company read(Long id);
    boolean update(Company company);
    boolean delete(Company company);
    List<Company> findAll();
}
