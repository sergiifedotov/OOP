package session12;

import java.util.List;


public interface CompanyDao {
    Long createCompany(Company company);
    Company read(Long id);
    boolean update(Company company);
    boolean delete(Company company);
    List<Company> findAll();

    public void close();
}
