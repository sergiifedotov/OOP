package session12.company.service;

import session12.company.domain.Company;
import java.util.List;

/**
 *
 */
public interface CompanyService {
    Long add(Company company);
    List<Company> findAll();
}
