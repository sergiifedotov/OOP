package session14.hi.dao;

import session14.hi.domain.Company;

import java.util.List;


public interface CompanyDao {

    Long create(Company company);

    Company read(Long id);

    void update(Company company);

    void delete(Company company);

    List<Company> findAll();

}
