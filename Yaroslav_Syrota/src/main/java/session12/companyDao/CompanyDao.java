package session12.companyDao;

import java.util.List;
import java.util.Set;

/**
 * Created by @CAT_Caterpiller on 15.02.2015.
 */

public interface CompanyDao {
    Long createCompany(Company company);
    Company read(Long id);
    boolean update(Company company);
    boolean delete(Company company);
    List<Company> findAll();

    public void close();
}
